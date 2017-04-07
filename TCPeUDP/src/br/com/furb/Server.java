package br.com.furb;

public class Server {
	private String url;
	private int port;

	public Server(String url, int port) {
		this.url = url;
		this.port = port;
	}

	public String getULR() {
		return url;
	}

	public int getPort() {
		return port;
	}

}
