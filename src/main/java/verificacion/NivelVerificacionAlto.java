package main.java.verificacion;

import main.java.Muestra;
import main.java.TipoMuestra;
import main.java.Usuario;

public class NivelVerificacionAlto extends NivelVerificacion {

	@Override
	public NivelesVerificacion getNivel() {
		return NivelesVerificacion.ALTO;
	}
	
	@Override
	public void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		//throw new Exception("No toma mas Verificaciones.");
	}

}
