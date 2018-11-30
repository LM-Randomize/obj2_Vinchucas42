package main.java.verificacion;

import main.java.Muestra;
import main.java.TipoMuestra;
import main.java.Usuario;

public interface INivelVerificacion {
	
	public abstract NivelesVerificacion getNivel();
	public abstract void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo);
}
