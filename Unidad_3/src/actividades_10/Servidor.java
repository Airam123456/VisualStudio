package actividades_10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	public static void main (String[] args) {		
		try {
			//Instanciamos puerto y datagams
			int puerto = 12348;
			byte bufferRecibir[] = new byte[1024];
			DatagramPacket recibir = new DatagramPacket(bufferRecibir, bufferRecibir.length);
			DatagramSocket socket = new DatagramSocket(puerto);
						
			System.out.println("Esperando datagrama.......");
			socket.receive(recibir);
			
			//Instanciamos los inputStream
			ByteArrayInputStream bais = new ByteArrayInputStream(bufferRecibir);
			ObjectInputStream ois = new ObjectInputStream(bais);
			Tenista tenista = (Tenista)ois.readObject();
			bais.close();
			ois.close();
			
			//Mostramos mensajes
			System.out.println("Recibo el objeto: " + tenista.getApellido() + " " + tenista.getAltura());
			System.out.println("IP de origen: " + recibir.getAddress());
			System.out.println("Puerto de origen: " + recibir.getPort());
			
			//Creamos al tenista
			tenista.setApellido("Karlovic");
			tenista.setAltura(208);
			System.out.println("Envío del objeto: " + tenista.getApellido() + " " + tenista.getAltura()); 
			
			//Instanciamos los outputStream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(tenista);
			byte bufferEnviar[] = baos.toByteArray();
			baos.close();
			oos.close();
			
			//Enviamos la informacion
			DatagramPacket enviar = new DatagramPacket(bufferEnviar, bufferEnviar.length, InetAddress.getLocalHost(), 34567);
			socket.send(enviar);
			//Cerramos
		
			System.out.println("Fin del servidor");
			socket.close();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	} 
}
