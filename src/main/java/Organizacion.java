package main.java;

import java.util.Observable;
import java.util.Observer;

public class Organizacion implements Observer {
	
	private String nombre;
	private Ubicacion ubicacion;
	private TipoOrganizacion tipo;
	private int cantTrabajadores;
	
	public Organizacion(String nombre, Ubicacion ubicacion, TipoOrganizacion tipoOrg, int cantTrabajadores) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipoOrg;
		this.cantTrabajadores = cantTrabajadores;
	} 
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}
	
	public TipoOrganizacion getTipo() {
		return this.tipo;
	}
	
	public int getCantTrabajadores() {
		return this.cantTrabajadores;
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		String aspecto = (String) arg;
		if(arg.equals("AltaMuestra")){
			// ACCION
		}
		else if(arg.equals("VerificacionMuestra")){
			// ACCION
		}
		
	}
	
}
