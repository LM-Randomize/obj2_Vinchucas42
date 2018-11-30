package main.java.verificacion;

import main.java.Muestra;
import main.java.NivelUsuario;
import main.java.TipoMuestra;
import main.java.Usuario;

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
