package gob.imss.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.entity.Rutas;

@Repository
@Transactional
public class RutasDAOImpl implements RutasDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	@Override
	public List<Rutas> getAllRutas() {
		
		session = sessionFactory.getCurrentSession();
		
		Query<Rutas> query = session.createQuery("from Rutas", Rutas.class);
		
		return query.getResultList();
	}

	@Override
	public void saveRutas(Rutas rutas) {
		
		session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(rutas);

	}

	@Override
	public Rutas rutasById(int id) {
		
		Rutas ruta = new Rutas();
		
		session = sessionFactory.getCurrentSession();
		ruta = session.get(Rutas.class, id);
		
		return ruta;
	}

}
