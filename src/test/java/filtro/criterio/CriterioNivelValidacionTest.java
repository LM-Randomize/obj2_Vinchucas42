package test.java.filtro.criterio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.filtro.criterio.CriterioNivelValidacionIgual;
import main.java.verificacion.NivelesVerificacion;

public class CriterioNivelValidacionTest {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private CriterioNivelValidacionIgual criterioNVIgual;
	
	@Before
	public void setUp() {
		Muestra mockedMuestra1 = mock(Muestra.class);
		Muestra mockedMuestra2 = mock(Muestra.class);
		Muestra mockedMuestra3 = mock(Muestra.class);
		Muestra mockedMuestra4 = mock(Muestra.class);
		Muestra mockedMuestra5 = mock(Muestra.class);
		when(mockedMuestra1.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.BAJO);
		when(mockedMuestra2.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.MEDIO);
		when(mockedMuestra3.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.MEDIO);
		when(mockedMuestra4.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.ALTO);
		when(mockedMuestra5.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.MEDIO);
		this.muestras.add(mockedMuestra1);
		this.muestras.add(mockedMuestra2);
		this.muestras.add(mockedMuestra3);
		this.muestras.add(mockedMuestra4);
		this.muestras.add(mockedMuestra5);

		this.criterioNVIgual = new CriterioNivelValidacionIgual(NivelesVerificacion.MEDIO);
	}


	@Test
	public void testCriterioNivelValidacionIgual_filtrar() {
		List<Muestra> lMuestras = this.criterioNVIgual.filtrar(this.muestras);
		assertEquals(3, lMuestras.size());
	}
}
