package actividades_1_2_3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {
	public static void main( String[] args ) { 
		InetAddress address [];
		try {//obtenemos la direccion IP 
			address = InetAddress.getAllByName( "www.spotify.com" );
			for (int i = 0; i < address.length; i++)
				System.out.println(address[i]);
			 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
