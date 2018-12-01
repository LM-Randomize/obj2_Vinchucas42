package main.java.muestra.verificacion;

import java.util.Date;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.usuario.Usuario;

public class Verificacion {

	private Date fecha;
	private TipoMuestra tipoMuestra;
	private Muestra muestra;
	private Usuario usuario;
	
	public Verificacion(TipoMuestra tipoMuestra,Muestra muestra, Usuario usuario) {
		this.fecha = new Date();
		this.tipoMuestra = tipoMuestra;
		this.muestra = muestra;
		this.usuario = usuario;
	}
	

	public Muestra getMuestra() {
		return muestra;
	}


	public Usuario getUsuario() {
		return usuario;
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
