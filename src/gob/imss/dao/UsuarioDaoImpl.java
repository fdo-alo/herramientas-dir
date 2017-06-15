package gob.imss.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.entity.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Usuario> getUsuarios() {		
		
		return sessionFactory.getCurrentSession().createQuery("from Usuario", Usuario.class).getResultList();
	}

	@Override
	public void saveUsuario(Usuario usuario) {
		sessionFactory.getCurrentSession().saveOrUpdate(usuario);
	}

}
