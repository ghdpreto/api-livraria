package br.com.ghdpreto.api_livraria.application.livro.dtos;

import br.com.ghdpreto.api_livraria.domain.entities.Livro;

public record CadastrarLivroDTO(
        String titulo,
        String autor,
        Double preco,
        Integer quantidadeEstoque) {

    public Livro paraDominio() {
        return Livro.builder()
                .titulo(titulo)
                .autor(autor)
                .preco(preco)
                .quantidadeEstoque(quantidadeEstoque)
                .build();
    }

}
