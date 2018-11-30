package main.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import main.java.verificacion.INivelVerificacion;
import main.java.verificacion.NivelVerificacionBajo;
import main.java.verificacion.NivelesVerificacion;
import main.java.verificacion.Verificacion;


public class Muestra {
	
	private String urlFoto;
	private Ubicacion ubicacion;
	private Usuario propietario;
	private INivelVerificacion nivelVerificacion;
	private List<Verificacion> verificaciones;
	private TipoMuestra tipoMuestra;
	private Date fechaCaptura;
	

	public Muestra(String urlFoto, Ubicacion ubicacion, Usuario propietario, TipoMuestra tipoMuestra) {
		this.urlFoto = urlFoto;
		this.ubicacion = ubicacion;
		this.propietario = propietario;
		this.nivelVerificacion = new NivelVerificacionBajo();
		this.verificaciones = new ArrayList<Verificacion>();
		this.tipoMuestra = tipoMuestra;
		this.fechaCaptura = new Date();
		
		Verificacion ver = new Verificacion(tipoMuestra,this,propietario);
		this.verificaciones.add(ver);
		propietario.agregarVerificacion(ver);
		
	}
	
	public String getFoto() {
		return this.urlFoto;
	}
	
	/* Retorna el alias de la persona que cargo la muestra
	 * */
	public String getPropietario() {
		return this.propietario.getAlias();
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
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
	}
	
	/**
	 * Delega al NivelVerificacion actual la logica de registro y evolucion del estado de los objetos involucrados.
	 * @param usuario
	 * @param tipoMuestra
	 * @throws UsuarioRepetidoException 
	 */
	public void verificar(Usuario usuario, TipoMuestra tipoMuestra) {
		if (!this.yaVerifico(usuario)) {
			this.nivelVerificacion.verificar(this, usuario, tipoMuestra);
		}
	}
	
	/* Retorna la cantidad de verificaciones del TipoMuestra indicado.
	 * */
	public int getCantVerificacionesDeTipo(TipoMuestra tipo) {
		return (int)this.verificaciones.stream()
				.filter(v -> v.getTipoMuestra() == tipo).count();
	}
	
	/* Retorna Si el usuario Ya Verifico la muestra.
	 * */
	private boolean yaVerifico(Usuario usu) {
		return this.verificaciones.stream()
		    	.anyMatch(v -> v.getUsuario() == usu);
	}
	
	public Date getFechaUltimaVerificacion() {
		return (Date)this.verificaciones.stream()
				.map(v -> v.getFecha())
				.max(Date::compareTo).get();
	}
}
