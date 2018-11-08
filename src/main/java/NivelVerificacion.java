package main.java;

public abstract class NivelVerificacion {

	public NivelVerificacion() {}
	
	protected void guardarVerificacion(Muestra muestra, Usuario usuario, TipoMuestra tipo, NivelVerificacion proxNivel) {
		muestra.setTipoDeMuestra(tipo);
		muestra.setNivelDeVerificacion(proxNivel);
		Verificacion ver = new Verificacion(tipo);
		muestra.agragarVerificacion(ver);
		usuario.agregarVerificacion(ver);
	}
	public abstract String getNivel();
	public abstract void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo);
}
