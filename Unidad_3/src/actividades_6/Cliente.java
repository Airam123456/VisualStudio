package actividades_5_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	public static void main(String[] args) {
		/////Vaariables y entrada de l numero
		int numEntrada;		
		String Host="localhost";
		int Puerto = 6010;
		
		System.out.println("PROGRAMA CLIENTE INICIANDO");
		System.out.println("Introduce un número:");
		numEntrada = Consola.leeInt();
		
		try {

			Socket Cliente = new Socket (Host, Puerto);
			
			/////// Flujo de salida al servidor
			DataOutputStream flujoSalida = new DataOutputStream (Cliente.getOutputStream());

			////// Envío del numero al servidor
			flujoSalida.write(numEntrada);
			
			//// Creación del flujo de entrada al servidor
			DataInputStream flujoEntrada = new DataInputStream (Cliente.getInputStream());

			////// El servidor envía un mensaje al cliente
			System.out.println("Recibiendo mensaje del servidor: \n\tEl cuadrado del número " + numEntrada + " es " + flujoEntrada.readUTF());

			////// Cerrar streams y sockets
			flujoEntrada.close();
			flujoSalida.close();
			Cliente.close();

		} catch (UnknownHostException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}	
	}
}
