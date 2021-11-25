package actividades_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main (String[] args) throws IOException {

		int numRecibido;
		int Puerto = 6010;
		ServerSocket servidor = new ServerSocket (Puerto);
		Socket clienteConectado = null;
		
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();

		//// Creación del flujo de entrada del cliente
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream (entrada);

		////// El cliente envía un mensaje al servidor
		numRecibido = flujoEntrada.read();

		/////// Flujo de salida hacia el cliente
		OutputStream salida=null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream (salida);

		////// Envio resultado al Cliente
		flujoSalida.writeUTF(String.valueOf((int)Math.pow(numRecibido, 2)));

		////// Cerrar streams y sockets
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close(); 
	} 
}
