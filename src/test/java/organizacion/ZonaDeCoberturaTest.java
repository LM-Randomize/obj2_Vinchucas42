package test.java.organizacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import main.java.Ubicacion;
import main.java.muestra.Muestra;
import main.java.muestra.verificacion.Verificacion;
import main.java.organizacion.Organizacion;
import main.java.organizacion.ZonaDeCobertura;

public class ZonaDeCoberturaTest {

	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	private Ubicacion mockedUbicacion1;
	private Ubicacion mockedUbicacion2;
	
	@Before
	public void setUp() {
		this.mockedUbicacion1 = mock(Ubicacion.class);
		this.mockedUbicacion2 = mock(Ubicacion.class);
		when(mockedUbicacion1.distanciaCon(this.mockedUbicacion2)).thenReturn((double) 40);
		when(mockedUbicacion2.distanciaCon(this.mockedUbicacion1)).thenReturn((double) 40);

		this.zona1 = new ZonaDeCobertura("zona1", this.mockedUbicacion1, 20);
		this.zona2 = new ZonaDeCobertura("zona2", this.mockedUbicacion1, 30);
	}
	

	@Test
	public void ZonaDeCoberturaTest_getNombre() {
		assertEquals("zona1",this.zona1.getNombre());
	}
	@Test
	public void ZonaDeCoberturaTest_getEpicentro() {
		assertEquals(this.mockedUbicacion1,this.zona1.getEpicentro());
	}
	@Test
	public void ZonaDeCoberturaTest_getRadio() {
		assertEquals((double)20,this.zona1.getRadio(),0);
	}
	@Test
	public void ZonaDeCoberturaTest_getMuestras() {
		assertEquals(0,this.zona1.getMuestras().size());
	}
	

	/*public void ZonaDeCoberturaTest_agregarListener(ZonaDeCoberturaListener l) {
		this.listeners.add(l);
	}
	public void ZonaDeCoberturaTest_removerListener(ZonaDeCoberturaListener l) {
		this.listeners.remove(l);
	}*/

	@Test
	public void ZonaDeCoberturaTest_seSolapaCon() {
		assertTrue(this.zona1.seSolapaCon(this.zona2));
	}
	@Test
	public void ZonaDeCoberturaTest_perteneceUbicacion() {
		assertFalse(this.zona1.perteneceUbicacion(this.mockedUbicacion2));
	}
	@Test
	public void ZonaDeCoberturaTest_subscribirMuestraSiPertenece() {
		Muestra mockedMuestra = mock(Muestra.class);
		when(mockedMuestra.getUbicacion()).thenReturn(this.mockedUbicacion1);
		this.zona1.subscribirMuestraSiPertenece(mockedMuestra);
		
		assertEquals(1, this.zona1.getMuestras().size());
	}
	
	@Test
	public void ZonaDeCoberturaTest_notificaciones() {
		Muestra mockedMuestra = mock(Muestra.class);
		when(mockedMuestra.getUbicacion()).thenReturn(this.mockedUbicacion1);
		Organizacion mockedOrganizacion = mock(Organizacion.class); 
		
		this.zona1.agregarListener(mockedOrganizacion);
		this.zona1.subscribirMuestraSiPertenece(mockedMuestra);

		verify(mockedOrganizacion).muestraCargada(this.zona1, mockedMuestra);
		
		Verificacion mockedVerificacion = mock(Verificacion.class);
		this.zona1.muestraVerificada(mockedMuestra, mockedVerificacion);
		
		verify(mockedOrganizacion).muestraVerificada(this.zona1, mockedMuestra);
	}

}
