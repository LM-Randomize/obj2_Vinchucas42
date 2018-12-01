package test.java.filtro.criterio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.filtro.criterio.CriterioUltimaVerificacionIgual;
import main.java.filtro.criterio.CriterioUltimaVerificacionMayor;
import main.java.filtro.criterio.CriterioUltimaVerificacionMenor;
import main.java.muestra.Muestra;

public class CriterioUltimaVerificacionTest {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private CriterioUltimaVerificacionIgual criterioUVIgual;
	private CriterioUltimaVerificacionMayor criterioUVMayor;
	private CriterioUltimaVerificacionMenor criterioUVMenor;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		Muestra mockedMuestra1 = mock(Muestra.class);
		Muestra mockedMuestra2 = mock(Muestra.class);
		Muestra mockedMuestra3 = mock(Muestra.class);
		Muestra mockedMuestra4 = mock(Muestra.class);
		Muestra mockedMuestra5 = mock(Muestra.class);
		when(mockedMuestra1.getFechaUltimaVerificacion()).thenReturn(new Date(2018,11,25));
		when(mockedMuestra2.getFechaUltimaVerificacion()).thenReturn(new Date(2018,11,26));
		when(mockedMuestra3.getFechaUltimaVerificacion()).thenReturn(new Date(2018,11,27));
		when(mockedMuestra4.getFechaUltimaVerificacion()).thenReturn(new Date(2018,11,28));
		when(mockedMuestra5.getFechaUltimaVerificacion()).thenReturn(new Date(2018,11,29));
		this.muestras.add(mockedMuestra1);
		this.muestras.add(mockedMuestra2);
		this.muestras.add(mockedMuestra3);
		this.muestras.add(mockedMuestra4);
		this.muestras.add(mockedMuestra5);

		this.criterioUVIgual = new CriterioUltimaVerificacionIgual(new Date(2018,11,27));
		this.criterioUVMayor = new CriterioUltimaVerificacionMayor(new Date(2018,11,26));
		this.criterioUVMenor = new CriterioUltimaVerificacionMenor(new Date(2018,11,27));
	}


	@Test
	public void testCriterioUltimaVerificacionIgual_filtrar() {
		List<Muestra> lMuestras = this.criterioUVIgual.filtrar(this.muestras);
		assertEquals(1, lMuestras.size());
	}

	@Test
	public void testCriterioUltimaVerificacionMayor_filtrar() {
		List<Muestra> lMuestras = this.criterioUVMayor.filtrar(this.muestras);
		assertEquals(3, lMuestras.size());
	}

	@Test
	public void testCriterioUltimaVerificacionMenor_filtrar() {
		List<Muestra> lMuestras = this.criterioUVMenor.filtrar(this.muestras);
		assertEquals(2, lMuestras.size());
	}
}
