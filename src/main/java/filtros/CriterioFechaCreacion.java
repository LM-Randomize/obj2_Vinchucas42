package main.java.filtros;

import java.util.Date;
import java.util.List;

import main.java.Muestra;

public abstract class CriterioFechaCreacion extends Criterio {

	protected Date fecha;
	
	public CriterioFechaCreacion(Date f) {
		this.fecha = f;
	}

}
