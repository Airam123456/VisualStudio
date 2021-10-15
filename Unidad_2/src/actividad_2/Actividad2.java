package actividad_2;

public class Actividad2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			Hilo hilo = new Hilo();		//Creamos un hilo
			hilo.setName("Hilo "+ i);	//Le ponemos nombre
			hilo.start();	//Ejecutamos
			hilo.join();	//Esperamos a que termine
		}
		System.out.println("Fin programa");
	}
}
