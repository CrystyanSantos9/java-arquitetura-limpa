package br.com.alura.codechella.infraestrutura.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infraestrutura.persistence.UsuarioRepository;

import java.util.List;

public class RepositorioDeUsuarioJPA implements RepositorioDeUsuario {

    private final UsuarioEntityMapper mapper;

    private final UsuarioRepository repository;

    public RepositorioDeUsuarioJPA(UsuarioEntityMapper mapper, UsuarioRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Usuario cadastraUsuario(Usuario usuario) {
        return mapper.toUsuario (repository.save (mapper.toUsuarioEntity (usuario)));
    }

    @Override
    public List<Usuario> listarTodos() {
        return mapper.toUsuarioList (repository.findAll ());
    }
}
