package main.java.filtros;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Muestra;
import main.java.NivelVerificacion;
import main.java.TipoMuestra;

public class CriterioNivelValidacionIgual extends Criterio {

	private NivelVerificacion nivel;
	
	public CriterioNivelValidacionIgual(NivelVerificacion n) {
		this.nivel = n;
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getNivelDeVerificacion() == this.nivel.toString();
	}

}
