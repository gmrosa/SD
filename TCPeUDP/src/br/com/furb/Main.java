package br.com.furb;

import java.io.IOException;

public class Main {

	private static UDPClient client;

	public static void main(String[] args) {
		client = new UDPClient("MC-3506", 3333);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					client.write("SEND AE CARA BELEZA MEU");
					ThreadUtils.sleep(5000);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						UDPServer.start();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
