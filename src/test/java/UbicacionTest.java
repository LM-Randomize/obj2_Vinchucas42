package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.Ubicacion;

public class UbicacionTest {

	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private Ubicacion ubicacion4;

	@Before
	public void setUp() {
		this.ubicacion1 = new Ubicacion(1,1);
		this.ubicacion2 = new Ubicacion(4,5);
		this.ubicacion3 = new Ubicacion(5,6);
		this.ubicacion4 = new Ubicacion(6,8);
		
	}
	
	@Test
	public void testUbicacion_getLatitud() {
		assertEquals((double)1, this.ubicacion1.getLatitud(), 0);
	}
	@Test
	public void testUbicacion_getLongitud() {
		assertEquals((double)1, this.ubicacion1.getLongitud(), 0);
	}
	@Test
	public void testUbicacion_distanciaCon() {
		assertEquals((double)555, this.ubicacion1.distanciaCon(ubicacion2), 1);
		assertEquals((double)711, this.ubicacion1.distanciaCon(ubicacion3), 1);
		assertEquals((double)955, this.ubicacion1.distanciaCon(ubicacion4), 1);
	}

	@Test
	public void testUbicacion_ubicacionesCercanas() {
		List<Ubicacion> ubs = new ArrayList<>();
		ubs.add(this.ubicacion2);
		ubs.add(this.ubicacion3);
		ubs.add(this.ubicacion4);
		assertEquals(2, this.ubicacion1.ubicacionesCercanas(ubs,800).size());
	}
	
}
