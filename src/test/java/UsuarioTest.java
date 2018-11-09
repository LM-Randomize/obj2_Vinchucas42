package test.java;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.NivelUsuario;
import main.java.TipoMuestra;
import main.java.Ubicacion;
import main.java.Usuario;
import main.java.Verificacion;

public class UsuarioTest {

	private Usuario usuario1;

	@Before
	public void setUp() {
		this.usuario1 = new Usuario("Usuno");
		this.usuario1.agregarVerificacion(new Verificacion(TipoMuestra.CHINCHEFOLIADA));
		this.usuario1.agregarMuestra(new Muestra("", new Ubicacion(1,1), this.usuario1, TipoMuestra.CHINCHEFOLIADA));
	}
	

	@Test
	public void testUsuario_getAlias() {
		assertEquals("Usuno", this.usuario1.getAlias());
	}

	@Test
	public void testUsuario_diferenciaDias() {
		assertEquals(0, this.usuario1.diferenciaDias(new Date(),new Date()));
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
}
