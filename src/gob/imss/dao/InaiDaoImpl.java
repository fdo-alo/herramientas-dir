package gob.imss.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.entity.Inai;

@Repository
@Transactional
public class InaiDaoImpl implements InaiDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Inai> getInai() {
		
		return sessionFactory.getCurrentSession().createQuery("from Inai order by id desc", Inai.class).getResultList();
	}

	@Override
	public void saveInai(Inai inai) {
		sessionFactory.getCurrentSession().saveOrUpdate(inai);
	}

	@Override
	public Inai getInaibyId(int id) {		
		return sessionFactory.getCurrentSession().get(Inai.class, id);
	}

	

}
