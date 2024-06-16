package br.com.alura.codechella.infraestrutura.gateways;


import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

public class ScenarioFactory {
    public static Usuario buildUsuarioValido() {
        return new Usuario.Builder ()
                .id (1L)
                .cpf ("133.141.167-26")
                .nascimento (LocalDate.parse ("1999-12-03"))
                .nome ("Gregorio")
                .email ("greg@gmail.com")
                .endereco (new Endereco ("2222-654", 555, "RUA H"))
                .build ();
    }


    public static List<Usuario> buildListUsuarioValido() {
        return List.of (buildUsuarioValido ());
    }
}
