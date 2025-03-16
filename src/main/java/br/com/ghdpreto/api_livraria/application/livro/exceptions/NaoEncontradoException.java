package br.com.ghdpreto.api_livraria.application.livro.exceptions;

public class NaoEncontradoException extends RuntimeException {
    public NaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
