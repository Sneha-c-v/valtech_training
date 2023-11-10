package com.valtech.training.day3;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Rot13Reader extends Reader {
	private Reader source;
	public Rot13Reader(Reader source) {
		this.source=source;
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		int bytesRead=source.read(cbuf,off,len);
		for (int i = 0; i < bytesRead; i++) {
			cbuf[off+i]=Rot13Helper.rotate(cbuf[off+i]);
			
		}
		return bytesRead;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		source.close();
	}
	

}
