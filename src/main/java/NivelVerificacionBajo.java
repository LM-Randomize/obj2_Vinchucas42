package main.java;

public class NivelVerificacionBajo implements INivelVerificacion{

	@Override
	public String getNivel() {
		return "Bajo";
	}
	
	@Override
	public void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		// TODO Auto-generated method stub

	}
}
