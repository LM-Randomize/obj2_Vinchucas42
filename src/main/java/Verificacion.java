package main.java;

import java.util.Date;

public class Verificacion {

	private Date fecha;
	private TipoMuestra tipoMuestra;
	
	public Verificacion(TipoMuestra tipoMuestra) {
		this.fecha = new Date();
		this.tipoMuestra = tipoMuestra;
	}
	
}
