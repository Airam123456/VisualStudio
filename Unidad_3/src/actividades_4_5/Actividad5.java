package actividades_4_5;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Actividad5 
{
	
	private static void visualizarConexion(URLConnection conexion)
	{	// Metdodo para visualizar la conexion
		System.out.println("Conexión con " + conexion.getURL().getHost());
		System.out.println("===============================");
		System.out.println("\t Método toString(): " + conexion.toString());
		System.out.println("\t Método getDate(): " + conexion.getDate());
		System.out.println("\t Método getContentType(): " + conexion.getContentType());
		
		System.out.println("Campos Cabecera con getHeaderField:");
		System.out.println("========================================");
		System.out.println("\t\t Línea 1: " + conexion.getHeaderField(0));
		System.out.println("\t\t Línea 2: " + conexion.getHeaderField(1));
		System.out.println("\t\t Línea 3: " + conexion.getHeaderField(2));
		System.out.println("\t\t Línea 4: " + conexion.getHeaderField(3));
		System.out.println("\t\t Línea 5: " + conexion.getHeaderField(4));
		
		System.out.println("Campos Cabecera con getHeaderFields:");
		System.out.println("=========================================");
		System.out.println("Keep-Alive: [" + conexion.getHeaderField("Keep-Alive") + "]");
		System.out.println("null: [" + conexion.getHeaderField(null) + "]");
		System.out.println("Server: [" + conexion.getHeaderField("Server") + "]");
		System.out.println("Connection: [" + conexion.getHeaderField("Connection") + "]");
		System.out.println("Content-Length: [" + conexion.getHeaderField("Content-Length") + "]");
		System.out.println("Date: [" + conexion.getHeaderField("Date") + "]");
		System.out.println("Content-Type: [" + conexion.getHeaderField("Content-Type") + "]");
		System.out.println("Location: [" + conexion.getHeaderField("Location") + "]");
	}

	public static void main(String[] args) 
	{
		try 
		{	// creamos la conexion url y la visualizamos
			URL url = new URL("http", "kaixo.com", 80, "");
			URLConnection conexion = url.openConnection();
			visualizarConexion(conexion);
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
