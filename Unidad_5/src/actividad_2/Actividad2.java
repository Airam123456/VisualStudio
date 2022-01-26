package actividad_2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class Actividad2 {

	public static void main(String[] args) {
		try {
			//Clave publica
			FileInputStream clavePublica = new FileInputStream("Clave.publica");
			byte[] bufferPublica = new byte[clavePublica.available()];
			clavePublica.read(bufferPublica);
			KeyFactory keyDSA= KeyFactory.getInstance("DSA");
			//Pasar a formato X509
			X509EncodedKeySpec clavePublicaSpec = new X509EncodedKeySpec(bufferPublica);
			PublicKey clavePublicaKey = keyDSA.generatePublic(clavePublicaSpec);
			//Leer fichero firma
			FileInputStream ficheroFirma = new FileInputStream("FICHERO.FIRMA");
			byte[] sigToVerify = new byte[ficheroFirma.available()];
			ficheroFirma.read(sigToVerify);
			//Usar Sinature con la clave publica
			Signature signature = Signature.getInstance("SHA1withDSA");
			signature.initVerify(clavePublicaKey);
			//Verificar la firma
			FileInputStream ficheroDAT =  new FileInputStream("FICHERO.DAT");
			BufferedInputStream bufferFich = new BufferedInputStream(ficheroDAT);
			byte[] datos = bufferFich.readAllBytes();
			System.out.println(new String(datos));
			signature.update(datos);
			
			if(signature.verify(sigToVerify)) {
				System.out.println("LOS DATOS SE CORRESPONDEN CON SU FIRMA");
			}
			else {
				System.out.println("LOS DATOS NO SE CORRESPONDEN CON SU FIRMA");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
