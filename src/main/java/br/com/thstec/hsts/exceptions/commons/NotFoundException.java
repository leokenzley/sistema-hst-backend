package br.com.thstec.hsts.exceptions.commons;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
