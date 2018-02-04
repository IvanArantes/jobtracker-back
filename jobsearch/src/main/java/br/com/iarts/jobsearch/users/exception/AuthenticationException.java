package br.com.iarts.jobsearch.users.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AuthenticationException extends ServiceException {
    public AuthenticationException(String message, Throwable root) {
        super(message, root);
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
