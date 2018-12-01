package test.java.filtro;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.Muestra;
import main.java.TipoMuestra;
import main.java.filtro.Filtro;
import main.java.filtro.criterio.CriterioNivelValidacionIgual;
import main.java.filtro.criterio.CriterioTipoMuestraIgual;
import main.java.filtro.criterio.CriterioUltimaVerificacionMayor;
import main.java.filtro.operacion.OpLogicoBinarioAnd;
import main.java.filtro.operacion.OpLogicoBinarioOr;
import main.java.verificacion.NivelesVerificacion;

public class FiltroTest {

	/* Fecha de la Ultima verificacion > '20/04/2019'
	 * */
	private Filtro filtro1;
	
	/* Nivel de validacion = alto ’ AND ​ Fecha de la utima verificacion > '20/04/2019'
	 * */
	private Filtro filtro2;
	
	/* Tipo de insecto detectado = 'Vinchuca' AND (Nivel de validacion = alto OR Fecha de la Ultima verificacion > '20/04/2019')
	 * */
	private Filtro filtro3;
	
	private List<Muestra> muestras = new ArrayList<Muestra>();
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		Muestra mockedMuestra1 = mock(Muestra.class);
		when(mockedMuestra1.getFechaCaptura()).thenReturn(new Date(2018,11,25));
		when(mockedMuestra1.getFechaUltimaVerificacion()).thenReturn(new Date(2018,11,25));
		when(mockedMuestra1.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.BAJO);
		when(mockedMuestra1.getTipoDeMuestra()).thenReturn(TipoMuestra.CHINCHEFOLIADA);
		Muestra mockedMuestra2 = mock(Muestra.class);
		when(mockedMuestra2.getFechaCaptura()).thenReturn(new Date(2018,11,26));
		when(mockedMuestra2.getFechaUltimaVerificacion()).thenReturn(new Date(2018,11,26));
		when(mockedMuestra2.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.MEDIO);
		when(mockedMuestra2.getTipoDeMuestra()).thenReturn(TipoMuestra.CHINCHEFOLIADA);
		Muestra mockedMuestra3 = mock(Muestra.class);
		when(mockedMuestra3.getFechaCaptura()).thenReturn(new Date(2019,11,27));
		when(mockedMuestra3.getFechaUltimaVerificacion()).thenReturn(new Date(2019,11,27));
		when(mockedMuestra3.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.MEDIO);
		when(mockedMuestra3.getTipoDeMuestra()).thenReturn(TipoMuestra.VINCHUCA);
		Muestra mockedMuestra4 = mock(Muestra.class);
		when(mockedMuestra4.getFechaCaptura()).thenReturn(new Date(2019,11,28));
		when(mockedMuestra4.getFechaUltimaVerificacion()).thenReturn(new Date(2019,11,28));
		when(mockedMuestra4.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.ALTO);
		when(mockedMuestra4.getTipoDeMuestra()).thenReturn(TipoMuestra.INDEFINIDO);
		Muestra mockedMuestra5 = mock(Muestra.class);
		when(mockedMuestra5.getFechaCaptura()).thenReturn(new Date(2019,11,29));
		when(mockedMuestra5.getFechaUltimaVerificacion()).thenReturn(new Date(2019,11,29));
		when(mockedMuestra5.getNivelDeVerificacion()).thenReturn(NivelesVerificacion.ALTO);
		when(mockedMuestra5.getTipoDeMuestra()).thenReturn(TipoMuestra.IMAGENPOCOCLARA);
		this.muestras.add(mockedMuestra1);
		this.muestras.add(mockedMuestra2);
		this.muestras.add(mockedMuestra3);
		this.muestras.add(mockedMuestra4);
		this.muestras.add(mockedMuestra5);
	}


	@SuppressWarnings("deprecation")
	@Test
	public void testFiltro1_filtrar() {
		// Fecha de la Ultima verificacion > '20/04/2019'
				this.filtro1 = new CriterioUltimaVerificacionMayor(new Date(2019,04,20));
		List<Muestra> lMuestras = this.filtro1.filtrar(this.muestras);
		assertEquals(3, lMuestras.size());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testFiltro2_filtrar() {
		// Nivel de validacion = alto AND Fecha de la Ultima verificacion > '20/04/2019'
		this.filtro2 = new OpLogicoBinarioAnd(
							new CriterioNivelValidacionIgual(NivelesVerificacion.ALTO)
							,new CriterioUltimaVerificacionMayor(new Date(2019,04,20))
						);
		List<Muestra> lMuestras = this.filtro2.filtrar(this.muestras);
		assertEquals(2, lMuestras.size());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testFiltro3_filtrar() {
		// Tipo de insecto detectado = 'Vinchuca' AND (Nivel de validacion = alto OR Fecha de la Ultima verificacion > 20/04/2019)
		this.filtro3 = new OpLogicoBinarioAnd(
							new CriterioTipoMuestraIgual(TipoMuestra.VINCHUCA)
							,new OpLogicoBinarioOr(
									new CriterioNivelValidacionIgual(NivelesVerificacion.ALTO)
									,new CriterioUltimaVerificacionMayor(new Date(2019,04,20))
							)
						);
		List<Muestra> lMuestras = this.filtro3.filtrar(this.muestras);
		assertEquals(1, lMuestras.size());
	}
}
