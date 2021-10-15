package actividad_1;

public class Hilo extends Thread { 		//Extiende  de Thread
	public void run() //Ejecutamos y sacamos el nombre 20 veces
	{
		for (int i = 1 ; i < 20; i++) 	
			System.out.println(getName()+"\t" + i);	//Nombre mas indice
	}
}