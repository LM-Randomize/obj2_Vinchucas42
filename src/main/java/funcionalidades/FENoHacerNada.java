package main.java.funcionalidades;

import main.java.Muestra;
import main.java.Organizacion;
import main.java.ZonaDeCobertura;

public class FENoHacerNada implements IFuncionalidadExterna {

	@Override
	public void nuevoEvento(Organizacion o, ZonaDeCobertura z, Muestra m) {
		// NO HACER NADA
	}

}
