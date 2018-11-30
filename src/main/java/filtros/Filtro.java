package main.java.filtros;

import java.util.List;

import main.java.Muestra;

public interface Filtro {

	public List<Muestra> filtrar(List<Muestra> ms);
}
