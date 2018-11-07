package main.java;

public interface INivelVerificacion {

	public String getNivel();
	public void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo);
}
