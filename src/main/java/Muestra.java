package main.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import main.java.verificacion.INivelVerificacion;
import main.java.verificacion.NivelVerificacionBajo;
import main.java.verificacion.NivelesVerificacion;
import main.java.verificacion.Verificacion;


public class Muestra extends Observable {
	
	private String urlFoto;
	private Ubicacion ubicacion;
	private Usuario propietario;
	private INivelVerificacion nivelVerificacion;
	private List<Verificacion> verificaciones;
	private TipoMuestra tipoMuestra;
	private Date fechaCaptura;
	private List<MuestraListener> listeners;
	

	public Muestra(String urlFoto, Ubicacion ubicacion, Usuario propietario, TipoMuestra tipoMuestra) {
		this.urlFoto = urlFoto;
		this.ubicacion = ubicacion;
		this.propietario = propietario;
		this.nivelVerificacion = new NivelVerificacionBajo();
		this.verificaciones = new ArrayList<Verificacion>();
		this.tipoMuestra = tipoMuestra;
		this.fechaCaptura = new Date();
		this.listeners = new ArrayList<>();
		
		Verificacion ver = new Verificacion(tipoMuestra,this,propietario);
		this.agragarVerificacion(ver);
		propietario.agregarVerificacion(ver);
		
	}
	
	public String getFoto() {
		return this.urlFoto;
	}
	
	/**
	 * Retorna el alias de la persona que cargo la muestra
	 * @return String
	 */
	public String getPropietario() {
		return this.propietario.getAlias();
	}
	
	/**
	 * Retorna la ubicacion donde fue encontrada la muestra
	 * @return Ubicacion
	 */
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	/**
	 * Retorna el nivel de verificaci�n actual de la muestra
	 * @return NivelesVerificacion
	 */
	public NivelesVerificacion getNivelDeVerificacion() {
		return this.nivelVerificacion.getNivel();
	}
	public void setNivelDeVerificacion(INivelVerificacion nivel) {
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

	public List<Verificacion> getVerificaciones() {
		return verificaciones;
	}
	
	public void agragarVerificacion(Verificacion ver) {
		this.verificaciones.add(ver);
		this.notificarMuestraVerificada(ver);
	}
	
	/**
	 * Delega al NivelVerificacion actual la logica de registro y evolucion del estado de los objetos involucrados.
	 * @param usuario:Usuario
	 * @param tipoMuestra:TipoMuestra
	 */
	public void verificar(Usuario usuario, TipoMuestra tipoMuestra) {
		if (!this.yaVerifico(usuario)) {
			this.nivelVerificacion.verificar(this, usuario, tipoMuestra);
		}
	}
	
	/**
	 * Retorna la cantidad de verificaciones del TipoMuestra indicado.
	 * @param tipo:TipoMuestra
	 * @return int
	 */
	public int getCantVerificacionesDeTipo(TipoMuestra tipo) {
		return (int)this.verificaciones.stream()
				.filter(v -> v.getTipoMuestra() == tipo).count();
	}
	
	/**
	 * Retorna Si el usuario Ya Verifico la muestra.
	 * @param usu:Usuario Usuario el cual queremos saber si verifico la muestra
	 * @return boolean
	 */
	private boolean yaVerifico(Usuario usu) {
		return this.verificaciones.stream()
		    	.anyMatch(v -> v.getUsuario() == usu);
	}
	
	public Date getFechaUltimaVerificacion() {
		return (Date)this.verificaciones.stream()
				.map(v -> v.getFecha())
				.max(Date::compareTo).get();
	}
	
	

	
	public void agregarListener(MuestraListener l) {
		this.listeners.add(l);
	}
	public void removerListener(MuestraListener l) {
		this.listeners.remove(l);
	}

	private void notificarMuestraVerificada(Verificacion v) {
		for (MuestraListener listener : this.listeners) {
			listener.muestraVerificada(this, v);
		}
	}
}
