package main.java.funcionalidad;

import main.java.muestra.Muestra;
import main.java.organizacion.Organizacion;
import main.java.organizacion.ZonaDeCobertura;

public class FENoHacerNada implements IFuncionalidadExterna {

	@Override
	public void nuevoEvento(Organizacion o, ZonaDeCobertura z, Muestra m) {
		// NO HACER NADA
	}

}
