package gob.imss.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.entity.Delegaciones;

@Repository
@Transactional
public class DelegacionesDAOImpl implements DelegacionesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	@Override
	public List<Delegaciones> getDelegaciones() {
		session = sessionFactory.getCurrentSession();
		
		Query<Delegaciones> delegaciones = session.createQuery("from Delegaciones", Delegaciones.class);
		
		return delegaciones.getResultList();
	}

	@Override
	public LinkedHashMap<String, String> delegacionesToHashMap() {
		
		LinkedHashMap<String, String> delegaciones = new LinkedHashMap<>();
		
		List<Delegaciones> listaN = getDelegaciones();
		
		for (Delegaciones delegaciones2 : listaN) {
			delegaciones.put(delegaciones2.getDelegaciones(), delegaciones2.getDelegaciones());
		}
		
		return delegaciones;
	}

	@Override
	public List<String> subdelegacionesToList(String delegaciones) {
		
		List<String> subdelegaciones = new ArrayList<>();		
		List<Delegaciones> listaN = getDelegaciones();
		
		System.out.println(listaN.toString());
		
		for (Delegaciones delegaciones2 : listaN) {		
			
			if(delegaciones2.getDelegaciones().equals(delegaciones)){				
				subdelegaciones.add(delegaciones2.getSubdelegaciones());
			}
		}
		return subdelegaciones;
	}

}
