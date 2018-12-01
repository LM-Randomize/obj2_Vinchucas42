package main.java.funcionalidad;

import main.java.muestra.Muestra;
import main.java.organizacion.Organizacion;
import main.java.organizacion.ZonaDeCobertura;

public interface IFuncionalidadExterna {
	
	public void nuevoEvento(Organizacion o, ZonaDeCobertura z, Muestra m);
	
}
