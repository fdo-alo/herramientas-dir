package gob.imss.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.entity.TipoDeAcuerdoDefinitivo;

@Repository
@Transactional
public class TipoDeAcuerdoDefinitivoDAOImpl implements TipoDeAcuerdoDefinitivoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	private Session session;

	@Override
	public List<TipoDeAcuerdoDefinitivo> getTipoDeAcuerdoDefinitivo() {
		session = sessionFactory.getCurrentSession();
		
		Query<TipoDeAcuerdoDefinitivo> query = session.createQuery("from TipoDeAcuerdoDefinitivo", TipoDeAcuerdoDefinitivo.class);
		
		return query.getResultList();
	}

	@Override
	public LinkedHashMap<String, String> tipoDeAcuerdoDefinitivoToHashMap() {
		LinkedHashMap<String, String> hmtad = new LinkedHashMap<>();
		
		List<TipoDeAcuerdoDefinitivo> listaN = getTipoDeAcuerdoDefinitivo();
		
		for (TipoDeAcuerdoDefinitivo tipoDeAcuerdoDefinitivo : listaN) {
			hmtad.put(tipoDeAcuerdoDefinitivo.getAcuerdo(), tipoDeAcuerdoDefinitivo.getAcuerdo());
		}
		
		
		return hmtad;
	}

}
