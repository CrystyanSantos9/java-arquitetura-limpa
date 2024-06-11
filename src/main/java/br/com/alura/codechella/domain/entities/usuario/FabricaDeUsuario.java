package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;

public class FabricaDeUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento){
        this.usuario = new Usuario (nome,cpf, nascimento);
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento){
        this.usuario.setEndereco(new Endereco (cep, numero, complemento));
        return this.usuario;
    }
}
