package main.java;

import java.util.ArrayList;
import java.util.Date;

public class Muestra {
	
	private String urlFoto;
	private Ubicacion ubicacion;
	private Usuario propietario;
	private NivelVerificacion nivelVerificacion;
	private ArrayList<Verificacion> verificaciones;
	private TipoMuestra tipoMuestra;
	private Date fechaCaptura;
	
	public Muestra(String urlFoto, Ubicacion ubicacion, Usuario propietario, TipoMuestra tipoMuestra) {
		this.urlFoto = urlFoto;
		this.ubicacion = ubicacion;
		this.propietario = propietario;
		this.nivelVerificacion = new NivelVerificacionBajo();
		this.verificaciones = new ArrayList<Verificacion>();
		this.tipoMuestra = tipoMuestra;
		propietario.agregarMuestra(this);
		this.fechaCaptura = new Date();
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
	
	public String getNivelDeVerificacion() {
		return this.nivelVerificacion.getNivel();
	}
	public void setNivelDeVerificacion(NivelVerificacion nivel) {
		this.nivelVerificacion = nivel;
	}

	public TipoMuestra getTipoDeMuestra() {
		return this.tipoMuestra;
	}
	public void setTipoDeMuestra(TipoMuestra tipo) {
		this.tipoMuestra = tipo;
	}
	
	public Date getFechaCaptura() {
		return fechaCaptura;
	}

	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public void agragarVerificacion(Verificacion ver) {
		this.verificaciones.add(ver);
	}
	
	//Delega al NivelVerificacion actual la logica de registro y evolucion del estado de los objetos involucrados.
	public void verificar(Usuario usuario, TipoMuestra tipoMuestra) {
		if (!this.yaVerifico(usuario)) {
			this.nivelVerificacion.verificar(this, usuario, tipoMuestra);
		}
	}
	
	//Retorna la cantidad de verificaciones del TipoMuestra indicado.
	public int getCantVerificacionesDeTipo(TipoMuestra tipo) {
		int cant = 0;
		for (Verificacion v : this.verificaciones) {
			if (v.getTipoMuestra() == tipo) {
				cant++;
			} 
		}
		return cant;
	}
	
	//Retorna Si el usuario Ya Verifico la muestra.
	private boolean yaVerifico(Usuario usu) {
		return this.verificaciones.stream()
		    	.anyMatch(v -> v.getUsuario() == usu);
	}
	
}
