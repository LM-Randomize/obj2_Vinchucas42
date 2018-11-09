package test.java;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import main.java.Organizacion;
import main.java.TipoOrganizacion;
import main.java.Ubicacion;

public class OrganizacionTest {
	
	private Organizacion organizacion;
	private Ubicacion ubicacion;
	
	@Before
	public void setUp() {
		this.ubicacion = mock(Ubicacion.class);
		this.organizacion = new Organizacion("asist",ubicacion, TipoOrganizacion.ASISTENCIA, 25);
	}

	@Test
	public void testOrganizacion_getNombre() {
		assertEquals("asist", this.organizacion.getNombre());
	}
	@Test
	public void testOrganizacion_getUbicacion() {
		assertEquals(this.ubicacion, this.organizacion.getUbicacion());
	}
	@Test
	public void testOrganizacion_getTipo() {
		assertEquals(TipoOrganizacion.ASISTENCIA, this.organizacion.getTipo());
	}
	@Test
	public void testOrganizacion_getCantTrabajadores() {
		assertEquals(25, this.organizacion.getCantTrabajadores());
	}
}
