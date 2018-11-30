package main.java.filtro.criterio;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Muestra;
import main.java.TipoMuestra;
import main.java.verificacion.NivelVerificacion;
import main.java.verificacion.NivelesVerificacion;

public class CriterioNivelValidacionIgual extends Criterio {

	private NivelesVerificacion nivel;
	
	public CriterioNivelValidacionIgual(NivelesVerificacion n) {
		this.nivel = n;
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getNivelDeVerificacion() == this.nivel;
	}

}
