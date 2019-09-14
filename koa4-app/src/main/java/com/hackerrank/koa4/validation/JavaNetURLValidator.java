package com.hackerrank.koa4.validation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class JavaNetURLValidator implements URLValidator {

	@Override
	public boolean isValid(String url) {
		try {
			new URL(url).toURI();
			return true;
		}
		catch (URISyntaxException exception) {
			return false;
		}
		catch (MalformedURLException exception) {
			return false;
		}		
	}

}
