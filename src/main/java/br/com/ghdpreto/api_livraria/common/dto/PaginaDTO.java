package br.com.ghdpreto.api_livraria.common.dto;

import java.util.List;

import lombok.Builder;

@Builder
public record PaginaDTO<T>(
        List<T> conteudo,
        Integer paginaAtual,
        Integer tamanhoPagina,
        Long totalElementos,
        Integer totalPaginas

) {

}
