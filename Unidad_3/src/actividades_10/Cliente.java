package actividades_10;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Cliente {
	
	public static void main (String[] args) {
		try {
			//Instanciamos el tenista, determinamos el puerto 
			Tenista tenista = new Tenista("del Potro", 198);
			int puerto = 12348;
			InetAddress destino = InetAddress.getLocalHost();
			
			//Instanciamos los outputStream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(tenista);
			byte bufferEnviar[] = baos.toByteArray();
			baos.close();
			oos.close();
			
			//Instanciamos los datagrams
			DatagramSocket socket = new DatagramSocket(34567);
			DatagramPacket enviar = new DatagramPacket(bufferEnviar, bufferEnviar.length, destino, puerto);
			//enviamos
			socket.send(enviar);
			System.out.println("Envio el objeto: " +  tenista.getApellido() + "  " + tenista.getAltura());
			
			//Recivimos respuesta del servidor
			byte bufferRecibir[] = new byte[bufferEnviar.length];
			DatagramPacket recibir = new DatagramPacket(bufferRecibir, bufferRecibir.length);
			System.out.println("Esperando datagrama.....");
			socket.receive(recibir);
			
			//Instanciamos los inputStream	
			ByteArrayInputStream bais = new ByteArrayInputStream(bufferRecibir);
			ObjectInputStream ois = new ObjectInputStream(bais);			
			Tenista tenistaRecibir = (Tenista)ois.readObject();
			bais.close();
			ois.close();
			//Escribimos los mensajes y cerramos
			System.out.println("He recibido el objeto: " + tenistaRecibir.getApellido() + " " + tenistaRecibir.getAltura());
			System.out.println("Fin del cliente");
			socket.close();
		} 

		catch (IOException e){
			System.out.println(e.getMessage());
		} 
		catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
