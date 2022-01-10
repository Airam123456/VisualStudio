package ejemplo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.*;

public class SubirFicheros {

	public static void main (String[] args) {

		FTPClient cliente = new FTPClient (); // cliente
		String servidor = "172.20.132.105"; // Servidor
		String user="dm2";
		String pasw="dm2";
		String direct ="DIRECTORIO";
		String fichero ="/home/dm2/Escritorio/txtparaPROS.txt";
		String ficherodestino="txtparaPROS.txt";
		String fichero2 ="/home/dm2/Escritorio/Pruebas1.jpg"; 
		String ficherodestino2="Escritorio/Pruebas1.jpg";
		try {
			System.out.println("Conectándose a "+ servidor);
			cliente.connect(servidor);
			boolean login=cliente.login(user, pasw);
			if (login) {
				cliente.changeWorkingDirectory(direct);
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				// Stream de entrda con el fichero a subir
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(fichero));
				cliente.storeFile(ficherodestino, in);

				// Stream de entrada con el fichero a subir
				in = new BufferedInputStream(new FileInputStream(fichero2));
				cliente.storeFile(ficherodestino2, in);
				System.out.println("Ficheros subidos");
				in.close();
				cliente.logout();
				cliente.disconnect();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}