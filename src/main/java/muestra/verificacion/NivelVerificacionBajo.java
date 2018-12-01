package main.java.muestra.verificacion;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.usuario.NivelUsuario;
import main.java.usuario.Usuario;

public class NivelVerificacionBajo extends NivelVerificacion{

	@Override
	public NivelesVerificacion getNivel() {
		return NivelesVerificacion.BAJO;
	}
	
	@Override
	public void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		if (usuario.getNivel() == NivelUsuario.EXPERTO) {
			this.guardarVerificacion(muestra, usuario, tipo, new NivelVerificacionAlto());
		} 
		else if (muestra.getCantVerificacionesDeTipo(tipo) >= 1) {
			this.guardarVerificacion(muestra, usuario, tipo, new NivelVerificacionMedio());
		}
		else {
			this.guardarVerificacion(muestra, usuario, tipo);
		}
	}
}
