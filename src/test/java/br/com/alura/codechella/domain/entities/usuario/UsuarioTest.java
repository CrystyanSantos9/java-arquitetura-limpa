package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows (IllegalArgumentException.class,
                ()-> new Usuario
                        (1L, "123.45.789-99", "Henrique", LocalDate.parse ("1990-09-08"),"hrq@gmail.com"));
    }

}