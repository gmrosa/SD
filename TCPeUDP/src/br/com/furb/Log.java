package br.com.furb;

public class Log {
	public static boolean isActive = true;

	public static void out(String message) {
		if (isActive) {
			System.out.println(message);
		}
	}
}
