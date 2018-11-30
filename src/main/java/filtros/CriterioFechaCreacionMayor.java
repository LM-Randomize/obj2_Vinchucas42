package main.java.filtros;

import java.util.Date;

import main.java.Muestra;

public class CriterioFechaCreacionMayor extends CriterioFechaCreacion {

	public CriterioFechaCreacionMayor(Date f) {
		super(f);
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getFechaCaptura().after(this.fecha);
	}

}

