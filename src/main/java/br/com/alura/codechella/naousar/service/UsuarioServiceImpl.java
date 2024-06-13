package br.com.alura.codechella.naousar.service;

import br.com.alura.codechella.infraestrutura.persistence.UsuarioEntity;
import br.com.alura.codechella.infraestrutura.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<UsuarioEntity> listarTodos() {
        return repository.findAll();
    }
}
