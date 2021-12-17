package actividades_8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;

public class Servidor 
{

	public static void main (String[] args) 
	{	
		//Definimos el puerto y crearmos el buffer de bytes
		int puerto = 12346;
		byte buffer[] = new byte[1024];
		
		try 
		{
			//Instancioamos el socket
			DatagramSocket socket = new DatagramSocket(puerto);
			System.out.println("Esperando datagrama...");
			//DatagramPacket
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			socket.receive(dp);
			//Abrimos el buffer y recivimos el numero del cliente
			ByteBuffer BBufferRecibido = ByteBuffer.wrap(buffer);
			int numRecibido = BBufferRecibido.getInt();
			
			System.out.println("Vamos a calcular el cubo de: " + numRecibido);
			System.out.println("IP de origen: " + dp.getAddress().getHostAddress());
			System.out.println("Puerto de origen: " + dp.getPort());
			//Elevamos al cubo
			int resultado = (int)(Math.pow(numRecibido, 3));
			//Enviamos el resultado
			ByteBuffer BBufferEnviado = ByteBuffer.allocate(4);
			BBufferEnviado.putInt(resultado);
			byte bufferResultado[] = BBufferEnviado.array();
			DatagramPacket envio = new DatagramPacket(bufferResultado, bufferResultado.length, dp.getAddress(), 34568);
			socket.send(envio);
			System.out.println("Enviamos el resultado... " + resultado + "\nAdios");
			socket.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	} 
}
