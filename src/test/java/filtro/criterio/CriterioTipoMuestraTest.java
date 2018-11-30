package test.java.filtro.criterio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.TipoMuestra;
import main.java.filtro.criterio.CriterioTipoMuestraIgual;
import main.java.verificacion.NivelesVerificacion;

public class CriterioTipoMuestraTest {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private CriterioTipoMuestraIgual criterioTMIgual;
	
	@Before
	public void setUp() {
		Muestra mockedMuestra1 = mock(Muestra.class);
		Muestra mockedMuestra2 = mock(Muestra.class);
		Muestra mockedMuestra3 = mock(Muestra.class);
		Muestra mockedMuestra4 = mock(Muestra.class);
		Muestra mockedMuestra5 = mock(Muestra.class);
		when(mockedMuestra1.getTipoDeMuestra()).thenReturn(TipoMuestra.CHINCHEFOLIADA);
		when(mockedMuestra2.getTipoDeMuestra()).thenReturn(TipoMuestra.CHINCHEFOLIADA);
		when(mockedMuestra3.getTipoDeMuestra()).thenReturn(TipoMuestra.VINCHUCA);
		when(mockedMuestra4.getTipoDeMuestra()).thenReturn(TipoMuestra.INDEFINIDO);
		when(mockedMuestra5.getTipoDeMuestra()).thenReturn(TipoMuestra.IMAGENPOCOCLARA);
		this.muestras.add(mockedMuestra1);
		this.muestras.add(mockedMuestra2);
		this.muestras.add(mockedMuestra3);
		this.muestras.add(mockedMuestra4);
		this.muestras.add(mockedMuestra5);

		this.criterioTMIgual = new CriterioTipoMuestraIgual(TipoMuestra.VINCHUCA);
	}


	@Test
	public void testCriterioTipoMuestraIgual_filtrar() {
		List<Muestra> lMuestras = this.criterioTMIgual.filtrar(this.muestras);
		assertEquals(1, lMuestras.size());
	}
}
