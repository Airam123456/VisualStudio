package actividades_11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main (String[] args) throws IOException {
		//Puerto
		int Puerto = 6000;
		ServerSocket servidor = new ServerSocket (Puerto);
		//Bucle infinito
		while (true) {
			// Unimos el cliente con el hilo servidor
			Socket cliente = servidor.accept();
			System.out.println("Cliente Conectado.....");
			HiloServidor hilo = new HiloServidor (cliente);
			hilo.start();
		}
	}
}
