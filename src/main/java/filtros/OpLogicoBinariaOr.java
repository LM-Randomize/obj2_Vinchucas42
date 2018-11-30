package main.java.filtros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.Muestra;

public class OpLogicoBinariaOr extends OpLogicoBinaria {

	OpLogicoBinariaOr(Filtro f1, Filtro f2) {
		super(f1, f2);
		// TODO Auto-generated constructor stub
	}

	public List<Muestra> filtrar(List<Muestra> ms) {
		return union(this.getFiltro1().filtrar(ms), this.getFiltro2().filtrar(ms));
	}
	
	public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }
}
