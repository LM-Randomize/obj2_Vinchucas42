package main.java.filtro.operacion;

import java.util.List;

import main.java.filtro.Filtro;
import main.java.muestra.Muestra;

public abstract class OpLogicoBinario implements Filtro {

	private Filtro filtro1;
	private Filtro filtro2;
	
	public OpLogicoBinario(Filtro f1, Filtro f2) {
		this.filtro1 = f1;
		this.filtro2 = f2;
	}

	public Filtro getFiltro1() {
		return filtro1;
	}

	public Filtro getFiltro2() {
		return filtro2;
	}
	
	public abstract List<Muestra> filtrar(List<Muestra> ms);
}
