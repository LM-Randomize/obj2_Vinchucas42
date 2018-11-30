package test.java;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.NivelUsuario;
import main.java.UsuarioEspecialista;
import main.java.verificacion.Verificacion;

public class UsuarioEspecialistaTest {
	private UsuarioEspecialista usuario1;
	@Before
	public void setUp() {
		Verificacion verifMocked = mock(Verificacion.class);
		Muestra muestraMocked = mock(Muestra.class);
		when(verifMocked.getFecha()).thenReturn(new Date());
		when(muestraMocked.getFechaCaptura()).thenReturn(new Date());
		this.usuario1 = new UsuarioEspecialista("Usuno");
		this.usuario1.agregarVerificacion(verifMocked);
		this.usuario1.agregarMuestra(muestraMocked);
	}

	@Test
	public void testUsuario_getNivel() {
		assertEquals(NivelUsuario.EXPERTO, this.usuario1.getNivel());
	}
}
