package main.java.filtros;

import java.util.Date;

import main.java.Muestra;

public class CriterioUltimaVerificacionMenor extends CriterioUltimaVerificacion {

	public CriterioUltimaVerificacionMenor(Date f) {
		super(f);
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getFechaUltimaVerificacion().before(this.fecha);
	}

}
