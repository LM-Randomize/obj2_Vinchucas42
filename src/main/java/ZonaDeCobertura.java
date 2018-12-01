package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ZonaDeCobertura extends Observable implements Observer {

	private String nombre;
	private Ubicacion epicentro;
	private double radio;
	private List<Muestra> muestras;
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, double radio) {
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestras = new ArrayList<Muestra>();
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
	

	@Override
	public void update(Observable o, Object arg) {
		if(arg.equals("Verificacion")){
			this.notificar("VerificacionMuestra");
		}
	}

	private void notificar(String aspecto){
		this.setChanged();
		this.notifyObservers(aspecto);
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
			this.notificar("AltaMuestra");
		}
	}
}
