package com.hackerrank.koa4.urlshortener.impl;

import com.hackerrank.koa4.urlshortener.api.URLShortenerService;
import com.hackerrank.koa4.urlshortener.spi.URLShortenerServiceProvider;

public class TinyURLShortenerServiceProvider implements URLShortenerServiceProvider {

	@Override
	public URLShortenerService create() {
		return new TinyURLShortenerService();
	}

}
