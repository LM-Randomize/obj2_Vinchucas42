package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.Ubicacion;

public class UbicacionTest {

	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;

	@Before
	public void setUp() {
		this.ubicacion1 = new Ubicacion(1,1);
		this.ubicacion2 = new Ubicacion(4,5);
		
	}
	
	@Test
	public void testUbicacion_distanciaCon() {
		assertEquals((double)5, this.ubicacion1.distanciaCon(ubicacion2), 1);
	}
	
}
