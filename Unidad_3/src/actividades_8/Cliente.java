package actividades_8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class Cliente 
{
	
	public static void main (String[] args) 
	{
		//Definimos el puerto y crearmos el buffer de bytes
		int puerto = 12346;
		byte buffer[] = new byte[1024];
		byte bufferRecibo[] = new byte[1024];
		
		try 
		{
			//Obtenemos el destino y generamos un numero aleatorio
			InetAddress destino = InetAddress.getLocalHost();
			int randomNum = (int)(-128 + Math.random() * 256); 
			//preparamos para el envio
			ByteBuffer BBufferEnviado = ByteBuffer.allocate(4);
			BBufferEnviado.putInt(randomNum);
			buffer = BBufferEnviado.array();
			
			DatagramPacket envio = new DatagramPacket(buffer, buffer.length, destino, puerto);
			DatagramSocket socket = new DatagramSocket(34568);
			//Enviamos atraves del buffer
			socket.send(envio);
			System.out.println("Esperando respuesta...");
			//Recibimos la respuesta con el cubo del numero que se ha generado
			DatagramPacket recibo = new DatagramPacket(bufferRecibo, bufferRecibo.length);
			socket.receive(recibo);
			ByteBuffer BBufferRecibido = ByteBuffer.wrap(bufferRecibo);
			System.out.println("Esperando respuesta...: el cubo de " + randomNum + " es " + BBufferRecibido.getInt());
			
			System.out.println("Adiós...");
			socket.close();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
} 
