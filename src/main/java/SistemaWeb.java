package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.filtro.Filtro;
import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.organizacion.Organizacion;
import main.java.organizacion.TipoOrganizacion;
import main.java.usuario.Usuario;

public class SistemaWeb {
	
	private List<Muestra> muestras;
	private List<Usuario> usuarios;
	private List<Organizacion> organizaciones;

	public SistemaWeb() {
		this.muestras = new ArrayList<Muestra>();
		this.usuarios = new ArrayList<Usuario>();
		this.organizaciones = new ArrayList<Organizacion>();
	}
	
	/* Setter creado unicamente para testear con mayor facilidad
	 */
	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public List<Organizacion> getOrganizaciones() {
		return organizaciones;
	}

	/** 
	 * Retorna y almacena una nueva instancia de Muestra
	 * @param foto: String URL de la foto de la muestra.
	 * @param ubicacion: Ubicacion Ubicacion donde fue tomada la muestra
	 * @param usuario: Usuario Usuario que toma la muestra
	 * @param tipoMuestra: TipoMuestra Tipo de muestra segun el usuario que la envia.
	 * @return Muestra muestra que se cargo.
	 * */
	public Muestra registrarMuestra(String foto, Ubicacion ubicacion, Usuario usuario, TipoMuestra tipoMuestra) {
		Muestra muestra = new Muestra(foto,ubicacion,usuario,tipoMuestra);
		this.muestras.add(muestra);
		return muestra;
	}
	
	/** 
	 * Retorna y almacena una nueva instancia de Usuario
	 * @param alias:String nombre del nuevo usuario
	 * @return Usuario usuario creado.
	 * */
	public Usuario registrarUsuario(String alias) {
		Usuario usuario = new Usuario(alias);
		this.usuarios.add(new Usuario(alias));
		return usuario;
	}
	
	/** 
	 * Retorna y almacena una nueva instancia de Organizacion
	 * @param nombre:String nombre de la organizacion
	 * @param ubicacion:Ubicacion ubicacion donde se encuentra la organizacion
	 * @param tipoOrg:TipoOrganizacion tipo de la organizacion
	 * @param cantTrabajadores:int cantidad de trabajadores que pertenecen a la organizacion
	 * @return Organizacion organizacion creada.
	 * */
	public Organizacion registrarOrganizacion(String nombre, Ubicacion ubicacion, TipoOrganizacion tipoOrg, int cantTrabajadores) {
		Organizacion org = new Organizacion(nombre, ubicacion, tipoOrg, cantTrabajadores);
		this.organizaciones.add(org);
		return org;
	}
	
	/** 
	 * Valida la muestra indicado por el usuario recibido
	 * @param muestra:Muestra muestra a validar
	 * @param usuario:Usuario usuario que valida la muestra
	 * @param tipo:TipoMuestra tipo de muestra que el usuario quiere validar
	 * */
	public void validarMuestra(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		muestra.verificar(usuario, tipo);
	}
	
	/** Retorna las muestras capturadas a menos de x Kms
	 * @param muestra:Muestra muestra desde la cual se quiere obtener muestras cercanas
	 * @param dist:double distancia alrededor de la muestra
	 * @return List<Muestra> lista de las muestras cercanas
	 * */
	public List<Muestra> muestrasCercanas(Muestra muestra, double dist) {
		Ubicacion ubicacion1 = muestra.getUbicacion();
		return (ArrayList<Muestra>)this.muestras.stream()
				.filter(m -> ubicacion1.distanciaCon(m.getUbicacion()) <= dist)
				.collect(Collectors.toList());
	}
	/**
	 * Filtra las muestras por el filtro pasado, retornando las muestras que cumplen con los criterios.
	 * @param filtro: Filtro filtro por el cual se quieren conocer las muestras
	 * @return List<Muestra> lista de muestras filtradas
	 */
	public List<Muestra> filtrarMuestras(Filtro filtro) {
		return filtro.filtrar(this.muestras);
	}
}
