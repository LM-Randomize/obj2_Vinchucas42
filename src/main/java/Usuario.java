package main.java;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
	
	protected String alias;
	protected ArrayList<Verificacion> verificaciones;
	protected ArrayList<Muestra> muestrasPropias;

	public Usuario(String alias) {
		this.alias = alias;
		this.verificaciones = new ArrayList<Verificacion>();
		this.muestrasPropias = new ArrayList<Muestra>();
	}

	public String getAlias() {
		return this.alias;
	}
	
	//Calcula la diferencia en dias de las fechas que recibe.
	//Habria que pasarlo a ona clase aparte.
	public long diferenciaDias(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		return diffDays;
	}

	//Retorna la cantidad de Muestras que el usuario cardo en los ultimos 30 dias.
	public int muestrasDelMes() {
		int cant = 0;
		Date hoy = new Date();
		for (Muestra m : this.muestrasPropias) {
			if (diferenciaDias(m.getFechaCaptura(), hoy) <= 30) {
				cant++;
			}
		}
		return cant;
	}
	//Retorna la cantidad de Verificaciones que el usuario cardo en los ultimos 30 dias.
	public int verificacionesDelMes() {
		int cant = 0;
		Date hoy = new Date();
		for (Verificacion v : this.verificaciones) {
			if (diferenciaDias(v.getFecha(), hoy) <= 30) {
				cant++;
			}
		}
		return cant;
	}
	//Retorna el nivel del Usuario envaluando las Muestras y Verificaciones que cargo en los ultimos 30 dias.
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

	//Agrega una instancia de Verificacion realizaada por el usuario a la lista.
	public void agregarVerificacion(Verificacion ver) {
		this.verificaciones.add(ver);
	}

	//Agrega una instancia de Muestra cargada por el usuario a la lista.
	public void agregarMuestra(Muestra muestra) {
		this.muestrasPropias.add(muestra);
	}
}