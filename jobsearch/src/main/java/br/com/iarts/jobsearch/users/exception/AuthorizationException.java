package br.com.iarts.jobsearch.users.exception;

import org.hibernate.service.spi.ServiceException;

public class AuthorizationException extends ServiceException {
    public AuthorizationException(String message, Throwable root) {
        super(message, root);
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
