package main.java.filtro.criterio;

import java.util.Date;

import main.java.muestra.Muestra;

public class CriterioUltimaVerificacionMayor extends CriterioUltimaVerificacion {

	public CriterioUltimaVerificacionMayor(Date f) {
		super(f);
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getFechaUltimaVerificacion().compareTo(this.fecha) > 0;
	}

}
