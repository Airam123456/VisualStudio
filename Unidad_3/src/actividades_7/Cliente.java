package actividades_7;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	public static void main (String[] args) 
	{
		//host y puerto
		String host = "localhost";
		int puerto = 6013;

		//bucle
		for(int i = 0; i <= 3; i++){
			try {
				//Mensaje
				System.out.println("PROGRAMA CLIENTE INICIANDO");
				//Creamos los sockets y hacemos la conexio
				Socket clientes = new Socket();
				clientes = new Socket (host, puerto);
				
				System.out.println("Recibiendo mensaje del servidor:");
				//Recibimos datos
				InputStream is = clientes.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				System.out.println(dis.readUTF() + "\n");
				//Cerramos conexiones
				is.close();
				dis.close();
				clientes.close();
			} // Exepciones
			catch (UnknownHostException e) {
				System.out.println(e.getMessage());
			} 
			catch (IOException e) {
				System.out.println("Connection refused: connect");
			}
		}
	}
}
