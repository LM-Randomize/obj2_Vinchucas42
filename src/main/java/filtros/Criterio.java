package main.java.filtros;

import main.java.Muestra;

public interface Criterio extends Filtro {

	public boolean verificar(Muestra l);
	
}
