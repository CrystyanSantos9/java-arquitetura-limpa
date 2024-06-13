package br.com.alura.codechella.infraestrutura.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infraestrutura.persistence.UsuarioEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {
    UsuarioEntity toUsuarioEntity(Usuario usuario);

    Usuario toUsuario(UsuarioEntity usuarioEntity);

    List<Usuario> toUsuarioList(List<UsuarioEntity> listUsurioEntity);
}
