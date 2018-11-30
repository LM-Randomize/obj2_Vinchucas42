package main.java.filtro.criterio;

import java.util.Date;
import java.util.List;

import main.java.Muestra;

public abstract class CriterioFechaCreacion extends Criterio {

	protected Date fecha;
	
	public CriterioFechaCreacion(Date f) {
		this.fecha = f;
	}

}
