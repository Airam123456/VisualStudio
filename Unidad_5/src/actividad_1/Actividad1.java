package actividad_1;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Set;

public class Actividad1{
	
	public static void main(String[] args) {
		//instanciar provider  SUN 
		Provider provider = Security.getProvider("SUN"); 
		//nombre proveedor y version
		System.out.println("** Proveedor " + provider.getName() + ", versión " + provider.getVersion() + " ** ");
		//Guardar servicios 
		Set<Service> servicios = provider.getServices(); 
		//pasar por todos los servicios y mostrar los MessageDigest
		for (Service service : servicios) { 
			if(service.getType().equals(MessageDigest.class.getSimpleName())) { 
				System.out.println("\tNombre del algoritmo: \"" + service.getAlgorithm() + "\"");
			}
		}	
	}
}
