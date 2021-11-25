package actividades_7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main (String[] args) throws IOException 
	{	//Puerto y conexion
		int puerto = 6013;
		ServerSocket servidor = new ServerSocket (puerto, 3);
		
		System.out.println("Esperando a los clientes...");
		//Bucle
		for(int contSockets = 1; contSockets <= 3; contSockets++)
		{
			//Aceptamos la conexion del cliente
			Socket cliente = servidor.accept();
			//Enviamos datos
			OutputStream os = cliente.getOutputStream();
			DataOutputStream dos = new DataOutputStream (os);
			dos.writeUTF("Hola cliente " + (contSockets));
			// Cerramos conexion
			os.close();
			dos.close();
		}
		servidor.close();
	}
}
