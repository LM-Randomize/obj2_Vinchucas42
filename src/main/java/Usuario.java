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
	
	private long diferenciaDias(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		return diffDays;
	}

	private int muestrasDelMes() {
		int cant = 0;
		Date hoy = new Date();
		for (Muestra m : this.muestrasPropias) {
			if (diferenciaDias(m.getFechaCaptura(), hoy) >= 30) {
				cant++;
			}
		}
		return cant;
	}
	private int verificacionesDelMes() {
		int cant = 0;
		Date hoy = new Date();
		for (Verificacion v : this.verificaciones) {
			if (diferenciaDias(v.getFecha(), hoy) >= 30) {
				cant++;
			}
		}
		return cant;
	}
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

	public void agregarVerificacion(Verificacion ver) {
		this.verificaciones.add(ver);
	}
	
	public void agregarMuestra(Muestra muestra) {
		this.muestrasPropias.add(muestra);
	}
}
