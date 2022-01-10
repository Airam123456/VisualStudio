package actividad_2;

import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;

public class Borrar
{
	public static void main (String [] args) 
	{
		FTPClient cliente = new FTPClient();
		String servFTP = "172.20.132.110";
		String usuario = "linux";
		String clave = "linux";
		//System.out.println("Nos conectamos a " + servFTP);
		
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

			// Creamos un nuevo direcctorio y comprobamos si
			// la creación ha sido llevada a cabo correctamente
	        boolean directorioCreado = cliente.removeDirectory("aplicacionwebbrito");
	        boolean directoriosCreados = true;
	        if (directorioCreado) 
	        {
	        directorioCreado = cliente.removeDirectory("aplicacionwebbrito/html");
	            
		    directorioCreado = cliente.removeDirectory("aplicacionwebbrito/imagenes");
		
			directorioCreado = cliente.removeDirectory("aplicacionwebbrito/css");
			//directoriosCreados = false;
	        }
	        
	        if(directoriosCreados == true)
	        	System.out.println("Directorios creados...");
	        else
	        {
	        	System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
				cliente.disconnect();
				System.exit(1);
	        }
	        
	        // Intentamos cerrar sesión y comprobamos si
	        // ha sido llevado a cabo correctamente
			boolean logout = cliente.logout();
			if (logout) 
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

