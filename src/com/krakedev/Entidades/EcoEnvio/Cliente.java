package com.krakedev.Entidades.EcoEnvio;

public class Cliente {
	// atributos
	private String nombre;
	private String tipoMembresia;
		
	//metodos getter y setter 
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoMembresia() {
		return tipoMembresia;
	}
	public void setTipoMembresia(String tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
	}
	//constructor 
	public Cliente(String nombre, String tipoMembresia) {
		this.nombre = nombre;
		this.tipoMembresia = tipoMembresia;
	}
	
}
