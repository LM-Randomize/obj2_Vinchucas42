package main.java.filtro.criterio;

import java.util.Date;

public abstract class CriterioFechaCreacion extends Criterio {

	protected Date fecha;
	
	public CriterioFechaCreacion(Date f) {
		this.fecha = f;
	}

}
