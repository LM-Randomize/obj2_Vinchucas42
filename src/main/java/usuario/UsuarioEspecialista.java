package main.java.usuario;

/* Segun lo conversado en clase acordamos que el usuario especialista 
 * nace y muere especialista, no puede adquirir la categoria.
 * */
public class UsuarioEspecialista extends Usuario {

	public UsuarioEspecialista(String alias) {
		super(alias);
	}
	
	@Override
	public NivelUsuario getNivel() {
		return NivelUsuario.EXPERTO;
	}
}
