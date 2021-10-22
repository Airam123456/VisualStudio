package actividad_5;

public class Actividad5 {
	
	public static void main(String arg[]) {
		
		// Creamos el hilo y le ponemos nombre
		Primero p = new Primero();
		Segundo s = new Segundo();
		
		// Iniciamos el hilo
		p.start();
		s.start();
		
		System.out.println("Fin programa");
	}	
}
