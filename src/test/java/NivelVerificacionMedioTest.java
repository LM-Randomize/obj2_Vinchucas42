package test.java;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import main.java.Muestra;
import main.java.NivelUsuario;
import main.java.TipoMuestra;
import main.java.Usuario;
import main.java.verificacion.NivelVerificacion;
import main.java.verificacion.NivelVerificacionMedio;
import main.java.verificacion.NivelesVerificacion;

public class NivelVerificacionMedioTest {
	private NivelVerificacionMedio nivelVerificacion = new NivelVerificacionMedio();
	
	@Test
	public void testNivelVerificacionMedio_getNivel() {
		assertEquals(NivelesVerificacion.MEDIO, this.nivelVerificacion.getNivel());
	}
	
	@Test
	public void testNivelVerificacionMedio_verificar() {
		Usuario usuario = mock(Usuario.class);
		Muestra muestra= mock(Muestra.class);
		when(usuario.getNivel()).thenReturn(NivelUsuario.BASICO);
		this.nivelVerificacion.verificar(muestra, usuario, TipoMuestra.INDEFINIDO);
		//verifico que no cambia el nivel de la muestra si no es corresponde.
		verify(muestra, never()).setNivelDeVerificacion(any(NivelVerificacion.class));
		//verifico que llama a setear el nivel de la muestra en caso de que corresponda (ya hay 2 verif del mismo tipo).
		when(muestra.getCantVerificacionesDeTipo(any(TipoMuestra.class))).thenReturn(2);
		this.nivelVerificacion.verificar(muestra, usuario, TipoMuestra.INDEFINIDO);
		verify(muestra).setNivelDeVerificacion(any(NivelVerificacion.class));
	}
}
