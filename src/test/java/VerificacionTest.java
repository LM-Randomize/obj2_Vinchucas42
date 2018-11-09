package test.java;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.TipoMuestra;
import main.java.Usuario;
import main.java.Verificacion;

public class VerificacionTest {

	private Verificacion verificacion1;
	private Muestra muestra;
	private Usuario usuario;

	@Before
	public void setUp() {
		this.muestra = mock(Muestra.class);
		this.usuario = mock(Usuario.class);
		this.verificacion1 = new Verificacion(TipoMuestra.INDEFINIDO, this.muestra, this.usuario);
	}
	
	@Test
	public void testVerificacion_getTipoMuestra() {
		assertEquals(TipoMuestra.INDEFINIDO,this.verificacion1.getTipoMuestra());
	}
	@Test
	public void testVerificacion_getFecha() {
		assertEquals(new Date(),this.verificacion1.getFecha());
	}
	@Test
	public void testVerificacion_getMuestra() {
		assertEquals(this.muestra,this.verificacion1.getMuestra());
	}	
	@SuppressWarnings("deprecation")
	@Test
	public void testVerificacion_setFecha() {
		Date newDate = new Date(2018, 10, 24);
		this.verificacion1.setFecha(newDate);
		assertEquals(newDate,this.verificacion1.getFecha());
	}
	@Test
	public void testVerificacion_setTipoMuestra() {
		this.verificacion1.setTipoMuestra(TipoMuestra.VINCHUCA);
		assertEquals(TipoMuestra.VINCHUCA,this.verificacion1.getTipoMuestra());
	}
}
