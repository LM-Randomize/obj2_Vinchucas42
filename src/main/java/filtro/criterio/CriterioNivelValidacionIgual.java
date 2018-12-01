package main.java.filtro.criterio;

import main.java.Muestra;
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
