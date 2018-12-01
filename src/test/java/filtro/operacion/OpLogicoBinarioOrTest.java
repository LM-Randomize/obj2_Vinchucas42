package test.java.filtro.operacion;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import main.java.filtro.Filtro;
import main.java.filtro.operacion.OpLogicoBinarioOr;
import main.java.muestra.Muestra;

@SuppressWarnings("deprecation")
public class OpLogicoBinarioOrTest {

	private List<Muestra> muestras1 = new ArrayList<Muestra>();
	private List<Muestra> muestras2 = new ArrayList<Muestra>();
	private OpLogicoBinarioOr opOr;
	
	@Before
	public void setUp() {
		Muestra mockedMuestra1 = mock(Muestra.class);
		Muestra mockedMuestra2 = mock(Muestra.class);
		Muestra mockedMuestra3 = mock(Muestra.class);
		Muestra mockedMuestra4 = mock(Muestra.class);
		this.muestras1.add(mockedMuestra1);
		this.muestras1.add(mockedMuestra2);
		this.muestras1.add(mockedMuestra3);
		this.muestras2.add(mockedMuestra3);
		this.muestras2.add(mockedMuestra4);
		Filtro mockedFiltro1 = mock(Filtro.class);
		Filtro mockedFiltro2 = mock(Filtro.class);
		when(mockedFiltro1.filtrar(Matchers.any())).thenReturn(this.muestras1);
		when(mockedFiltro2.filtrar(Matchers.any())).thenReturn(this.muestras2);
		
		this.opOr = new OpLogicoBinarioOr(mockedFiltro1, mockedFiltro2);
	}
	

	@Test
	public void testOpLogicoBinarioOr_filtrar() {
		List<Muestra> lMuestras = this.opOr.filtrar(new ArrayList<Muestra>());
		assertEquals(4, lMuestras.size());
	}
}
