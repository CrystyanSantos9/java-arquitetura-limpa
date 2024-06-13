package br.com.alura.codechella.infraestrutura.gateways;

import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infraestrutura.persistence.EnderecoEntity;
import br.com.alura.codechella.infraestrutura.persistence.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {

    @Mapping (source = "endereco", target = "enderecoEntity")
    UsuarioEntity toUsuarioEntity(Usuario usuario);

    @Mapping (source = "enderecoEntity", target = "endereco")
    Usuario toUsuario(UsuarioEntity usuarioEntity);

    List<Usuario> toUsuarioList(List<UsuarioEntity> listUsurioEntity);


    EnderecoEntity toEnderecoEntity(Endereco endereco);


    Endereco toEndereco(EnderecoEntity endereco);
}
