package actividades_10;

import java.io.Serializable;

public class Tenista implements Serializable
{
	//clase Tenista con atributos y constructor
	private static final long serialVersionUID = 1L;
	private String apellido;
	private int altura;
	
	public Tenista(String apellido, int altura)	{
		this.apellido = apellido;
		this.altura = altura;
	}
	//getters y setters
	public String getApellido() 	{
		return apellido;
	}
	public void setApellido(String apellido) 	{
		this.apellido = apellido;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
}
