package examen;

public class Pregunta5 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		String cadena1 = "El 1: ==> ";
		String cadena2 = "El 2: ==> ";
		String cadena3 = "El 3: ==> ";
		String cadena4 = "El 4: ==> ";
		
		Pregunta5Hilo t1 = new Pregunta5Hilo(cadena1);
		Pregunta5Hilo t2 = new Pregunta5Hilo(cadena2);
		Pregunta5Hilo t3 = new Pregunta5Hilo(cadena3);
		Pregunta5Hilo t4 = new Pregunta5Hilo(cadena4);
		
		t1.setPriority(5);
		t2.setPriority(9);
		t3.setPriority(7);
		t4.setPriority(3);
		
		t1.start();
		t1.sleep(20);
		t2.start();
		t2.sleep(20);
		t3.start();
		t3.sleep(20);
		t4.start();
		t4.sleep(20);
		
	}

}
