package br.com.ghdpreto.api_livraria.application.livro.dtos;

public record PaginacaoDTO(
        Integer pagina,
        Integer tamanho) {

    public PaginacaoDTO {
        if (pagina == null) {
            pagina = 0;
        }
        if (tamanho == null) {
            tamanho = 10;
        }
    }

}
