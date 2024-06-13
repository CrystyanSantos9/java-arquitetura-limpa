package br.com.alura.codechella.infraestrutura.Controller;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

public record UsuarioDTO(String cpf, String nome, String nascimento, String email, EnderecoDTO enderecoDTO) {}


