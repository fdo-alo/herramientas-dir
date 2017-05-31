package gob.imss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.dao.ProdeconDAO;
import gob.imss.entity.Prodecon;


@Service
public class ProdeconServiceImpl implements ProdeconService {
	
	@Autowired
	ProdeconDAO prodeconDAO;

	@Override
	@Transactional
	public List<Prodecon> getProdecon() {
		
		return prodeconDAO.getProdecon();
	}

	@Override
	@Transactional
	public void saveProdecon(Prodecon prodecon) {
		// TODO Auto-generated method stub
		prodeconDAO.saveProdecon(prodecon);
	}

	@Override
	@Transactional
	public void updateProdecon(Prodecon prodecon) {
		// TODO Auto-generated method stub
		prodeconDAO.updateProdecon(prodecon);
	}

	@Override
	@Transactional
	public Prodecon prodeconById(int id) {
		// TODO Auto-generated method stub
		return prodeconDAO.prodeconById(id);
	}
	
	@Override
	@Transactional
	public int prodeconLastRegister(){
		
		List<Prodecon> lista = prodeconDAO.getProdecon();
		
		int valor = 0;
		
		for (Prodecon prodecon : lista) {
			valor = prodecon.getNumero();
		}
		
		return valor+=1;
		
	}

	@Override
	@Transactional
	public List<Prodecon> prodeconBetweenDatesPendientes(String inicDate, String finalDate) {
		// TODO Auto-generated method stub
		return prodeconDAO.prodeconBetweenDatesPendientes(inicDate, finalDate);
	}

	@Override
	@Transactional
	public List<Prodecon> prodeconBetweenDates(String inicDate, String finalDate) {
		// TODO Auto-generated method stub
		return prodeconDAO.prodeconBetweenDates(inicDate, finalDate);
	}

}
