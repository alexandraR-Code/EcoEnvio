package com.krakedev.test.EcoEnvioJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.Entidades.EcoEnvio.Cliente;
import com.krakedev.Entidades.EcoEnvio.Dimensiones;
import com.krakedev.Entidades.EcoEnvio.Envio;

public class EnvioTest {
	@Test
	public void pruebaCalculoEstandar() {
		Cliente cliente = new Cliente("Carolina", "REGULAR");
		Dimensiones dimensiones = new Dimensiones(5.3, 7.8, 6.4);
		
		Envio envioLiviano = new Envio("AK1254", 5.0, 15.2, "EFECTIVO", 
				dimensiones, cliente);
		assertEquals(27.60, envioLiviano.calcularCostoTotal(), 0.001);	
	}
	@Test
	public void pruebaVolumenExcedido() {
		Cliente  cliente = new Cliente("Carolina", "REGULAR");
		Dimensiones dimensiones = new Dimensiones(50.0, 50.0, 50.0);
		
		Envio envioExcedido = new Envio("BTA524", 3.0, 10.0, "EFECTIVO", 
				dimensiones, cliente);
		assertEquals(25.00, envioExcedido.calcularCostoTotal(), 0.001);	
	}
	@Test
	public void pruebaMembresiaEspecial() {
		Cliente  cliente = new Cliente("Carolina", "PREMIUM");
		Dimensiones dimensiones = new Dimensiones(10, 10, 10);
		
		Envio membresiaExpecial = new Envio("BTA524", 5.0, 15.0, "EFECTIVO", 
				dimensiones, cliente);
		assertEquals(24.75, membresiaExpecial.calcularCostoTotal(), 0.001);		
	}
	@Test
	public void pruebaMetodoPago() {
		Cliente  cliente = new Cliente("Carolina", "VIP");
		Dimensiones dimensiones = new Dimensiones(10.0, 10.0, 10.0);
		
		Envio metodoPago = new Envio("BTA524", 3.0, 10.0, "EFECTIVO", 
				dimensiones, cliente);
		assertEquals(20.0, metodoPago.calcularCostoTotal(), 0.001);	
		
	}
}
