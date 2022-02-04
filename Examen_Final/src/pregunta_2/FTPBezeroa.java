package pregunta_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPBezeroa {
	public static void main(String[] args) {
		
		FTPClient cliente = new FTPClient();
		String servFTP = "172.20.132.110";
		String usuario = "linux";
		String clave = "linux";
		String ficheroOrigen ="/home/dm2/Escritorio/airam.txt";
		String ficheroDestino="fichero.txt";
		
		//System.out.println("Nos conectamos a " + servFTP);
		
		try {
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
			
			
			// Creamos los directorios
			try {
				System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
				boolean dirSige = cliente.makeDirectory("SIGE");
				boolean dirDein = cliente.makeDirectory("DEIN");
				boolean dirPros = cliente.makeDirectory("PROS");
				boolean dirProm = cliente.makeDirectory("PROM");
				
				//Comprobamos
				if (dirSige && dirDein && dirPros && dirProm) {
					System.out.println("Directorios creado");
				} else {
					System.out.println("Error en la creacion");
				}
			} catch (IOException e) {
				System.out.println("Error en la creacion");
			}
			
			//Subimos el fichero airam.txt
			try {
				cliente.changeWorkingDirectory("./PROS");
				System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
				BufferedInputStream bisOrigen = new BufferedInputStream(new FileInputStream(ficheroOrigen));
				cliente.storeFile(ficheroDestino, bisOrigen);
				System.out.println("Fichero subido");
			} catch (IOException e) {
				System.out.println("Eerror al subir el fichero");
			}
			
			
			//Renombrar el fichero
			try {
				cliente.rename("airam.txt", "airam2.txt");
				System.out.println("Fichero renombrado..");
			} catch (IOException e) {
				System.out.println("No se ha podido renombrar el fichero");
			}
			
			
			//Descargar Fichero
			try {
				BufferedOutputStream out = new BufferedOutputStream (new FileOutputStream ("/home/dm2/Escritorio/airam.txt"));
				if (cliente.retrieveFile("airam2.txt", out)) {
					System.out.println("Fichero descargado..");
				} else {
					System.out.println("No se ha podido descargar el fichero");
				}
			} catch (FileNotFoundException e1) {
				System.out.println("No se ha encontrado el fichero");
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			//Logout
			try {
				boolean logout = cliente.logout();
				System.out.println(logout ? "Logout del servidor FTP..." : "Error al hacer logout");
			} catch (IOException e) {
				System.out.println("Error al hacer logout");
			}

			//Desconectamos 
			try {
				cliente.disconnect();
				System.out.println("Desconectado...");
			} catch (IOException e) {
				System.out.println("Error al hacer la desconexión");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
