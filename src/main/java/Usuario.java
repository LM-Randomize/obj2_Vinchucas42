package main.java;

import java.util.ArrayList;

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
	
	public NivelUsuario getNivel() {
		return NivelUsuario.BASICO;
	}
	
}
