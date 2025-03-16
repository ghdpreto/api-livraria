package br.com.ghdpreto.api_livraria.adapters.controllers.livro.dtos;

import java.util.List;

public record PaginaResponseDTO<T>(
        List<T> conteudo,
        Integer paginaAtual,
        Integer tamanhoPagina,
        Long totalElementos,
        Integer totalPaginas

) {

}
