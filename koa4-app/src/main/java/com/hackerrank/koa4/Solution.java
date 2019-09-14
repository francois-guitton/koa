package com.hackerrank.koa4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.hackerrank.koa4.urlshortener.URLShortener;
import com.hackerrank.koa4.urlshortener.api.URLShortenerService;
import com.hackerrank.koa4.validation.CommonsURLValidator;
import com.hackerrank.koa4.validation.URLValidator;

/**
 * Solution to HackerRank KOA 4
 * 
 * @author fguitton
 */
public class Solution {
	private Map<String, String> cachedUrls;
	private Map<String, Integer> popularUrls;
	private URLShortenerService urlShortenerService;
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.start();
	}
	
	public Solution() {
		cachedUrls = new HashMap<>();
		popularUrls = new HashMap<>();
		urlShortenerService = URLShortener.provider().create();
	}
	
	private void start() {
		//choose your preferred validator
		URLValidator validator = new CommonsURLValidator();
		String longUrl = "";
		try (URLReader urlReader = new URLReaderImpl()) {
			do {
				System.out.print("Enter a url: ");
				longUrl = urlReader.read();
				if (urlReader.hasNext()) {
					if (!validator.isValid(longUrl)) {
						System.out.println("The URL you entered is not valid: " + longUrl);
					} else {
						String shortUrl = cachedUrls.get(longUrl);
						if (shortUrl == null) {
							shortUrl = urlShortenerService.tinyUrl(longUrl);
							System.out.println("Getting Shortened Url from Provider: " + shortUrl);
							cachedUrls.put(longUrl, shortUrl);
							popularUrls.put(longUrl, 1);
						} else {
							int timesRetrieved = popularUrls.get(longUrl);
							System.out.println("Retrieved url from cache ("+ timesRetrieved + "): " + shortUrl);						
							popularUrls.put(longUrl, timesRetrieved + 1);
						}
					}
				}
			} while (urlReader.hasNext());
		} catch (IOException e) {
			System.out.println("Something went wrong...");
			e.printStackTrace();
		}
		System.out.println("Bye bye...");
		System.exit(0);
	}	
}
