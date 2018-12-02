package main.java.filtro.operacion;

import java.util.List;

import main.java.UTILS;
import main.java.filtro.Filtro;
import main.java.muestra.Muestra;

public class OpLogicoBinarioAnd extends OpLogicoBinario {

	public OpLogicoBinarioAnd(Filtro f1, Filtro f2) {
		super(f1, f2);
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> ms) {
		return UTILS.intersection(this.getFiltro1().filtrar(ms), this.getFiltro2().filtrar(ms));
	}
}
