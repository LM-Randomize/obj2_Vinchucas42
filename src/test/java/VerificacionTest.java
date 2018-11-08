package test.java;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.TipoMuestra;
import main.java.Ubicacion;
import main.java.Verificacion;

public class VerificacionTest {

	private Verificacion verificacion1;

	@Before
	public void setUp() {
		this.verificacion1 = new Verificacion(TipoMuestra.INDEFINIDO);
	}
	
	@Test
	public void testVerificacion_getTipoMuestra() {
		assertEquals(TipoMuestra.INDEFINIDO,this.verificacion1.getTipoMuestra());
	}
	@Test
	public void testVerificacion_getFecha() {
		assertEquals(new Date(),this.verificacion1.getFecha());
	}
	
}
