package main.java;

public interface INivelVerificacion {
	
	public abstract String getNivel();
	public abstract void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo);
}
