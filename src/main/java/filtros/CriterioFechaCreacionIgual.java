package main.java.filtros;

import java.util.Date;

import main.java.Muestra;

public class CriterioFechaCreacionIgual extends CriterioFechaCreacion {

	public CriterioFechaCreacionIgual(Date f) {
		super(f);
	}

	@Override
	public boolean verificar(Muestra m) {
		return m.getFechaCaptura() == this.fecha;
	}

}
