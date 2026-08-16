package com.krakedev.Entidades.EcoEnvio;

public class Envio {
	//atributos 
	private String idEnvio;
	private double pesoKg;
	private double distanciaKm;
	private String metodoPago;
	//composicion 
	private Dimensiones dimensiones;
	private Cliente cliente;
	
	//metodos getter setter
	public String getIdEnvio() {
		return idEnvio;
	}
	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}
	public double getPesoKg() {
		return pesoKg;
	}
	public void setPesoKg(double pesoKg) {
		this.pesoKg = pesoKg;
	}
	public double getDistanciaKm() {
		return distanciaKm;
	}
	public void setDistanciaKm(double distanciaKm) {
		this.distanciaKm = distanciaKm;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	//metodos setter y getter de composision 
	public Dimensiones getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(Dimensiones dimensiones) {
		this.dimensiones = dimensiones;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//constructor 
	public Envio(String idEnvio, double pesoKg, double distanciaKm, String metodoPago, 
			Dimensiones dimensiones,Cliente cliente ) {
		this.idEnvio = idEnvio;
		this.pesoKg = pesoKg;
		this.distanciaKm = distanciaKm;
		this.metodoPago = metodoPago;
		this.dimensiones = dimensiones;
		this.cliente = cliente;
	}
	
	//metodo calcularCosto 
	public double calcularCostoTotal() {
		if(pesoKg <= 0) {
			return 0.0;
		}else if(distanciaKm <= 0) {
			return 0.0;
		}else if(dimensiones == null 
				|| dimensiones.getAlto() <=0 
				|| dimensiones.getAncho() <= 0
				|| dimensiones.getLargo() <= 0) {
			return 0.0;
		}else if(!esMetodoDePagoValido(metodoPago)) {
			return 0.0;
		}else if(cliente == null || !esMembresiaValida(cliente.getTipoMembresia())) {
			return 0.0;
		}
		double costoAcumulado;
		//tarifa base por peso distancia
		if(pesoKg <= 5) {
			costoAcumulado = 5.00 +(0.50 * distanciaKm);
		}else if(pesoKg > 5 && pesoKg <= 20) {
			costoAcumulado = 10.00 +(0.80 * distanciaKm);
		}else {
			costoAcumulado = 20.00 +(1.20 * distanciaKm); 
		}
		
		//recargo por volumen de paquete 
		double volumenP = dimensiones.calcularVolumen();
		if(volumenP > 50.000) {
			costoAcumulado+=15.00;
		}
		//descuento por membresia
		String membresia = cliente.getTipoMembresia();
		if(membresia.equals("PREMIUM")) {
			costoAcumulado = costoAcumulado * (1 - 0.10);
		}else if(membresia.equals("VIP")) {
			costoAcumulado = costoAcumulado *(1 - 0.20);
		}
		//Ajustes finales por metodo de pago 
		if(metodoPago.equals("TRANSFERENCIAS")) {
			costoAcumulado = costoAcumulado * (1 - 0.05);
		}else if(metodoPago.equals("TARJETA")) {
			costoAcumulado = costoAcumulado * (1 - 0.03);
		}
		
		return costoAcumulado;
	}
	 private boolean esMetodoDePagoValido(String metodo) {
		 return "EFECTIVO".equals(metodo)
				 || "TARJETA".equals(metodo)
				 || "TRANSFERENCIA".equals(metodo);
	 }
	 private boolean esMembresiaValida(String membresia) {
		 return "REGULAR".equals(membresia)
				 || "PREMIUM".equals(membresia)
				 || "VIP".equals(membresia);
	 }
		
}
	 
