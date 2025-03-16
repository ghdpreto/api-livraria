package br.com.ghdpreto.api_livraria.adapters.controllers.livro.dtos;

import br.com.ghdpreto.api_livraria.application.livro.dtos.PaginacaoDTO;

public record PaginacaoRequestDTO(
        Integer pagina,
        Integer tamanho) {

    public PaginacaoDTO paraDomain() {
        return new PaginacaoDTO(this.pagina, this.tamanho);
    }

}
