package main.java;

public abstract class NivelVerificacion {

	public NivelVerificacion() {}
	
	//En caso de elevar el nivel de verificacion, se llama a este metodo para:
	//	Actualizar el TipoMuestra
	//	Actualizar el NivelVerificacion
	//	Asociar la nueva Verificaion con el Usuario y la Muestra
	protected void guardarVerificacion(Muestra muestra, Usuario usuario, TipoMuestra tipo, NivelVerificacion proxNivel) {
		muestra.setTipoDeMuestra(tipo);
		muestra.setNivelDeVerificacion(proxNivel);
		Verificacion ver = new Verificacion(tipo);
		muestra.agragarVerificacion(ver);
		usuario.agregarVerificacion(ver);
	}
	
	public abstract String getNivel();
	
	//Procesa el comportamiento al querer cargar una nueva Verificacion de la Muestra.
	//Si el nivel de verificacion es Alto, entonces no realiza ninguna accion.
	//Si el nivel de verificacion es Medio, lo pasa a Alto si el usuario es Experto o suman 2 Verificaciones acumuladas del tipo indicado.
	//Si el nivel de verificacion es Bajo, lo pasa a Alto si el usuario es Experto o a Medio si tiene una Verificacion acumulada del tipo indicado.
	public abstract void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo);
}
