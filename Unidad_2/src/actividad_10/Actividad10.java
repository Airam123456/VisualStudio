package actividad_10;

public class Actividad10 {
	
	public static void main(String[] args) {
		
		// Creacion de hilos
		Thread thread0 = new Hilo("Hilo-prioridad 3");
		Thread thread1 = new Hilo("Hilo-prioridad 7");
		
		// Asignacion de prioridades
		thread0.setPriority(3);
		thread1.setPriority(7);
		
		// Mostramos informacion
		System.out.println(Thread.currentThread().getName() + " tiene la prioridad " + Thread.currentThread().getPriority());
		System.out.println(thread0.getName() + " tiene la prioridad " + thread0.getPriority());
		System.out.println(thread1.getName() + " tiene la prioridad " + thread1.getPriority());
		
		// Ejecutamos
		thread0.start();									
		thread1.start();
		
		System.out.println("Fin programa");
	}
}
