package actividad_4;

public class Posicion implements Runnable{	//Implementamos la clase Runneable
	
	public synchronized void run() 
	{
		//Bucle de 15
		for(int i = 1; i <= 15; i++) 
		{
			//Sacamos por pantalla el nombre del hilo actual y su posicion
			System.out.println("Hilo "+ Thread.currentThread().getName()+ " "+ i);	
		}
	}
}
