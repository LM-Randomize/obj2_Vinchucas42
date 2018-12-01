package main.java.filtro.criterio;

import java.util.Date;

import main.java.muestra.Muestra;

public class CriterioFechaCreacionMayor extends CriterioFechaCreacion {

	public CriterioFechaCreacionMayor(Date f) {
		super(f);
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getFechaCaptura().compareTo(this.fecha) > 0;
	}

}

