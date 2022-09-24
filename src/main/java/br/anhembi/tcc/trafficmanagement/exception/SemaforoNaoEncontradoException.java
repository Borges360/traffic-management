package br.anhembi.tcc.trafficmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class SemaforoNaoEncontradoException extends RuntimeException {

    public SemaforoNaoEncontradoException(Long id) {
        super("Semáforo não encontrado id: " + id);
    }

    public SemaforoNaoEncontradoException(String identificador) {
        super("Semáforo não encontrado identificador " + identificador);
    }

    public SemaforoNaoEncontradoException() {
        super("Nenhum Semáforo encontrado ");
    }
}
