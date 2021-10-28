package actividad_14;

public class Actividad14 extends Thread { 
	public static void main(String args[]) {
		Recurso a = new Recurso(); 
		Recurso b = new Recurso(); 
		//Cambiamos el orden en el que accede a las variables para evitar el deadlock
		Hilo h1 = new Hilo(a, b, "uno"); 
		Hilo h2 = new Hilo(a, b, "dos"); 
		//Ejecutamos
		h1.start(); 
		h2.start(); 
	}
}
