package main.java;

public class Organizacion {
	
	private Ubicacion ubicacion;
	private TipoOrganizacion tipo;
	private int cantTrabajadores;
	
	public Organizacion(Ubicacion ubicacion, TipoOrganizacion tipoOrg, int cantTrabajadores) {
		this.ubicacion = ubicacion;
		this.tipo = tipoOrg;
		this.cantTrabajadores = cantTrabajadores;
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
	
}
