package pregunta_1;

import java.io.Serializable;

public class Coche implements Serializable {
	private static final long serialVersionUID = 1L;
	private int matriculaNum;
	private String marca, modelo,matriculaLetras;
	
	public Coche(int matriculaNum, String matriculaLetras, String marca, String modelo) {
		super();
		this.matriculaNum = matriculaNum;
		this.marca = marca;
		this.modelo = modelo;
		this.matriculaLetras = matriculaLetras;
	}

	public int getMatriculaNum() {
		return matriculaNum;
	}

	public void setMatriculaNum(int matriculaNum) {
		this.matriculaNum = matriculaNum;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatriculaLetras() {
		return matriculaLetras;
	}

	public void setMatriculaLetras(String matriculaLetras) {
		this.matriculaLetras = matriculaLetras;
	}
	
	

}
