package com.hackerrank.koa4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class URLReaderTest {
	private InputStream stdin;
	
	@BeforeEach
	public void mockSystemIn() {
		stdin = System.in;
	}
	
	@AfterEach
	public void restoreSystemIn() {
		System.setIn(stdin);
	}
	@Test
	public void hasNextWhenEmptyInput() throws IOException {
		String simulatedInput = "";
		writeToSystemIn(simulatedInput);
		try (URLReader urlReader = new URLReaderImpl()) {
			assertTrue(urlReader.hasNext());
		}
	}

	@Test
	public void noNextLineWhenLowerStopCharacterUsed() throws IOException {
		String simulatedInput = "q";
		writeToSystemIn(simulatedInput);
		try (URLReader urlReader = new URLReaderImpl()) {
			urlReader.read();
			assertFalse(urlReader.hasNext());
		}
	}

	@Test
	public void noNextLineWhenUpperStopCharacterUsed() throws IOException {
		String simulatedInput = "Q";
		writeToSystemIn(simulatedInput);
		try (URLReader urlReader = new URLReaderImpl()) {
			urlReader.read();
			assertFalse(urlReader.hasNext());
		}
	}

	@Test
	public void readerReturnsSameLineAsInput() throws IOException {
		String simulatedInput = "this is a line with spaces";
		writeToSystemIn(simulatedInput);
		try (URLReader urlReader = new URLReaderImpl()) {
			assertEquals(urlReader.read(), simulatedInput);
		}
	}

	private void writeToSystemIn(String theInput) {
		byte[] inputWithLineSeparator = (theInput + System.lineSeparator()).getBytes();
		System.setIn(new ByteArrayInputStream(inputWithLineSeparator));
	}
	
}
