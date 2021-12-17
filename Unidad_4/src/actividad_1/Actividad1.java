package actividad_1;

import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;

public class Actividad1 
{
	public static void main (String [] args) 
	{
		//Variables
		FTPClient cliente = new FTPClient();
		String serverFTP = "ftp.rediris.es"; 
		System.out.println("Nos conectamos a " + serverFTP);
		String usuario = "anonymous";
		String contrasenia = "dm2";

		try 
		{
			//Conectamos 
			cliente.connect(serverFTP);
			//Inicio de sesión 
			boolean login = cliente.login(usuario, contrasenia);
			if (login == true) {
				System.out.println("Login correcto");
			}
			else {
				System.out.println("Login incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}
			//Directorio actual
			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
			//Nuevo directorio 
	        boolean directorioCreado = cliente.makeDirectory("DM2PROS");
	        if (directorioCreado == true) {
	            System.out.println("Directorio creado....");
	        }
	        else {
	            System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
	        }
	        // Cerrar sesión 
			boolean logout = cliente.logout();
			if (logout == true) { 
				System.out.println("Logout del servidor FTP...");
			}
			else {
				System.out.println("Error al hacer un Logout..."); 
			}
			// Desconectamos del servidor
			cliente.disconnect();
			System.out.println("Desconectado...");
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
