package br.com.ghdpreto.api_livraria.modules.livro.domain.repository;

import java.util.Optional;
import java.util.UUID;

import br.com.ghdpreto.api_livraria.common.dto.PaginaDTO;
import br.com.ghdpreto.api_livraria.common.dto.PaginacaoDTO;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;

public interface ILivroRepository {
    Livro cadastrar(Livro livro);

    PaginaDTO<Livro> listar(PaginacaoDTO paginacao);

    Optional<Livro> buscarPorId(UUID id);

    Livro atualizar(Livro livro);
}
