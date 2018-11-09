package test.java;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.NivelVerificacionBajo;
import main.java.TipoMuestra;
import main.java.Ubicacion;
import main.java.Usuario;
import main.java.UsuarioEspecialista;

public class MuestraTest {

	private Muestra muestra;
	private Ubicacion ubicacion;
	private Usuario propietario;
	
	@Before
	public void setUp() {
		this.propietario = mock(Usuario.class);
		this.ubicacion = mock(Ubicacion.class);
		this.muestra = new Muestra("foto", this.ubicacion, this.propietario, TipoMuestra.VINCHUCA);
	}
	@Test
	public void muestraTest_getFoto() {
		assertEquals("foto", this.muestra.getFoto());
	}
	@Test
	public void muestraTest_getPropietario() {
		when(propietario.getAlias()).thenReturn("Juan");
		assertEquals("Juan", this.muestra.getPropietario());
	}
	@Test
	public void muestraTest_getUbicacion() {
		assertEquals(this.ubicacion, this.muestra.getUbicacion());
	}
	@Test
	public void muestraTest_getNivelDeVerificacion() {
		assertEquals("Bajo", this.muestra.getNivelDeVerificacion());
	}
	@Test
	public void muestraTest_getTipoDeMuestra() {
		assertEquals(TipoMuestra.VINCHUCA, this.muestra.getTipoDeMuestra());
	}
	@Test
	public void muestraTest_getFechaCaptura() {
		assertEquals(new Date(), this.muestra.getFechaCaptura());
	}
	@Test
	public void muestraTest_setTipoDeMuestra() {
		this.muestra.setTipoDeMuestra(TipoMuestra.CHINCHEFOLIADA);
		assertEquals(TipoMuestra.CHINCHEFOLIADA, this.muestra.getTipoDeMuestra());
	}
	@Test
	public void muestraTest_setNivelVerificacion() {
		NivelVerificacionBajo nivVerifBajo = new NivelVerificacionBajo();
		this.muestra.setNivelDeVerificacion(nivVerifBajo);		
		assertEquals("Bajo", this.muestra.getNivelDeVerificacion());
	}
	@Test
	public void muestraTest_verificar() {
		NivelVerificacionBajo spyNivelVerifBajo = spy(new NivelVerificacionBajo());
		this.muestra.setNivelDeVerificacion(spyNivelVerifBajo);		
		UsuarioEspecialista newUser = new UsuarioEspecialista("Diego");
		this.muestra.verificar(newUser, TipoMuestra.IMAGENPOCOCLARA);
		//verifico que se llamara al método del NivelVerificacion
		verify(spyNivelVerifBajo).verificar(this.muestra, newUser , TipoMuestra.IMAGENPOCOCLARA);
		//verifico que el nivel cambió a "alto" y el tipo de muestra es el que le pasó el usuario especialista.
		assertEquals("Alto", this.muestra.getNivelDeVerificacion());
		assertEquals(TipoMuestra.IMAGENPOCOCLARA, this.muestra.getTipoDeMuestra());
	}
}
