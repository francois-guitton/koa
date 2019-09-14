package com.hackerrank.koa4.urlshortener.exception;

public class ProviderNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5664143755542497795L;

	public ProviderNotFoundException() {
        super();
    }

    public ProviderNotFoundException(String message) {
        super(message);
    }

}

