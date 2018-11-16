package test.java;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.Organizacion;
import main.java.SistemaWeb;
import main.java.TipoMuestra;
import main.java.TipoOrganizacion;
import main.java.Ubicacion;
import main.java.Usuario;

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
	
	//@Test
	//public void testSistemaWeb_registrarMuestra() {}
	
	//@Test
	//public void testSistemaWeb_registrarUsuario() {}
	
	//@Test
	//public void testSistemaWeb_registrarOrganizacion() {}
	
	@Test
	public void testSistemaWeb_validarMuestra() {
		assertEquals("Bajo",this.muestra1.getNivelDeVerificacion());
		this.sistema.validarMuestra(this.muestra1, this.usu1, TipoMuestra.VINCHUCA);
		assertEquals("Bajo",this.muestra1.getNivelDeVerificacion()); //No deberia validar porque es el mismo usuario que lo dio de alta.
		this.sistema.validarMuestra(this.muestra1, this.usu2, TipoMuestra.VINCHUCA);
		assertEquals("Medio",this.muestra1.getNivelDeVerificacion());
	}
	
	@Test
	public void testSistemaWeb_muestrasCercanas() {
		List<Muestra> muestrasCercanas = this.sistema.muestrasCercanas(this.muestra1, 700);
		assertEquals(1,muestrasCercanas.size());
		//assertTrue(muestrasCercanas.contains(this.muestra2));
	}
}
