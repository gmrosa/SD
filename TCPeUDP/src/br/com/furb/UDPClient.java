package br.com.furb;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPClient extends Client {

	private Server server;
	private DatagramSocket socket;

	public UDPClient() {
		this("localhost", 8085);
	}

	public UDPClient(int port) {
		this("localhost", port);
	}

	public UDPClient(String server, int port) {
		this(new Server(server, port));
	}

	public UDPClient(Server server) {
		this.server = server;
	}

	@Override
	public void write(String message) {
		// Log.out(message);
		try {
			// Coloca os dados em um buffer
			byte[] s = new byte[message.length()];
			s = message.getBytes("UTF-8");
			// Prepara um pacote com o buffer e as informações do destinatário
			InetAddress ip = InetAddress.getByName(server.getULR());
			DatagramPacket pack = new DatagramPacket(s, s.length, ip, server.getPort());
			// Cria um socket UDP e envia o pacote
			socket = new DatagramSocket();
			socket.send(pack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String read() {
		try {
			// Prepara um buffer para receber dados
			byte[] r = new byte[1024];
			DatagramPacket pack = new DatagramPacket(r, r.length);
			// Cria um socket UDP para receber dados escutando a porta
			socket = new DatagramSocket(server.getPort());
			// Lê os dados enviados pela aplicação
			socket.receive(pack);

			// Apresenta os dados recebidos
			String buf = new String(pack.getData(), 0, pack.getLength());
			Log.out(buf);
			return buf;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void close() {
		// Encerra o socket
		socket.close();
	}

}
