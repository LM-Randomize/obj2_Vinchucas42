package main.java;

public class NivelVerificacionMedio extends NivelVerificacion {

	@Override
	public String getNivel() {
		return "Medio";
	}
	
	@Override
	public void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		if (usuario.getNivel() == NivelUsuario.EXPERTO
				|| muestra.getCantVerificacionesDeTipo(tipo) >= 2) {
			this.guardarVerificacion(muestra, usuario, tipo, new NivelVerificacionAlto());
		}
	}

}
