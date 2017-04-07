package br.com.furb;

import java.io.Closeable;

public abstract class Client implements Closeable {

	// ler
	public abstract void write(String message);

	// escrever
	public abstract String read();

}
