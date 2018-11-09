package main.java;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SistemaWeb {
	
	private ArrayList<Muestra> muestras;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Organizacion> organizaciones;

	public SistemaWeb() {
		this.muestras = new ArrayList<Muestra>();
		this.usuarios = new ArrayList<Usuario>();
		this.organizaciones = new ArrayList<Organizacion>();
	}
	
	public ArrayList<Muestra> getMuestras() {
		return muestras;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public ArrayList<Organizacion> getOrganizaciones() {
		return organizaciones;
	}

	//Retorna y almacena una nueva instancia de Muestra
	public Muestra registrarMuestra(String foto, Ubicacion ubicacion, Usuario usuario, TipoMuestra tipoMuestra) {
		Muestra muestra = new Muestra(foto,ubicacion,usuario,tipoMuestra);
		this.muestras.add(muestra);
		return muestra;
	}
	
	//Retorna y almacena una nueva instancia de Usuario
	public Usuario registrarUsuario(String alias) {
		Usuario usuario = new Usuario(alias);
		this.usuarios.add(new Usuario(alias));
		return usuario;
	}
	
	//Retorna y almacena una nueva instancia de Organizacion
	public Organizacion registrarOrganizacion(String nombre, Ubicacion ubicacion, TipoOrganizacion tipoOrg, int cantTrabajadores) {
		Organizacion org = new Organizacion(nombre, ubicacion, tipoOrg, cantTrabajadores);
		this.organizaciones.add(org);
		return org;
	}
	
	//Valida la muestra indicado por el usuario recibido
	public void validarMuestra(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		muestra.verificar(usuario, tipo);
	}
	
	//Retorna las muestras capturadas a menos de x Kms
	public ArrayList<Muestra> muestrasCercanas(Muestra muestra, double dist) {
		Ubicacion ubicacion1 = muestra.getUbicacion();
		return (ArrayList<Muestra>)this.muestras.stream()
				.filter(m -> ubicacion1.distanciaCon(m.getUbicacion()) <= dist)
				.collect(Collectors.toList());
	}
	
}
