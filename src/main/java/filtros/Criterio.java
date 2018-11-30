package main.java.filtros;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Muestra;

public abstract class Criterio implements Filtro {

	public abstract boolean verificar(Muestra m);

	public List<Muestra> filtrar(List<Muestra> ms) {
		return ms.stream().filter(m -> verificar(m)).collect(Collectors.toList());
	}
	
}