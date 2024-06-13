package br.com.alura.codechella.infraestrutura.Controller;

import java.util.Objects;

public record ResponseUsuarioDTO(Long id, String cpf, String nome, String email, EnderecoDTO enderecoDTO) {
    public ResponseUsuarioDTO {
        if(Objects.isNull (enderecoDTO)){
            enderecoDTO = new EnderecoDTO ("", 0, "");
        }
    }
}
