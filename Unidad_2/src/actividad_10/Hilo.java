package actividad_10;

public class Hilo extends Thread{
	
	private String mensaje;
	
	public Hilo(String mensaje ) { //Aqui asignamos el mensaje
		this.mensaje = mensaje;
	}
	public void run() { // Mostramos mensajes
		//System.out.println("Ejecutando Hilo-prioridad " + getPriority());
		System.out.println("Ejecuntado " + mensaje);
	}
}
