package test.java;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;

import main.java.Muestra;
import main.java.TipoMuestra;
import main.java.Usuario;
import main.java.verificacion.NivelVerificacionAlto;
import main.java.verificacion.NivelesVerificacion;

public class NivelVerificacionAltoTest {
	private NivelVerificacionAlto nivelVerificacion = new NivelVerificacionAlto();
	
	@Test
	public void testNivelVerificacionAlto_getNivel() {
		assertEquals(NivelesVerificacion.ALTO, this.nivelVerificacion.getNivel());
	}
	
	@Test
	public void testNivelVerificacionAlto_verificar() {
		Usuario usuario = mock(Usuario.class);
		Muestra muestra= mock(Muestra.class);
		this.nivelVerificacion.verificar(muestra, usuario, TipoMuestra.INDEFINIDO);
		//verifico que no interactuara con la muestra o el usuario.
		verifyZeroInteractions(muestra);
		verifyZeroInteractions(usuario);
	}
}
