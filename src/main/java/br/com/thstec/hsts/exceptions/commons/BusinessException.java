package br.com.thstec.hsts.exceptions.commons;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
