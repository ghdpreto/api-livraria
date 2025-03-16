package br.com.ghdpreto.api_livraria.modules.livro.adapter.controller.dto;

import br.com.ghdpreto.api_livraria.modules.livro.application.usecase.dtos.CadastrarLivroDTO;

public record LivroRequestDTO(
        String titulo,
        String autor,
        Double preco,
        Integer quantidadeEstoque) {

    public CadastrarLivroDTO paraUseCase() {
        return CadastrarLivroDTO.builder()
                .titulo(titulo)
                .autor(autor)
                .preco(preco)
                .quantidadeEstoque(quantidadeEstoque)
                .build();
    }
}
