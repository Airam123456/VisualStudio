package actividades_1_2_3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {
	public static void main( String[] args ) { 
		
		try {
				InetAddress address [];
				String ipAddres = args[0]; //Argumentos
				address = InetAddress.getAllByName( ipAddres );
				System.out.println("Dirección IP: " + address[0].getHostAddress());
				System.out.println("Nombre: " + address[0].getHostName());
				System.out.println(address[0]);
				System.out.println(address[0].getHostAddress());
				for (int i = 0; i < address.length; i++) {
					System.out.println(address[i]);
				}										
		} catch (Exception e) {
			InetAddress local;
			InetAddress localAddresses[];
			try {
				local = InetAddress.getLocalHost();	//Conseguimos el local host
				localAddresses = InetAddress.getAllByName(local.getHostName()); // conseguimos el nombre
				System.out.println("Dirección IP: " + localAddresses[0].getHostAddress()); // la ip
				System.out.println("Nombre: " + localAddresses[0].getHostName());
				for (int i = 0; i < localAddresses.length; i++)
					System.out.println(localAddresses[i]);
			} catch (Exception e1) {

			}
		}
	}
}
