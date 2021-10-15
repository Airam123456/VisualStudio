package actividad_2;

public class Hilo extends Thread  {		//Extiende  de Thread
	public void run() {		//Ejecucion
		for (int i = 1 ; i <= 20; i++) 	
			System.out.println(getName()+"\t" + i);	//Nombre mas indice
	}
}
