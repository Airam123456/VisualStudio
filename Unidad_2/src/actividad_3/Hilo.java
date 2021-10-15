package actividad_3;

public class Hilo extends Thread{
	public void run()
	{
		try {
			sleep(10000); // Le he puesto el sleep para que espere un poco y le de tiempo de cambiar prioridades
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
