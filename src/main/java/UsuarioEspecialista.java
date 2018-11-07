package main.java;

public class UsuarioEspecialista extends Usuario {

	public UsuarioEspecialista(String alias) {
		super(alias);
	}
	
	@Override
	public NivelUsuario getNivel() {
		return NivelUsuario.EXPERTO;
	}
}
