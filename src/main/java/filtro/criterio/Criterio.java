package main.java.filtro.criterio;

import java.util.List;
import java.util.stream.Collectors;

import main.java.filtro.Filtro;
import main.java.muestra.Muestra;

public abstract class Criterio implements Filtro {

	/** 
	 * Verifica que una muestra cumpla con un criterio de filtrado.
	 * @param m:Muestra muestra a verificar si cumple con el criterio
	 * @return boolean retorna si cumple o no con el criterio
	 */
	public abstract boolean verificar(Muestra m);
	
	/** 
	 * filtra una lista de muestras por el criterio elegido
	 * @param ms:List<Muestra> lista de muestras a filtrar
	 * @return List<Muestra> lista filtrada de muestras.
	 */
	public List<Muestra> filtrar(List<Muestra> ms) {
		return ms.stream().filter(m -> verificar(m)).collect(Collectors.toList());
	}
	
}
