package com.hackerrank.koa4.validation;

import org.apache.commons.validator.routines.UrlValidator;

public class CommonsURLValidator implements URLValidator {

	private UrlValidator defaultValidator = new UrlValidator();

	@Override
	public boolean isValid(String url) {
		return defaultValidator.isValid(url);
	}

}
