package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import main.java.funcionalidades.IFuncionalidadExterna;
import main.java.funcionalidades.FENoHacerNada;

public class Organizacion implements ZonaDeCoberturaListener {
	
	private String nombre;
	private Ubicacion ubicacion;
	private TipoOrganizacion tipo;
	private int cantTrabajadores;
	/* AGREGADO */
	private List<ZonaDeCobertura> zonasDeCobertura;
	private IFuncionalidadExterna funcionAltaMuestra;
	private IFuncionalidadExterna funcionValidacionMuestra;
	
	
	public Organizacion(String nombre, Ubicacion ubicacion, TipoOrganizacion tipoOrg, int cantTrabajadores
			, List<ZonaDeCobertura> zonasDeCobertura, IFuncionalidadExterna funcionAltaMuestra, IFuncionalidadExterna funcionValidacionMuestra) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.tipo = tipoOrg;
		this.cantTrabajadores = cantTrabajadores;
		
		this.zonasDeCobertura = zonasDeCobertura;
		this.funcionAltaMuestra = funcionAltaMuestra;
		this.funcionValidacionMuestra = funcionValidacionMuestra;
	}
	public Organizacion(String nombre, Ubicacion ubicacion, TipoOrganizacion tipoOrg, int cantTrabajadores) {
		this(nombre, ubicacion, tipoOrg, cantTrabajadores, new ArrayList<ZonaDeCobertura>(), new FENoHacerNada(), new FENoHacerNada());
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
	

	public IFuncionalidadExterna getFuncionAltaMuestra() {
		return funcionAltaMuestra;
	}
	public void setFuncionAltaMuestra(IFuncionalidadExterna funcionAltaMuestra) {
		this.funcionAltaMuestra = funcionAltaMuestra;
	}
	public IFuncionalidadExterna getFuncionValidacionMuestra() {
		return funcionValidacionMuestra;
	}
	public void setFuncionValidacionMuestra(IFuncionalidadExterna funcionValidacionMuestra) {
		this.funcionValidacionMuestra = funcionValidacionMuestra;
	}
	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}
	public void agregarZonaDeCobertura(ZonaDeCobertura z) {
		this.zonasDeCobertura.add(z);
		z.agregarListener(this);
	}
	public void removerZonaDeCobertura(ZonaDeCobertura z) {
		this.zonasDeCobertura.remove(z);
		z.removerListener(this);
	}
	
	

	@Override
	public void muestraCargada(ZonaDeCobertura z, Muestra m) {
		this.funcionAltaMuestra.nuevoEvento(this, z, m);
		
	}
	@Override
	public void muestraVerificada(ZonaDeCobertura z, Muestra m) {
		this.funcionValidacionMuestra.nuevoEvento(this, z, m);
	}
	
}
