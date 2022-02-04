package pregunta_1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClienteCoche {
	
	public static void main(String[] args) {
		try {
			//instanciamos el coche y el puerto
			Coche coche = new Coche(5776, "CNS", "Citroen", "C4");
			int puerto = 12300;
			InetAddress destino = InetAddress.getLocalHost();
			
			//Instanciamos los outputStream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(coche);
			byte bufferEnviar[] = baos.toByteArray();
			baos.close();
			oos.close();
			
			//Instanciamos los datagrams
			DatagramSocket socket = new DatagramSocket(34567);
			DatagramPacket enviar = new DatagramPacket(bufferEnviar, bufferEnviar.length, destino, puerto);
			//enviamos
			socket.send(enviar);
			System.out.println("Envio el objeto: " + coche.getMatriculaNum() + " " + coche.getMatriculaLetras()+ " " + coche.getMarca()+ " " + coche.getModelo());

			//Recivimos respuesta del servidor
			byte bufferRecibir[] = new byte[bufferEnviar.length];
			DatagramPacket recibir = new DatagramPacket(bufferRecibir, bufferRecibir.length);
			System.out.println("Esperando respuesta.....");
			socket.receive(recibir);
			
			//Instanciamos los inputStream	
			ByteArrayInputStream bais = new ByteArrayInputStream(bufferRecibir);
			ObjectInputStream ois = new ObjectInputStream(bais);			
			Coche cocheRecibir = (Coche)ois.readObject();
			bais.close();
			ois.close();
			//Escribimos los mensajes y cerramos
			System.out.println("nos dicen de la policia que tu entrada es" );
			socket.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
}
