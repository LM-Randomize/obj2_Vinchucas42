package test.java.muestra.verificacion;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.muestra.verificacion.NivelVerificacionAlto;
import main.java.muestra.verificacion.NivelesVerificacion;
import main.java.usuario.Usuario;

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
