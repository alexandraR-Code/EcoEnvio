package com.krakedev.Entidades.EcoEnvio;

public class Dimensiones {
	// atributos
	private double alto;
	private double ancho;
	private double largo;

	// metodos setter y getter

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	// metodo calcularVolumen
	public double calcularVolumen() {
		return alto * ancho * largo;
	}
	//constructor 
	public Dimensiones(double alto, double ancho, double largo) {
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
	}

}
