package com.hackerrank.koa4.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.hackerrank.koa4.validation.CommonsURLValidator;
import com.hackerrank.koa4.validation.JavaNetURLValidator;
import com.hackerrank.koa4.validation.RegexURLValidator;
import com.hackerrank.koa4.validation.URLValidator;

public class URLValidatorTest {

	@ParameterizedTest
	@CsvFileSource(resources = "invalidurls.csv", numLinesToSkip = 1)
	void rexegValidatesIncorrectUrls(String url) {
		URLValidator validator = new RegexURLValidator();
	    assertFalse(validator.isValid(url));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "invalidurls.csv", numLinesToSkip = 1)
	void javaNetValidatesIncorrectUrls(String url) {
		URLValidator validator = new JavaNetURLValidator();
	    assertFalse(validator.isValid(url));
	}

	@ParameterizedTest
	@CsvFileSource(resources = "invalidurls.csv", numLinesToSkip = 1)
	void commonsValidatesIncorrectUrls(String url) {
		URLValidator validator = new CommonsURLValidator();
	    assertFalse(validator.isValid(url));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "validurls.csv", numLinesToSkip = 1)
	void rexegValidatesCorrectUrls(String url) {
		URLValidator validator = new RegexURLValidator();
	    assertTrue(validator.isValid(url));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "validurls.csv", numLinesToSkip = 1)
	void javaNetValidatesCorrectUrls(String url) {
		URLValidator validator = new JavaNetURLValidator();
	    assertTrue(validator.isValid(url));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "validurls.csv", numLinesToSkip = 1)
	void commonsValidatesCorrectUrls(String url) {
		URLValidator validator = new CommonsURLValidator();
	    assertTrue(validator.isValid(url));
	}
	

}
