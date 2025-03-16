package br.com.ghdpreto.api_livraria.modules.livro.application.usecase;

import org.springframework.stereotype.Service;

import br.com.ghdpreto.api_livraria.modules.livro.application.usecase.dtos.CadastrarLivroDTO;
import br.com.ghdpreto.api_livraria.modules.livro.domain.model.Livro;
import br.com.ghdpreto.api_livraria.modules.livro.domain.repository.ILivroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarLivroUseCase {

    private final ILivroRepository repository;

    public Livro execute(CadastrarLivroDTO dto) {
        // aqui posso colocar algumas validacoes, ou tratamentos no dto
        Livro livro = dto.paraEntidade();
        return repository.cadastrar(livro);
    }

}
