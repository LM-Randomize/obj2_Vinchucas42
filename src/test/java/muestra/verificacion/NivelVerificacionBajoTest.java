package test.java.muestra.verificacion;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.muestra.verificacion.NivelVerificacion;
import main.java.muestra.verificacion.NivelVerificacionAlto;
import main.java.muestra.verificacion.NivelVerificacionBajo;
import main.java.muestra.verificacion.NivelVerificacionMedio;
import main.java.muestra.verificacion.NivelesVerificacion;
import main.java.usuario.NivelUsuario;
import main.java.usuario.Usuario;
import main.java.usuario.UsuarioEspecialista;

public class NivelVerificacionBajoTest {
	private NivelVerificacionBajo nivelVerificacion = new NivelVerificacionBajo();
	
	@Test
	public void testNivelVerificacionBajo_getNivel() {
		assertEquals(NivelesVerificacion.BAJO, this.nivelVerificacion.getNivel());
	}
	
	@Test
	public void testNivelVerificacionBajo_verificar() {
		Usuario usuario = mock(Usuario.class);
		Muestra muestra = mock(Muestra.class);
		UsuarioEspecialista usuarioEspecialista = new UsuarioEspecialista("Jorge");
		when(usuario.getNivel()).thenReturn(NivelUsuario.BASICO);
		this.nivelVerificacion.verificar(muestra, usuario, TipoMuestra.INDEFINIDO);
		//verifico que no cambia el nivel de la muestra si no es corresponde.
		verify(muestra, never()).setNivelDeVerificacion(any(NivelVerificacion.class));
		//verifico que llama a setear con nivelAlto el nivel de la muestra en caso de que corresponda (nivel usuario experto).
		this.nivelVerificacion.verificar(muestra, usuarioEspecialista, TipoMuestra.INDEFINIDO);
		verify(muestra).setNivelDeVerificacion(any(NivelVerificacionAlto.class));
		//verifico que llama a setear con nivelMedio el nivel de la muestra en caso de que corresponda (ya hay 1 verif del mismo tipo).
		when(muestra.getCantVerificacionesDeTipo(any(TipoMuestra.class))).thenReturn(1);
		this.nivelVerificacion.verificar(muestra, usuario, TipoMuestra.INDEFINIDO);
		verify(muestra).setNivelDeVerificacion(any(NivelVerificacionMedio.class));
	}
}
