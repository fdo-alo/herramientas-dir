package gob.imss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.dao.InaiDao;
import gob.imss.entity.Inai;

@Service
public class InaiServiceImpl implements InaiService {
	
	@Autowired
	InaiDao inaiDao;

	@Override
	@Transactional
	public List<Inai> getInai() {		
		return inaiDao.getInai();
	}

	@Override
	@Transactional
	public void saveInai(Inai inai) {
		inaiDao.saveInai(inai);		
	}

	@Override
	@Transactional
	public Inai getInaibyId(int id) {		
		return inaiDao.getInaibyId(id);
	}
	
	@Override
	@Transactional
	public int inaiLastRegisterDesc()
	{
		List<Inai> lista = inaiDao.getInai();
		
		return lista.get(0).getId() + 1;
	}

}
