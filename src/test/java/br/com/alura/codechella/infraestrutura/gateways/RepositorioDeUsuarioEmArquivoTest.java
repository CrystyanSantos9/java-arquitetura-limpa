package br.com.alura.codechella.infraestrutura.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith (SpringExtension.class)
@DirtiesContext
//@SpringBootTest(classes = RepositorioDeUsuarioEmArquivo.class)
class RepositorioDeUsuarioEmArquivoTest {

    @InjectMocks
    private RepositorioDeUsuarioEmArquivo repository;

    @Spy
    private Collection<Usuario> list = new ArrayList<> ();

    @Test
    public void deveSalvarUsuarioEmArquivoQuandoUsuarioValido(){
        Usuario usuario = ScenarioFactory.buildUsuarioValido();

        var expected = repository.cadastraUsuario (usuario);


       assertEquals (expected.getNome (), "Gregorio");

    }

    @Test
    public void deveRetornarUmaListaDeUsuariosValidos(){

        list.add (ScenarioFactory.buildUsuarioValido());


        var expected = repository.listarTodos ();


        assertEquals (expected.size (), 1);

    }

    @Test
    public void deveGravarListaDeUsuariosEmArquivo(){

        list.add (ScenarioFactory.buildUsuarioValido());
        repository.gravaEmArquivo ("tempUsuarios.txt");


    }

    @Test
    public void deveLancarExceptionAoGravarNoArquivo(){

        assertThrows (Exception.class, ()->repository.gravaEmArquivo (null));

    }

}