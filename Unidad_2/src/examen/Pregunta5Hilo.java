package examen;

public class Pregunta5Hilo extends Thread {
	
	private String cadena;

	public Pregunta5Hilo(String cadena) {
		this.cadena = cadena;
	}
	
	public void run() {
		for (int i = 1 ; i <= 3; i++) {
			System.out.println(cadena + i);
		}
	}
}
