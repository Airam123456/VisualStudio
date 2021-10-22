package actividad_5;

class Segundo extends Thread { 
	public void run() {
		//Bucle
		for (int i=1;i<=15;i++)
		{
			System.out.println( "Segundo " + i ); //Sacamos por pantalla el hilo actual
			
			try {
				sleep(200); //Espera de 200ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
