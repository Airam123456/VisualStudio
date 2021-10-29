package actividad_15;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hilo extends Thread{
	
	private DateFormat  df; // formato de fecha
	private Date date; //Fecha
	
	public Hilo()
	{
		df = new SimpleDateFormat("HH:mm:ss"); //Establecemos el formato
	}
	
	public void run() 
	{

		for (int i = 1 ; i <= 5; i++) {	//Bucle
			date = new Date(); //Nueva fecha
			System.out.println(getName()+" - " + df.format(date));	//Imprimimos resultado
			try {
				sleep(1000); // Espera de 1 segundo
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
