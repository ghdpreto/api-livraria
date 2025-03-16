package br.com.ghdpreto.api_livraria.modules.livro.application.usecase.dtos;

import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import lombok.Builder;

@Builder
public record CadastrarLivroDTO(
        String titulo,
        String autor,
        Double preco,
        Integer quantidadeEstoque) {

    public Livro paraEntidade() {
        return Livro.builder()
                .titulo(titulo)
                .autor(autor)
                .preco(preco)
                .quantidadeEstoque(quantidadeEstoque)
                .build();
    }

}
