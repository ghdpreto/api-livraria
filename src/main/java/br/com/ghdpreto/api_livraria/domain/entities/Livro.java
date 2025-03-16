package br.com.ghdpreto.api_livraria.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Livro {
    private final UUID id;
    private final String titulo;
    private final String autor;
    private final Double preco;
    private final Integer quantidadeEstoque;
    private final LocalDateTime dataCriacao;
    private final LocalDateTime dataAtualizacao;

    public static class LivroBuilder {
        private LocalDateTime dataCriacao = LocalDateTime.now();
        private LocalDateTime dataAtualizacao = LocalDateTime.now();
    }

}