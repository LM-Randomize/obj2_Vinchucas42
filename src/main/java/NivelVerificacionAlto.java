package main.java;

public class NivelVerificacionAlto extends NivelVerificacion {

	@Override
	public String getNivel() {
		return "Alto";
	}
	
	@Override
	public void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		//throw new Exception("No toma mas Verificaciones.");
	}

}
