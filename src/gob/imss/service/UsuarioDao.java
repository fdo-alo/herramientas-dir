package gob.imss.service;

import java.util.List;

import gob.imss.entity.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> getUsuarios();
	public void saveUsuario(Usuario usuario);

}
