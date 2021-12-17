package actividades_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		try {
			System.out.println("PROGRAMA CLIENTE INCIADO");
			// Conexion con el servidor
			Socket cliente = new Socket("localhost", 6000);
			// Declaramos el reader y el writer
			PrintWriter writer = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			//Cadena donde se guardara la palabra
			String cadena = "";
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			//Bucle que continuara funcionando hasta que se introduzca el *
			while(!cadena.trim().equals("*")) {
				System.out.println("Introduce una cadena: ");
				cadena = input.readLine();
				writer.println(cadena);
				String respuesta = reader.readLine();
				System.out.println("Respuesta: " + respuesta);
			}
			//Cerramos todas las conexiones
			System.out.println("Fin del envío...");
			input.close();
			reader.close();
			writer.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
