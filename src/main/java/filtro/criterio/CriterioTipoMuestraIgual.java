package main.java.filtro.criterio;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Muestra;
import main.java.TipoMuestra;

public class CriterioTipoMuestraIgual extends Criterio {

	private TipoMuestra tipo;
	
	public CriterioTipoMuestraIgual(TipoMuestra t) {
		this.tipo = t;
	}
	
	@Override
	public boolean verificar(Muestra m) {
		return m.getTipoDeMuestra() == this.tipo;
	}

}
