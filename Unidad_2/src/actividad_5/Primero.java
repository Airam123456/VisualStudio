package actividad_5;

class Primero extends Thread  { 
	public void run() {
		//Bucle
		for (int i=1;i<=15;i++)
		{
			System.out.println( "Primero " + i ); //Sacamos por pantalla el hilo actual
			
			try {
				sleep(100); //Espera de 100ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
