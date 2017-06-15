package gob.imss.service;

import java.util.List;

import gob.imss.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> getUsuarios();
	public void saveUsuario(Usuario usuario);

}
