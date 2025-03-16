package br.com.ghdpreto.api_livraria.frameworks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ghdpreto.api_livraria.application.livro.CadastrarLivroUseCase;
import br.com.ghdpreto.api_livraria.application.livro.ListarLivroPorIdUseCase;
import br.com.ghdpreto.api_livraria.application.livro.ListarLivroUseCase;
import br.com.ghdpreto.api_livraria.domain.repositories.LivroRepository;

@Configuration
public class LivroConfig {

    @Bean
    CadastrarLivroUseCase cadastrarLivroUseCase(LivroRepository livroRepository) {
        return new CadastrarLivroUseCase(livroRepository);
    }

    @Bean
    ListarLivroPorIdUseCase listarLivroPorIdUseCase(LivroRepository livroRepository) {
        return new ListarLivroPorIdUseCase(livroRepository);
    }

    @Bean
    ListarLivroUseCase listarLivroUseCase(LivroRepository livroRepository) {
        return new ListarLivroUseCase(livroRepository);
    }
}
