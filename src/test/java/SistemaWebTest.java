package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import main.java.SistemaWeb;
import main.java.Ubicacion;
import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.muestra.verificacion.NivelesVerificacion;
import main.java.organizacion.Organizacion;
import main.java.organizacion.TipoOrganizacion;
import main.java.organizacion.ZonaDeCobertura;
import main.java.usuario.Usuario;

public class SistemaWebTest {

	private SistemaWeb sistema;
	private Usuario usu1;
	private Usuario usu2;
	private Usuario usu3;
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Organizacion org1;
	
	@Before
	public void setUp() {
		this.sistema = new SistemaWeb();
		this.usu1 = this.sistema.registrarUsuario("usu1");
		this.usu2 = this.sistema.registrarUsuario("usu2");
		this.usu3 = this.sistema.registrarUsuario("usu3");
		this.muestra1 = this.sistema.registrarMuestra("", new Ubicacion(1,1), usu1, TipoMuestra.VINCHUCA);
		this.muestra2 = this.sistema.registrarMuestra("", new Ubicacion(5,6), usu1, TipoMuestra.VINCHUCA);
		this.muestra3 = this.sistema.registrarMuestra("", new Ubicacion(6,8), usu1, TipoMuestra.VINCHUCA);
		this.org1 = this.sistema.registrarOrganizacion("org1", new Ubicacion(4,5), TipoOrganizacion.SALUD, 2);
		
	}


	@Test
	public void testSistemaWeb_getMuestras() {
		List<Muestra> muestrasResp = this.sistema.getMuestras();
		assertEquals(3,muestrasResp.size());
		assertTrue(muestrasResp.contains(this.muestra1));
		assertTrue(muestrasResp.contains(this.muestra2));
		assertTrue(muestrasResp.contains(this.muestra3));
	}
	
	@Test
	public void testSistemaWeb_getUsuarios() {
		List<Usuario> usuariosResp = this.sistema.getUsuarios();
		assertEquals(3,usuariosResp.size());
		assertTrue(usuariosResp.stream().map(u -> u.getAlias())
				.collect(Collectors.toList()).contains("usu1"));
		assertTrue(usuariosResp.stream().map(u -> u.getAlias())
				.collect(Collectors.toList()).contains("usu2"));
		assertTrue(usuariosResp.stream().map(u -> u.getAlias())
				.collect(Collectors.toList()).contains("usu3"));
	}
	
	@Test
	public void testSistemaWeb_getOrganizaciones() {
		List<Organizacion> org = this.sistema.getOrganizaciones();
		assertEquals(1,org.size());
		assertTrue(org.contains(this.org1));
	}
	
	@Test
	public void testSistemaWeb_registrarMuestra_suscripcionAMuestra() {
		ZonaDeCobertura zona = mock(ZonaDeCobertura.class);
		this.sistema.setZonasDeCobertura(new ArrayList<ZonaDeCobertura>() {{ add(zona); }} );
		Ubicacion mockedUbicacion = mock(Ubicacion.class);
		when(mockedUbicacion.distanciaCon(Matchers.any())).thenReturn((double) 10);
		
		this.sistema.registrarMuestra("lalala.com", mockedUbicacion, this.usu3, TipoMuestra.INDEFINIDO);
		
		verify(zona).subscribirMuestraSiPertenece(Matchers.any());
	}
	
	//@Test
	//public void testSistemaWeb_registrarUsuario() {}
	
	//@Test
	//public void testSistemaWeb_registrarOrganizacion() {}
	
	//@Test
	//public void testSistemaWeb_registrarZonaDeCobertura() {}
	
	
	@Test
	public void testSistemaWeb_validarMuestra() {
		assertEquals(NivelesVerificacion.BAJO,this.muestra1.getNivelDeVerificacion());
		this.sistema.validarMuestra(this.muestra1, this.usu1, TipoMuestra.VINCHUCA);
		assertEquals(NivelesVerificacion.BAJO,this.muestra1.getNivelDeVerificacion()); //No deberia validar porque es el mismo usuario que lo dio de alta.
		this.sistema.validarMuestra(this.muestra1, this.usu2, TipoMuestra.VINCHUCA);
		assertEquals(NivelesVerificacion.MEDIO,this.muestra1.getNivelDeVerificacion());
	}
	
	@Test
	public void testSistemaWeb_muestrasCercanas() {
		List<Muestra> muestrasCercanas = this.sistema.muestrasCercanas(this.muestra1, 700);
		assertEquals(1,muestrasCercanas.size());
		//assertTrue(muestrasCercanas.contains(this.muestra2));
	}
	
	@Test
	public void testSistemaWeb_suscribirOrganizacionAZonaDeCobertura() {
		ZonaDeCobertura mockedZona = mock(ZonaDeCobertura.class);
		Organizacion mockedOrg = mock(Organizacion.class);
		
		this.sistema.suscribirOrganizacionAZonaDeCobertura(mockedOrg,mockedZona);
		
		verify(mockedZona).agregarListener(mockedOrg);
	}
	
	@Test
	public void testSistemaWeb_desuscribirOrganizacionAZonaDeCobertura() {
		ZonaDeCobertura mockedZona = mock(ZonaDeCobertura.class);
		Organizacion mockedOrg = mock(Organizacion.class);
		
		this.sistema.desuscribirOrganizacionAZonaDeCobertura(mockedOrg,mockedZona);
		
		verify(mockedZona).removerListener(mockedOrg);
	}
}
