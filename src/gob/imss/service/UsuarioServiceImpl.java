package gob.imss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.dao.UsuarioDao;
import gob.imss.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;

	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
		
		return usuarioDao.getUsuarios();
	}

	@Override
	public void saveUsuario(Usuario usuario) {
		usuarioDao.saveUsuario(usuario);
	}

}
