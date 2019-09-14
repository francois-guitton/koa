package com.hackerrank.koa4.urlshortener.api;

import java.io.IOException;

public interface URLShortenerService {

	String tinyUrl(String url) throws IOException;
}
