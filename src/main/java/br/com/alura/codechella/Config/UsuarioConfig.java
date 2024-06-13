package br.com.alura.codechella.Config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.infraestrutura.gateways.RepositorioDeUsuarioJPA;
import br.com.alura.codechella.infraestrutura.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infraestrutura.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario (repositorioDeUsuario);
    }


    @Bean
    RepositorioDeUsuario criarRepositorioDeUsurioJpa(UsuarioEntityMapper mapper, UsuarioRepository repository) {
        return new RepositorioDeUsuarioJPA (mapper, repository);
    }

}
