package com.hackerrank.koa4;

import java.io.Closeable;

/**
 * 
 * @author fguitton
 *
 */
public interface URLReader extends Closeable {

	String read();
	
	boolean hasNext();
	
}
