package com.hackerrank.koa4.urlshortener.spi;

import com.hackerrank.koa4.urlshortener.api.URLShortenerService;

public interface URLShortenerServiceProvider {
	
	URLShortenerService create();
}
