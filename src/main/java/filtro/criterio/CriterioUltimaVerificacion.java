package main.java.filtro.criterio;

import java.util.Date;

public abstract class CriterioUltimaVerificacion extends Criterio{

	protected Date fecha;
	
	public CriterioUltimaVerificacion(Date f) {
		this.fecha = f;
	}

}
