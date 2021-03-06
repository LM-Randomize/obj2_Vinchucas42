package main.java.filtro.criterio;

import java.util.Date;

import main.java.muestra.Muestra;

public class CriterioUltimaVerificacionIgual extends CriterioUltimaVerificacion {

	public CriterioUltimaVerificacionIgual(Date f) {
		super(f);
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getFechaUltimaVerificacion().compareTo(this.fecha) == 0;
	}

}
