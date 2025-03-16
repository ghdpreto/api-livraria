package br.com.ghdpreto.api_livraria.application.livro.dtos;

import java.util.List;

public record PaginaDTO<T>(
                List<T> conteudo,
                Integer paginaAtual,
                Integer tamanhoPagina,
                Long totalElementos,
                Integer totalPaginas

) {

}
