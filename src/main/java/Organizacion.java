package main.java;

public class Organizacion {
	
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
	
}
