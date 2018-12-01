package main.java.muestra.verificacion;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.usuario.NivelUsuario;
import main.java.usuario.Usuario;

public class NivelVerificacionMedio extends NivelVerificacion {

	@Override
	public NivelesVerificacion getNivel() {
		return NivelesVerificacion.MEDIO;
	}
	
	@Override
	public void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		if (usuario.getNivel() == NivelUsuario.EXPERTO
				|| muestra.getCantVerificacionesDeTipo(tipo) >= 2) {
			this.guardarVerificacion(muestra, usuario, tipo, new NivelVerificacionAlto());
		}
		else {
			this.guardarVerificacion(muestra, usuario, tipo);
		}
	}

}
