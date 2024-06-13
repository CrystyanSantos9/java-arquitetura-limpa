package br.com.alura.codechella.infraestrutura.Controller;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infraestrutura.persistence.UsuarioEntity;
import br.com.alura.codechella.naousar.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseUsuarioDTO> cadastrar(@RequestBody UsuarioDTO dto, UriComponentsBuilder uriBuilder) {
        Usuario usuarioSalvo = criarUsuario
                .criarUsuario
                        (
                        new Usuario
                            (
                                dto.cpf (), dto.nome (), LocalDate.parse (dto.nascimento ()), dto.email (),
                                new Endereco (dto.enderecoDTO ().cep (), dto.enderecoDTO ().numero (), dto.enderecoDTO ().complemento ())
                            )
                        );

        var uri = uriBuilder.path ("/usuarios/{id}").buildAndExpand (usuarioSalvo.getId ()).toUri ();

        return ResponseEntity.created(uri).body(
                new ResponseUsuarioDTO (usuarioSalvo.getId (), usuarioSalvo.getCpf (), usuarioSalvo.getNome (),
                        usuarioSalvo.getEmail (), new EnderecoDTO (
                                usuarioSalvo.getEndereco ().getCep (),
                        usuarioSalvo.getEndereco ().getNumero (),
                        usuarioSalvo.getEndereco ().getComplemento ())));
    }

    @GetMapping
    public List<ResponseUsuarioDTO> listarUsuarios(){
        return listarUsuarios.listarTodos ().stream().map (usuario ->
                new ResponseUsuarioDTO (usuario.getId (), usuario.getCpf (), usuario.getNome (),
                        usuario.getEmail (),
                        Objects.nonNull (usuario.getEndereco ()) ?
                                new EnderecoDTO (
                                        usuario.getEndereco ().getCep (),
                                        usuario.getEndereco ().getNumero (),
                                        usuario.getEndereco ().getComplemento ())
                                :
                                new EnderecoDTO ("", 0, "")
                )).toList ();
    }

}
