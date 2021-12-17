package actividades_1_2_3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {
	public static void main( String[] args ) { 
		InetAddress address [];
		try {
				String ipAddres = args[0];	//Argumento con la direccion
				if(ipAddres.length() != 0) {	//Comprobamos que la direccion no esta vacia
					address = InetAddress.getAllByName( ipAddres );
					for (int i = 0; i < address.length; i++)
						System.out.println(address[i]);		//Sacamos las ip
				}
				else	//Mensaje por si esta vacia
					System.out.println("Se necesita una URL para obtener su dirección");
		} catch (Exception e) {
			System.out.println("Se necesita una URL para obtener su dirección");
		}
	}
}
