package main.java.muestra.verificacion;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.usuario.Usuario;

public abstract class NivelVerificacion implements INivelVerificacion{

	public NivelVerificacion() {}
	
	/**
	 *   En caso de elevar el nivel de verificacion, se llama a este metodo para:
	 *   Actualizar el TipoMuestra
	 *   Actualizar el NivelVerificacion
	 *   Asociar la nueva Verificaion con el Usuario y la Muestra
	 * */
	protected void guardarVerificacion(Muestra muestra, Usuario usuario, TipoMuestra tipo) {
		Verificacion ver = new Verificacion(tipo,muestra,usuario);
		muestra.agragarVerificacion(ver);
		usuario.agregarVerificacion(ver);
	}
	protected void guardarVerificacion(Muestra muestra, Usuario usuario, TipoMuestra tipo, INivelVerificacion proxNivel) {
		muestra.setTipoDeMuestra(tipo);
		muestra.setNivelDeVerificacion(proxNivel);
		this.guardarVerificacion(muestra, usuario, tipo);
	}
	
	public abstract NivelesVerificacion getNivel();
	
	/**
	 * Procesa el comportamiento al querer cargar una nueva Verificacion de la Muestra.
	 * Si el nivel de verificacion es Alto, entonces no realiza ninguna accion.
	 * Si el nivel de verificacion es Medio, lo pasa a Alto si el usuario es Experto o suman 2 Verificaciones acumuladas del tipo indicado.
	 * Si el nivel de verificacion es Bajo, lo pasa a Alto si el usuario es Experto o a Medio si tiene una Verificacion acumulada del tipo indicado.
	 * */
	public abstract void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo);
}
