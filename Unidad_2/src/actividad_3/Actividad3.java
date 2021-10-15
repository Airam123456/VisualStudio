package actividad_3;

public class Actividad3 {
	
	public static void main(String arg[]) 
	{
		
		Hilo hilo = new Hilo();		//Creo el hilo
		hilo.setName("Thread-0");	//Le pongo el nombre		
		hilo.setPriority(5);		//Le pongo prioridad
		hilo.start();				//Lo ejecuto
		
		System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());
		
		hilo.setName("SUPER-HILO-DM2"); //Le cambio el nombre
		hilo.setPriority(6);			//Le cambio la prioridad
		
		System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

		System.out.print("Final Programa\n");
	}
}


