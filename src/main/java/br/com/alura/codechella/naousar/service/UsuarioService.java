package br.com.alura.codechella.naousar.service;

import br.com.alura.codechella.infraestrutura.persistence.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
    UsuarioEntity cadastrarUsuario(UsuarioEntity usuario);

    List<UsuarioEntity> listarTodos();
}
