package gob.imss.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.entity.Prodecon;

@Repository
@Transactional
public class ProdeconDaoImpl implements ProdeconDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	@Override
	public List<Prodecon> getProdecon() {
		session = sessionFactory.getCurrentSession();

		Query<Prodecon> query = session.createQuery("from Prodecon order by numero desc", Prodecon.class);

		List<Prodecon> prodecon = query.getResultList();

		return prodecon;
	}

	@Override
	public void saveProdecon(Prodecon prodecon) {
		session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(prodecon);

	}

	@Override
	public void updateProdecon(Prodecon prodecon) {
		session = sessionFactory.getCurrentSession();

		session.update(prodecon);

	}

	@Override
	public Prodecon prodeconById(int id) {

		Prodecon prodecon = new Prodecon();

		session = sessionFactory.getCurrentSession();
		prodecon = session.get(Prodecon.class, id);

		return prodecon;

	}

	@Override
	public List<Prodecon> prodeconBetweenDatesPendientes(String inicDate, String finalDate) {

		session = sessionFactory.getCurrentSession();

		Query query = session
				.createQuery(
						"from Prodecon where fechaLimite between cast(:inic as date) and cast(:fin as date) and estado = :estado order by numero")
				.setParameter("inic", inicDate).setParameter("fin", finalDate).setParameter("estado", "PENDIENTE");

		return (List<Prodecon>) query.getResultList();
	}

	@Override
	public List<Prodecon> prodeconBetweenDates(String inicDate, String finalDate) {
		session = sessionFactory.getCurrentSession();

		Query query = session
				.createQuery(
						"from Prodecon where fechaLimite between cast(:inic as date) and cast(:fin as date) order by numero")
				.setParameter("inic", inicDate).setParameter("fin", finalDate);

		return (List<Prodecon>) query.getResultList();

	}

}
