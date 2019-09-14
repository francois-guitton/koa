package com.hackerrank.koa4;

import java.util.Scanner;

public class URLReaderImpl implements URLReader {
	private static final String QUIT = "q";

	private String url;
	private final Scanner scanner = new Scanner(System.in);
	
	@Override
	public String read() {
		return url = scanner.nextLine();
	}

	@Override
	public boolean hasNext() {
		return url == null || !url.equalsIgnoreCase(QUIT);
	}
	
	@Override
	public void close() {
		scanner.close();
	}

}
