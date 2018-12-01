package main.java.muestra.verificacion;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.usuario.Usuario;

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
