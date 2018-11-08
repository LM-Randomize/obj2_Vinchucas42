package main.java;

import java.util.Date;

public class Verificacion {

	private Date fecha;
	private TipoMuestra tipoMuestra;
	
	public Verificacion(TipoMuestra tipoMuestra) {
		this.fecha = new Date();
		this.tipoMuestra = tipoMuestra;
	}
	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TipoMuestra getTipoMuestra() {
		return tipoMuestra;
	}

	public void setTipoMuestra(TipoMuestra tipoMuestra) {
		this.tipoMuestra = tipoMuestra;
	}
	
}
