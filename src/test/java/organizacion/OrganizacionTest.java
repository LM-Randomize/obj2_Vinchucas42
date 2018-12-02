package test.java.organizacion;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import main.java.Ubicacion;
import main.java.funcionalidad.FENoHacerNada;
import main.java.funcionalidad.IFuncionalidadExterna;
import main.java.muestra.Muestra;
import main.java.organizacion.Organizacion;
import main.java.organizacion.TipoOrganizacion;
import main.java.organizacion.ZonaDeCobertura;

public class OrganizacionTest {
	
	private Organizacion organizacion;
	private Ubicacion ubicacion;
	private List<ZonaDeCobertura> zonasDeCobertura;
	
	@Before
	public void setUp() {
		this.ubicacion = mock(Ubicacion.class);
		this.organizacion = new Organizacion("asist",ubicacion, TipoOrganizacion.ASISTENCIA, 25);
		this.zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
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
	@Test
	public void testOrganizacion_getFuncionAltaMuestra() {
		IFuncionalidadExterna nuevaFunc = new FENoHacerNada();
		this.organizacion.setFuncionAltaMuestra(nuevaFunc);
		assertEquals(nuevaFunc, this.organizacion.getFuncionAltaMuestra());
		}
	@Test
	public void testOrganizacion_getFuncionValidacionMuestra() {
		IFuncionalidadExterna nuevaFunc = new FENoHacerNada();
		this.organizacion.setFuncionValidacionMuestra(nuevaFunc);
		assertEquals(nuevaFunc, this.organizacion.getFuncionValidacionMuestra());
		}
	@Test
	public void testOrganizacion_getZonasDeCobertura() {
		this.zonasDeCobertura.add(mock(ZonaDeCobertura.class));
		this.zonasDeCobertura.add(mock(ZonaDeCobertura.class));
		Organizacion orgZonas = new Organizacion("cult", this.ubicacion, TipoOrganizacion.CULTURAL, 7, zonasDeCobertura, new FENoHacerNada(), new FENoHacerNada());
		assertEquals(this.zonasDeCobertura, orgZonas.getZonasDeCobertura());
	}
	@Test
	public void testOrganizacion_removerZonaDeCobertura() {
		ZonaDeCobertura zonaToRemove = mock(ZonaDeCobertura.class);
		this.zonasDeCobertura.add(zonaToRemove);
		Organizacion orgZonas = new Organizacion("cult", this.ubicacion, TipoOrganizacion.CULTURAL, 7, zonasDeCobertura, new FENoHacerNada(), new FENoHacerNada());
		orgZonas.removerZonaDeCobertura(zonaToRemove);
		assertEquals(this.zonasDeCobertura, orgZonas.getZonasDeCobertura());
		//verifico que llamara al metodo para remover listener.
		verify(zonaToRemove, Mockito.times(1)).removerListener(orgZonas);
	}
	@Test
	public void testOrganizacion_agregarZonaDeCobertura() {
		ZonaDeCobertura zonaToAdd = mock(ZonaDeCobertura.class);
		Organizacion orgZonas = new Organizacion("cult", this.ubicacion, TipoOrganizacion.CULTURAL, 7, zonasDeCobertura, new FENoHacerNada(), new FENoHacerNada());
		orgZonas.agregarZonaDeCobertura(zonaToAdd);
		assertEquals(this.zonasDeCobertura, orgZonas.getZonasDeCobertura());
		//verifico que llamara al metodo para agregar listener.
		verify(zonaToAdd, Mockito.times(1)).agregarListener(orgZonas);
	}
	@Test
	public void testOrganizacion_muestraCargada() {
		IFuncionalidadExterna mockedFunc = mock(FENoHacerNada.class);
		ZonaDeCobertura z = mock(ZonaDeCobertura.class);
		Muestra m = mock(Muestra.class);
		Organizacion orgZonas = new Organizacion("cult", this.ubicacion, TipoOrganizacion.CULTURAL, 7, zonasDeCobertura, mockedFunc, mock(FENoHacerNada.class) );
		orgZonas.muestraCargada(z, m);
		verify(mockedFunc, Mockito.times(1)).nuevoEvento(orgZonas, z, m);
	}
	@Test
	public void testOrganizacion_muestraVerificada() {
		IFuncionalidadExterna mockedFunc = mock(FENoHacerNada.class);
		ZonaDeCobertura z = mock(ZonaDeCobertura.class);
		Muestra m = mock(Muestra.class);
		Organizacion orgZonas = new Organizacion("cult", this.ubicacion, TipoOrganizacion.CULTURAL, 7, zonasDeCobertura, mock(FENoHacerNada.class), mockedFunc);
		orgZonas.muestraVerificada(z, m);
		verify(mockedFunc, Mockito.times(1)).nuevoEvento(orgZonas, z, m);
	}
	}
