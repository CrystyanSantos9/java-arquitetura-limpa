package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable {

    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;

    @Default
    public Usuario(Long id, String cpf, String nome, LocalDate nascimento, String email, Endereco endereco) {

        if (cpf == null || !cpf.matches ("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException ("CPF no padrão incorreto!");
        }

        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public Usuario(String nome, String cpf, LocalDate nascimento) {

        if (cpf == null || !cpf.matches ("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException ("CPF no padrão incorreto!");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        if (cpf == null || !cpf.matches ("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException ("CPF no padrão incorreto!");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Usuario(String cpf, String nome, LocalDate nascimento, String email, Endereco endereco) {
        if (cpf == null || !cpf.matches ("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException ("CPF no padrão incorreto!");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public Usuario(Builder builder) {
        if (builder.cpf == null || !builder.cpf.matches ("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException ("CPF no padrão incorreto!");
        }

        this.id = builder.id;
        this.cpf = builder.cpf;
        this.nome = builder.nome;
        this.nascimento = builder.nascimento;
        this.email = builder.email;
        this.endereco = builder.endereco;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }

    public static class Builder {
        private Long id;
        private String cpf;
        private String nome;
        private LocalDate nascimento;
        private String email;
        private Endereco endereco;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder nascimento(LocalDate nascimento) {
            this.nascimento = nascimento;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder endereco(Endereco endereco) {
            this.endereco = endereco;
            return this;
        }

        public Usuario build() {
            return new Usuario (this);
        }

    }

}
