package main.java.filtros;

import java.util.ArrayList;
import java.util.List;

import main.java.Muestra;

public class OpLogicoBinariaAnd extends OpLogicoBinaria {

	OpLogicoBinariaAnd(Filtro f1, Filtro f2) {
		super(f1, f2);
		// TODO Auto-generated constructor stub
	}

	public List<Muestra> filtrar(List<Muestra> ms) {
		return intersection(this.getFiltro1().filtrar(ms), this.getFiltro2().filtrar(ms));
	}
	
	private <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
