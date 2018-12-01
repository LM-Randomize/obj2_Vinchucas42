package main.java.muestra.verificacion;

import main.java.muestra.Muestra;
import main.java.muestra.TipoMuestra;
import main.java.usuario.Usuario;

public interface INivelVerificacion {
	
	public abstract NivelesVerificacion getNivel();
	public abstract void verificar(Muestra muestra, Usuario usuario, TipoMuestra tipo);
}
