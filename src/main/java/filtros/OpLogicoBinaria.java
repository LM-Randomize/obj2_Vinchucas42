package main.java.filtros;

import java.util.List;

import main.java.Muestra;

public abstract class OpLogicoBinaria implements Filtro {

	private Filtro filtro1;
	private Filtro filtro2;
	
	OpLogicoBinaria(Filtro f1, Filtro f2) {
		this.filtro1 = f1;
		this.filtro2 = f2;
	}

	public Filtro getFiltro1() {
		return filtro1;
	}

	public Filtro getFiltro2() {
		return filtro2;
	}

}
