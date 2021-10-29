package actividad_15;

import actividad_15.Hilo;

public class Actividad15 {
	
	public static void main(String[] args) {
		//Creamos hilos
		Hilo hilo1 = new Hilo();
		Hilo hilo2 = new Hilo();
		Hilo hilo3 = new Hilo();
		//Ponemos nombre a los hilos
		hilo1.setName("Hilo 1");
		hilo2.setName("Hilo 2");
		hilo3.setName("Hilo 3");
		//Ejecutamos hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
}
