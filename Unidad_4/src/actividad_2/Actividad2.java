package actividad_2;

import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;

public class Actividad2
{
	public static void main (String [] args) 
	{
		FTPClient cliente = new FTPClient();
		String servFTP = "localhost";
		String usuario = "dinux";
		String clave = "dinux";

		try 
		{
			System.out.println("Nos conectamos a " + servFTP);
			cliente.connect(servFTP);
			
			// Iniciamos sesion
			if (cliente.login(usuario, clave) == true)
				System.out.println("Login correcto");
			else 
			{
				System.out.println("Login incorrecto...");
				cliente.disconnect();
				System.exit(1);
			}
			
			// Visualizamos directorio actual
			System.out.println("Directorio actual: " + cliente.printWorkingDirectory());

			// Creamos un nuevo direcctorio
	        boolean crearDirectorio = cliente.makeDirectory("aplicacionwebbrito");
	        boolean directoriosCreados = true;
	        if (directoriosCreados == true) 
	        {
	            if(crearDirectorio = cliente.makeDirectory("aplicacionwebbrito/html"))
	            {
		            if(crearDirectorio = cliente.makeDirectory("aplicacionwebbrito/imagenes"))
		            {
			            if(!(crearDirectorio = cliente.makeDirectory("aplicacionwebbrito/css")))
			            	directoriosCreados = false;
		            }
		            else
		            	directoriosCreados = false;
		            
	            }
	            else
	            	directoriosCreados = false;
	        }
	        else 
	        	directoriosCreados = false;
	        
	        if(directoriosCreados == true)
	        	System.out.println("Directorios creados...");
	        else
	        {
	        	System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
				cliente.disconnect();
	        }
	        
	        // Cerrar sesión 
			if (cliente.logout() == true) 
				System.out.println("Logout del servidor FTP...");
			else
				System.out.println("Error al hacer logout"); 
			
			// Desconectamos del servidor
			cliente.disconnect();
			System.out.println("Desconectado...");
		} 
		catch (SocketException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
