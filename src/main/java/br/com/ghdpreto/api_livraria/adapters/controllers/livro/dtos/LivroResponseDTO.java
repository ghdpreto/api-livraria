package br.com.ghdpreto.api_livraria.adapters.controllers.livro.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.ghdpreto.api_livraria.domain.entities.Livro;
import lombok.Builder;

@Builder
public record LivroResponseDTO(
        UUID id,
        String titulo,
        String autor,
        Double preco,
        Integer quantidadeEstoque,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao) {

    public static LivroResponseDTO paraDto(Livro livro) {
        return LivroResponseDTO.builder()
                .id(livro.getId())
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .preco(livro.getPreco())
                .quantidadeEstoque(livro.getQuantidadeEstoque())
                .dataCriacao(livro.getDataCriacao())
                .dataAtualizacao(livro.getDataAtualizacao())
                .build();
    }

}
