package br.com.alura.codechella.infraestrutura.Controller;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
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
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO dto, UriComponentsBuilder uriBuilder) {
       Usuario usuarioSalvo = criarUsuario.criarUsuario (new Usuario (dto.cpf (),dto.nome (), LocalDate.parse (dto.nascimento ()), dto.email ()));
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(
                new UsuarioDTO (usuarioSalvo.getCpf (), usuarioSalvo.getNome (), usuarioSalvo.getNascimento ().toString (), usuarioSalvo.getEmail ()));
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return listarUsuarios.listarTodos ().stream().map (usuario ->
                new UsuarioDTO (usuario)).toList ();
    }

}
