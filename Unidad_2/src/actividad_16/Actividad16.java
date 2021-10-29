package actividad_16;

public class Actividad16 {
	public static void main (String[] args) {
		Contador cont = new Contador (100);// Creamos el contador
		HiloA a = new HiloA("HiloA", cont); // Creamos los hilos
		HiloB b = new HiloB("HiloB",cont);
		a.start(); //Los ejecutamos
		b.start(); 
	} 
}
class Contador { // Instanciamos la clase contador
	private int c=0;
	Contador (int c) { 
		this.c = c; 
	}

	public void incrementa() { // contador + 1
		c=c+1;
	}
	public void decrementa() { //contador -1 
		c=c-1;
	}
	public int getValor() { 
		return c; 
	}
}
class HiloA extends Thread { //Clase HiloA
	private Contador contador; // contador
	public HiloA (String n, Contador c) {
		setName(n);
		contador=c;
	}
	public void run () {
		synchronized (contador) { //sincronizador para que no se solapen
		for (int j=0; j < 300; j++) {  //bucle
			contador.incrementa(); // incrementamos 300 veces
		}
			System.out.println(getName() + " contador vale " + contador.getValor());
		}
	}
}
class HiloB extends Thread { //Clase HiloB
	private Contador contador; // contador
	public HiloB (String n, Contador c) {
		setName(n);
		contador=c;
	}
	public void run () {
		synchronized (contador) { //sincronizador para que no se solapen
		for (int j=0; j < 300; j++) {
			contador.decrementa(); // decrementamos 300 veces
		}
			System.out.println(getName() + " contador vale " + contador.getValor());
		}
	}
}

