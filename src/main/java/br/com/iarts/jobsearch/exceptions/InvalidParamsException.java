package br.com.iarts.jobsearch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excecao responsavel por identificar parametros nao passados corretamente na requisicao.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParamsException extends Exception {
    public InvalidParamsException(String message) {
        super(message);
    }
}
