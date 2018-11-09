package main.java;

public class NivelVerificacionBajo extends NivelVerificacion{

	@Override
	public String getNivel() {
		return "Bajo";
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
