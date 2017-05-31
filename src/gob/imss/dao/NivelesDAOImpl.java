package gob.imss.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gob.imss.entity.Niveles;

@Repository
public class NivelesDAOImpl implements NivelesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Override
	public List<Niveles> getNiveles() {

		session = sessionFactory.getCurrentSession();

		Query<Niveles> query = session.createQuery("from Niveles", Niveles.class);

		List<Niveles> allNiveles = query.getResultList();

		return allNiveles;
	}

	@Override
	public LinkedHashMap<String, String> firstNivelesToHashMap() {

		LinkedHashMap<String, String> first = new LinkedHashMap<>();

		List<Niveles> listaN = getNiveles();

		for (Niveles niveles : listaN) {
			first.put(niveles.getPrimer(), niveles.getPrimer());
		}

		return first;

	}

	@Override
	public List<String> secondNivelesToList(String first) {

		List<String> second = new ArrayList<>();

		List<Niveles> listaN = getNiveles();

		for (Niveles niveles : listaN) {
			if (niveles.getPrimer().equals(first)) {
				second.add(niveles.getSegundo());
			}
		}
		return second;
	}

	@Override
	public List<String> thirdNivelesToList(String second) {

		List<String> third = new ArrayList<>();

		List<Niveles> listaN = getNiveles();

		for (Niveles niveles : listaN) {
			if (niveles.getSegundo().equals(second)) {
				third.add(niveles.getTercer());

			}
		}
		return third;
	}

}
