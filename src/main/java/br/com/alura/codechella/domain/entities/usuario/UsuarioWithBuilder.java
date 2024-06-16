package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;

public class UsuarioWithBuilder {

    private Long id;
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;

    public UsuarioWithBuilder(UsuarioBuilder builder) {

        if(builder.cpf == null || !builder.cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException("CPF no padrão incorreto!");
        }

        this.id = builder.id;
        this.cpf = builder.cpf;
        this.nome = builder.nome;
        this.nascimento = builder.nascimento;
        this.email = builder.email;
        this.endereco = builder.endereco;
    }

    public static class UsuarioBuilder {
        private Long id;
        private String cpf;
        private String nome;
        private LocalDate nascimento;
        private String email;
        private Endereco endereco;

        public UsuarioBuilder id(Long id){
            this.id = id;
            return this;
        }

        public UsuarioBuilder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public UsuarioBuilder nome(String nome){
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder nascimento(LocalDate nascimento){
            this.nascimento = nascimento;
            return this;
        }

        public UsuarioBuilder email(String email){
            this.email = email;
            return this;
        }

        public UsuarioBuilder endereco(Endereco endereco){
            this.endereco = endereco;
            return this;
        }


        public UsuarioWithBuilder build(){
            return new UsuarioWithBuilder (this);
        }

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
}
