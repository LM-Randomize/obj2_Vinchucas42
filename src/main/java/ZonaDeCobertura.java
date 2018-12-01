package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import main.java.verificacion.Verificacion;

public class ZonaDeCobertura implements MuestraListener {

	private String nombre;
	private Ubicacion epicentro;
	private double radio;
	private List<Muestra> muestras;
	private List<ZonaDeCoberturaListener> listeners;
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, double radio) {
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestras = new ArrayList<>();
		this.listeners = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public Ubicacion getEpicentro() {
		return epicentro;
	}
	public double getRadio() {
		return radio;
	}
	public List<Muestra> getMuestras() {
		return muestras;
	}
	

	
	
	public void agregarListener(ZonaDeCoberturaListener l) {
		this.listeners.add(l);
	}
	public void removerListener(ZonaDeCoberturaListener l) {
		this.listeners.remove(l);
	}

	private void notificarMuestraCargada(Muestra m) {
		for (ZonaDeCoberturaListener listener : this.listeners) {
			listener.muestraCargada(this, m);
		}
	}
	private void notificarMuestraVerificada(Muestra m) {
		for (ZonaDeCoberturaListener listener : this.listeners) {
			listener.muestraVerificada(this, m);
		}
	}
	
	public boolean seSolapaCon(ZonaDeCobertura zona) {
		double distanciaEpicentros = this.epicentro.distanciaCon(zona.getEpicentro());
		double distanciaSolapamiento = this.radio + zona.getRadio();
		return distanciaEpicentros < distanciaSolapamiento;
	}
	public boolean perteneceUbicacion(Ubicacion u) {
		double distanciaConEpicentro = this.epicentro.distanciaCon(u);
		return distanciaConEpicentro < this.radio;
	}
	public void subscribirMuestraSiPertenece(Muestra muestra) {
		if (perteneceUbicacion(muestra.getUbicacion())) {
			this.muestras.add(muestra);
			this.notificarMuestraCargada(muestra);
		}
	}

	@Override
	public void muestraVerificada(Muestra m, Verificacion v) {
		this.notificarMuestraVerificada(m);
	}
}
