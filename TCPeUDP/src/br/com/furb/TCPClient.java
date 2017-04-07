package br.com.furb;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.charset.Charset;

public class TCPClient extends Client {

	private static final int MAX_RETRIES = 2;
	private Server server;
	private Socket socket;

	public TCPClient() {
		this("localhost", 8085);
	}

	public TCPClient(int port) {
		this("localhost", port);
	}

	public TCPClient(String server, int port) {
		this(new Server(server, port));
	}

	public TCPClient(Server server) {
		this.server = server;
	}

	@Override
	public String read() {
		try {
			Socket sock = getSocket();
			if (sock != null) {
				// Prepara um buffer para receber a resposta do servidor
				InputStreamReader s = new InputStreamReader(sock.getInputStream());
				BufferedReader rec = new BufferedReader(s);

				// Lê os dados enviados pela aplicação servidora
				byte ptext[] = rec.readLine().getBytes(Charset.forName("ISO-8859-1"));
				String buf = new String(ptext, Charset.forName("UTF-8"));
				Log.out(buf);
				return buf;
			}
			return null;
		} catch (Throwable e) {
			return e.getMessage();
		}
	}

	@Override
	public void write(String message) {
		try {
			Socket sock = getSocket();
			if (sock != null) {
				// Coloca os dados em um buffer e envia para o servidor
				DataOutputStream d = new DataOutputStream(sock.getOutputStream());
				d.write(message.getBytes("UTF-8"));
				Log.out(message);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			if (socket != null) {
				// Encerra o socket
				socket.close();
				socket = null;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private Socket getSocket() {
		if (socket == null) {
			socket = createSocket();
		}
		return socket;
	}

	private Socket createSocket() {
		int i = 0;
		Socket socket = null;
		while (socket == null && i < MAX_RETRIES) {
			try {
				socket = new Socket(server.getULR(), server.getPort());
				return new Socket(server.getULR(), server.getPort());
			} catch (ConnectException e) {
				System.out.println(e.getMessage());
				i++;
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		}
		return socket;
	}

}
