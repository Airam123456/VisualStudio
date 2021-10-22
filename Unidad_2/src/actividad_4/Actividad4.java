package actividad_4;

public class Actividad4 {
	public static void main(String[] args) 
	{
		// Creamos el hilo y le ponemos nombre
		Thread p = new Thread(new Posicion(),"primero");
		Thread s = new Thread(new Posicion(), "segundo");	
		
		// Iniciamos el hilo
		p.start();
		s.start();
		
		System.out.println("Fin programa");
	}
}
