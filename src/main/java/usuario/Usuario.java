package main.java.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.UTILS;
import main.java.muestra.Muestra;
import main.java.muestra.verificacion.Verificacion;

public class Usuario {
	
	protected String alias;
	protected List<Verificacion> verificaciones;
	protected List<Muestra> muestrasPropias;

	public Usuario(String alias) {
		this.alias = alias;
		this.verificaciones = new ArrayList<Verificacion>();
		this.muestrasPropias = new ArrayList<Muestra>();
	}

	public String getAlias() {
		return this.alias;
	}

	/**
	 * Retorna la cantidad de Muestras que el usuario cargo en los ultimos 30 dias.
	 * @return int Cantidad de muestras cargadas por el usuario en los ultimos 30 dias
	 */
	public int muestrasDelMes() {
		int cant = 0;
		Date hoy = new Date();
		for (Muestra m : this.muestrasPropias) {
			if (UTILS.diferenciaDias(m.getFechaCaptura(), hoy) <= 30) {
				cant++;
			}
		}
		return cant;
	}
	/**
	 * Retorna la cantidad de Verificaciones que el usuario cargo en los ultimos 30 dias.
	 * @return int Cantidad de Verificaciones cargadas por el usuario en los ultimos 30 dias
	 */
	public int verificacionesDelMes() {
		int cant = 0;
		Date hoy = new Date();
		for (Verificacion v : this.verificaciones) {
			if (UTILS.diferenciaDias(v.getFecha(), hoy) <= 30) {
				cant++;
			}
		}
		return cant;
	}
	/* Retorna el nivel del Usuario envaluando las Muestras y Verificaciones que cargo en los ultimos 30 dias.
	 * */
	public NivelUsuario getNivel() {
		NivelUsuario nivel;
		if (this.muestrasDelMes() >= 10 && this.verificacionesDelMes() >= 20) {
			nivel = NivelUsuario.EXPERTO;
		}
		else {
			nivel = NivelUsuario.BASICO;
		}
		return nivel;
	}

	/* Agrega una instancia de Verificacion realizaada por el usuario a la lista.
	 * */
	public void agregarVerificacion(Verificacion ver) {
		this.verificaciones.add(ver);
	}

	/* Agrega una instancia de Muestra cargada por el usuario a la lista.
	 * */
	public void agregarMuestra(Muestra muestra) {
		this.muestrasPropias.add(muestra);
	}
}
