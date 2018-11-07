package main.java;

import java.util.ArrayList;

public class Muestra {
	
	private String urlFoto;
	private Ubicacion ubicacion;
	private Usuario propietario;
	private INivelVerificacion nivelVerificacion;
	private ArrayList<Verificacion> verificaciones;
	private TipoMuestra tipoMuestra;
	
	public Muestra(String urlFoto, Ubicacion ubicacion, Usuario propietario, TipoMuestra tipoMuestra) {
		this.urlFoto = urlFoto;
		this.ubicacion = ubicacion;
		this.propietario = propietario;
		this.nivelVerificacion = new NivelVerificacionBajo();
		this.verificaciones = new ArrayList<Verificacion>();
		this.tipoMuestra = tipoMuestra;
	}
	
	public String getFoto() {
		return this.urlFoto;
	}
	
	// Retorna el alias de la persona que cargo la muestra
	public String getPropietario() {
		return this.propietario.getAlias();
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
	public void verificar(Usuario usuario, TipoMuestra tipoMuestra) {
		//DEFINIR
	}
	
	public String nivelDeVerificacion() {
		return this.nivelVerificacion.getNivel();
	}
	
	public TipoMuestra tipoDeMuestra() {
		return this.tipoMuestra;
	}
	
	
}
