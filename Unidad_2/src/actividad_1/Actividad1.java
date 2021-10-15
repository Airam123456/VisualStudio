package actividad_1;

public class Actividad1 {
	
	public static void main(String[] args) {
		
		Hilo hilo1 = new Hilo();	// Creamos el hilo 1
		hilo1.setName("Primero");	//Asignamos el nombre al hilo 1
		Hilo hilo2 = new Hilo();	//Creamos el hilo 2
		hilo2.setName("Segundo");	//Asignamos el nombre al hilo2
		
		hilo1.start();			// Ejecutamos
		hilo2.start();	
		
		System.out.print("Fin programa");
	
	}

}
