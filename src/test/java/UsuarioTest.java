package test.java;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.NivelUsuario;
import main.java.Usuario;
import main.java.Verificacion;

public class UsuarioTest {

	private Usuario usuario1;
	@Before
	public void setUp() {
		Verificacion verifMocked = mock(Verificacion.class);
		Muestra muestraMocked = mock(Muestra.class);
		when(verifMocked.getFecha()).thenReturn(new Date());
		when(muestraMocked.getFechaCaptura()).thenReturn(new Date());
		this.usuario1 = new Usuario("Usuno");
		this.usuario1.agregarVerificacion(verifMocked);
		this.usuario1.agregarMuestra(muestraMocked);
	}
	

	@Test
	public void testUsuario_getAlias() {
		assertEquals("Usuno", this.usuario1.getAlias());
	}
	@Test
	public void testUsuario_muestrasDelMes() {
		assertEquals(1, this.usuario1.muestrasDelMes());
	}
	@Test
	public void testUsio_verificacionesDelMes() {
		assertEquals(1, this.usuario1.verificacionesDelMes());
	}
	@Test
	public void testUsuario_getNivel() {
		assertEquals(NivelUsuario.BASICO, this.usuario1.getNivel());
	}
	@Test
	public void testUsuario_agregarVerificacion() {
		Verificacion newVerif = mock(Verificacion.class);
		when(newVerif.getFecha()).thenReturn(new Date());
		this.usuario1.agregarVerificacion(newVerif);
		assertEquals(2, this.usuario1.verificacionesDelMes());
	}
	@Test
	public void testUsuario_agregarMuestra() {
		Muestra newMuestra = mock(Muestra.class);
		when(newMuestra.getFechaCaptura()).thenReturn(new Date());
		this.usuario1.agregarMuestra(newMuestra);
		assertEquals(2, this.usuario1.muestrasDelMes());
	}
}
