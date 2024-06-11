package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;
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

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalidoComBuilder(){

        Assertions.assertThrows (IllegalArgumentException.class,
                ()-> new UsuarioWithBuilder
                        .UsuarioBuilder()
                        .id (1L)
                        .nascimento (LocalDate.parse ("1990-09-08"))
                        .endereco (new Endereco ("2277-052", 195, "Rua da Pedra Ap 101"))
                        .build ());
    }

    @Test
    public void deveCriarUsuarioUsandoFabrica(){


// A fabrica mantem a mesma instancia de usuario;

        FabricaDeUsuario fabricaDeUsuario = new FabricaDeUsuario ();

        Usuario usuario = fabricaDeUsuario
                .comNomeCpfNascimento ("Crystyan", "133.287.148-34", LocalDate.parse ("1990-09-08") );

        Assertions.assertEquals ("Crystyan", usuario.getNome ());

// Por manter a mesma instancia, devolvemos o mesmo objeto com dados adicionais

        usuario =fabricaDeUsuario.incluiEndereco ("2277-052", 195, "Rua da Pedra Ap 101");


        Assertions.assertEquals (195, usuario.getEndereco ().getNumero ());
        Assertions.assertEquals ("Rua da Pedra Ap 101", usuario.getEndereco ().getComplemento ());
    }



}