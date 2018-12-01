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
import main.java.TipoMuestra;
import main.java.Ubicacion;
import main.java.Usuario;
import main.java.UsuarioEspecialista;
import main.java.verificacion.INivelVerificacion;
import main.java.verificacion.NivelVerificacionBajo;
import main.java.verificacion.NivelVerificacionMedio;
import main.java.verificacion.NivelesVerificacion;
import main.java.verificacion.Verificacion;

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
		assertEquals(NivelesVerificacion.BAJO, this.muestra.getNivelDeVerificacion());
	}
	@Test
	public void muestraTest_getTipoDeMuestra() {
		assertEquals(TipoMuestra.VINCHUCA, this.muestra.getTipoDeMuestra());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void muestraTest_getFechaCaptura() {
		Date fechaResp = this.muestra.getFechaCaptura();
		Date fechaHoy = new Date();
		assertEquals(fechaHoy.getDay(), fechaResp.getDay());
		assertEquals(fechaHoy.getMonth(), fechaResp.getMonth());
		assertEquals(fechaHoy.getYear(), fechaResp.getYear());
	}
	@Test
	public void muestraTest_setTipoDeMuestra() {
		this.muestra.setTipoDeMuestra(TipoMuestra.CHINCHEFOLIADA);
		assertEquals(TipoMuestra.CHINCHEFOLIADA, this.muestra.getTipoDeMuestra());
	}
	@Test
	public void muestraTest_setNivelVerificacion() {
		INivelVerificacion nivVerifBajo = new NivelVerificacionMedio();
		this.muestra.setNivelDeVerificacion(nivVerifBajo);		
		assertEquals(NivelesVerificacion.MEDIO, this.muestra.getNivelDeVerificacion());
	}
	@Test
	public void muestraTest_getVerificaciones() {
		assertEquals(1, this.muestra.getVerificaciones().size());
	}
	@Test
	public void muestraTest_verificar() {
		NivelVerificacionBajo spyNivelVerifBajo = spy(new NivelVerificacionBajo());
		this.muestra.setNivelDeVerificacion(spyNivelVerifBajo);		
		UsuarioEspecialista newUser = new UsuarioEspecialista("Diego");
		this.muestra.verificar(newUser, TipoMuestra.IMAGENPOCOCLARA);
		//verifico que se llamara al m�todo del NivelVerificacion
		verify(spyNivelVerifBajo).verificar(this.muestra, newUser , TipoMuestra.IMAGENPOCOCLARA);
		//verifico que el nivel cambio a "alto" y el tipo de muestra es el que le paso el usuario especialista.
		assertEquals(NivelesVerificacion.ALTO, this.muestra.getNivelDeVerificacion());
		assertEquals(TipoMuestra.IMAGENPOCOCLARA, this.muestra.getTipoDeMuestra());
	}
	

	@Test
	public void muestraTest_getCantVerificacionesDeTipo() {
		assertEquals(1,this.muestra.getCantVerificacionesDeTipo(TipoMuestra.VINCHUCA));
		this.muestra.agragarVerificacion(new Verificacion(TipoMuestra.NINGUNA,this.muestra,propietario));
		assertEquals(1,this.muestra.getCantVerificacionesDeTipo(TipoMuestra.NINGUNA));
		this.muestra.agragarVerificacion(new Verificacion(TipoMuestra.NINGUNA,this.muestra,propietario));
		assertEquals(2,this.muestra.getCantVerificacionesDeTipo(TipoMuestra.NINGUNA));
	}

	@Test
	public void muestraTest_SubirDeNivelAlVerificar() {
		assertEquals(1,this.muestra.getCantVerificacionesDeTipo(TipoMuestra.VINCHUCA));
		this.muestra.verificar(new Usuario("martin"), TipoMuestra.VINCHUCA);
		assertEquals(NivelesVerificacion.MEDIO,this.muestra.getNivelDeVerificacion());
	}
	
}
