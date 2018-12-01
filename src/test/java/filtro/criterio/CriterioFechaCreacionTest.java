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
import main.java.filtro.criterio.CriterioFechaCreacionIgual;
import main.java.filtro.criterio.CriterioFechaCreacionMayor;
import main.java.filtro.criterio.CriterioFechaCreacionMenor;

public class CriterioFechaCreacionTest {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private CriterioFechaCreacionIgual criterioFCIgual;
	private CriterioFechaCreacionMayor criterioFCMayor;
	private CriterioFechaCreacionMenor criterioFCMenor;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		Muestra mockedMuestra1 = mock(Muestra.class);
		Muestra mockedMuestra2 = mock(Muestra.class);
		Muestra mockedMuestra3 = mock(Muestra.class);
		Muestra mockedMuestra4 = mock(Muestra.class);
		Muestra mockedMuestra5 = mock(Muestra.class);
		when(mockedMuestra1.getFechaCaptura()).thenReturn(new Date(2018,11,25));
		when(mockedMuestra2.getFechaCaptura()).thenReturn(new Date(2018,11,26));
		when(mockedMuestra3.getFechaCaptura()).thenReturn(new Date(2018,11,27));
		when(mockedMuestra4.getFechaCaptura()).thenReturn(new Date(2018,11,28));
		when(mockedMuestra5.getFechaCaptura()).thenReturn(new Date(2018,11,29));
		this.muestras.add(mockedMuestra1);
		this.muestras.add(mockedMuestra2);
		this.muestras.add(mockedMuestra3);
		this.muestras.add(mockedMuestra4);
		this.muestras.add(mockedMuestra5);

		this.criterioFCIgual = new CriterioFechaCreacionIgual(new Date(2018,11,27));
		this.criterioFCMayor = new CriterioFechaCreacionMayor(new Date(2018,11,26));
		this.criterioFCMenor = new CriterioFechaCreacionMenor(new Date(2018,11,27));
	}


	@Test
	public void testCriterioFechaCreacionIgual_filtrar() {
		List<Muestra> lMuestras = this.criterioFCIgual.filtrar(this.muestras);
		assertEquals(1, lMuestras.size());
	}

	@Test
	public void testCriterioFechaCreacionMayor_filtrar() {
		List<Muestra> lMuestras = this.criterioFCMayor.filtrar(this.muestras);
		assertEquals(3, lMuestras.size());
	}

	@Test
	public void testCriterioFechaCreacionMenor_filtrar() {
		List<Muestra> lMuestras = this.criterioFCMenor.filtrar(this.muestras);
		assertEquals(2, lMuestras.size());
	}
}
