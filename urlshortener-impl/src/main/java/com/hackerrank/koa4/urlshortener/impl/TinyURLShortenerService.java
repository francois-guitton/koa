package com.hackerrank.koa4.urlshortener.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import com.hackerrank.koa4.urlshortener.api.URLShortenerService;

public class TinyURLShortenerService implements URLShortenerService {

	private static final String HTTP_TINYURL_API = "http://tinyurl.com/api-create.php";

	@Override
	public String tinyUrl(String url) throws IOException {
		HttpURLConnection con = setupConnection();
		addParameters(url, con);
		StringBuffer content = getContent(con);
		return content.toString();
	}

	private StringBuffer getContent(HttpURLConnection con) throws IOException {
		int status = con.getResponseCode();
		Reader streamReader = null;
		 
		if (status > 299) {
		    streamReader = new InputStreamReader(con.getErrorStream());
		} else {
		    streamReader = new InputStreamReader(con.getInputStream());
		}
		BufferedReader in = new BufferedReader(streamReader);
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		return content;
	}

	private void addParameters(String url, HttpURLConnection con) throws IOException, UnsupportedEncodingException {
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(getParamsString("url", url));
		out.flush();
		out.close();
	}

	private HttpURLConnection setupConnection() throws MalformedURLException, IOException, ProtocolException {
		URL tinyUrl = new URL(HTTP_TINYURL_API);
		HttpURLConnection con = (HttpURLConnection) tinyUrl.openConnection();
		con.setRequestMethod("GET");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		con.setDoOutput(true);
		return con;
	}
	
	private static String getParamsString(String key, String value) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();

		result.append("&");
		result.append(URLEncoder.encode(key, "UTF-8"));
		result.append("=");
		result.append(URLEncoder.encode(value, "UTF-8"));

		return result.toString();
	}

}
