package main.java.filtros;

import java.util.Date;

import main.java.Muestra;

public class CriterioUltimaVerificacionIgual extends CriterioUltimaVerificacion {

	public CriterioUltimaVerificacionIgual(Date f) {
		super(f);
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getFechaUltimaVerificacion() == this.fecha;
	}

}
