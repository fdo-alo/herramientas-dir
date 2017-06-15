package gob.imss.dao;

import java.util.List;

import gob.imss.entity.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> getUsuarios();
	public void saveUsuario(Usuario usuario);

}
