package br.com.alura.codechella.infraestrutura.persistence;

import jakarta.persistence.Embeddable;

@Embeddable
public class EnderecoEntity {

        private String cep;

        private Integer numero;

        private String complemento;

        public EnderecoEntity(){}

        public EnderecoEntity(String cep, Integer numero, String complemento) {
            this.cep = cep;
            this.numero = numero;
            this.complemento = complemento;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public Integer getNumero() {
            return numero;
        }

        public void setNumero(Integer numero) {
            this.numero = numero;
        }

        public String getComplemento() {
            return complemento;
        }

        public void setComplemento(String complemento) {
            this.complemento = complemento;
        }
    }


