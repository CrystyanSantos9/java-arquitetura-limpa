package br.com.alura.codechella.infraestrutura.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {

    List<Usuario> usuarios = new ArrayList<> ();

    @Override
    public Usuario cadastraUsuario(Usuario usuario) {
        usuarios.add (usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }


    public void gravaEmArquivo(String nomeArquivo){

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter (nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        try {
            fileWriter.write (this.usuarios.toString ());
            fileWriter.close ();
        } catch (IOException e) {
            throw new RuntimeException (e);
        }

    }


}
