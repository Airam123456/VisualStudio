package pregunta_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class ZerbitzariBrito {

	public static void main (String[] args) throws IOException 
	{
		int puerto = 6030;
		System.setProperty("javax.net.ssl.keyStore","BiltegiBrito");
		System.setProperty("javax.net.ssl.keyStorePassword","pwdZerbitzari");
		
		SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		SSLServerSocket servidor= (SSLServerSocket) sfact.createServerSocket(puerto);

		System.out.println("Esperando a que el cliente se conecte");
		SSLSocket clienteConectado = (SSLSocket)servidor.accept();

		////// Creación del flujo de entrada del cliente
		InputStream entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream (entrada);

		////// El cliente envía un mensaje al servidor
		String Recibido = flujoEntrada.readUTF();

		////// Flujo de salida hacia el cliente
		OutputStream salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream (salida);

		////// Envio un saludo al SocketClienteSeguro
		flujoSalida.writeUTF(Recibido.toLowerCase());

		////// Cerrar streams y sockets
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		
		clienteConectado.close();
		servidor.close(); 
	} 
}
