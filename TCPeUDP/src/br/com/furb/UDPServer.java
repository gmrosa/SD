package br.com.furb;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void start() throws IOException {
		DatagramSocket socket = null;
		String s;

		try {
			socket = new DatagramSocket(3333);

			while (true) {
				byte[] buffer = new byte[100];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				socket.receive(request);
				s = new String(request.getData());
				System.out.println("SERVER " + s);
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getData().length,
						request.getAddress(), request.getPort());
				socket.send(reply);
			}
		} finally {
			if (socket != null) {
				socket.close();
			}
		}

	}

}
