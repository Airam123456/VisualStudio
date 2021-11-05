package actividades_4_5;
import java.net.MalformedURLException;
import java.net.URL;

public class Actividad4 {
	
	public static void visualizar(URL url)
	{	// Metodo visualizar 
		System.out.println("\t Método toString(): " + url.toString());
		System.out.println("\t Método getProtocol(): " + url.getProtocol());
		System.out.println("\t Método getHost(): " + url.getHost());
		System.out.println("\t Método getPort(): " + url.getPort());
		System.out.println("\t Método getFile(): " + url.getFile());
		System.out.println("\t Método getUserInfo(): " + url.getUserInfo());
		System.out.println("\t Método getPath(): " + url.getPath());
		System.out.println("\t Método getAuthority(): " + url.getAuthority());
		System.out.println("\t Método getQuery(): " + url.getQuery());
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		try {// creamos las URL y las visualizamos
			URL url1 = new URL("http://docs.oracle.com");
			System.out.println("Constructor simple para una URL:");
			visualizar(url1);
			
			URL url2 = new URL("http://docs.oracle.com/javase/7");
			System.out.println("Constructor para protocolo, host y directorio:");
			visualizar(url2);
			
			URL url3 = new URL("http://docs.oracle.com:80/javase/7");
			System.out.println("Constructor para protocolo, host, puerto y directorio:");
			visualizar(url3);
			
			URL url4 = new URL(url1,"/javase/7/docs/api/java/net/URL.html");
			System.out.println("Constructor para un objeto URL y su directorio:");
			visualizar(url4);

			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
