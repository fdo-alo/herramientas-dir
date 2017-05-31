package gob.imss.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.dao.NivelesDAO;
import gob.imss.entity.Niveles;

@Service
public class NivelesServiceImpl implements NivelesService {

	@Autowired
	NivelesDAO nivelesDAO;

	@Override
	@Transactional
	public List<Niveles> getNiveles() {

		return nivelesDAO.getNiveles();
	}

	@Override
	@Transactional
	public LinkedHashMap<String, String> firstNivelesToHashMap() {
		// TODO Auto-generated method stub
		return nivelesDAO.firstNivelesToHashMap();
	}

	@Override
	@Transactional
	public List<String> secondNivelesToList(String first) {
		// TODO Auto-generated method stub
		return nivelesDAO.secondNivelesToList(first);
	}

	@Override
	@Transactional
	public List<String> thirdNivelesToList(String second) {
		// TODO Auto-generated method stub
		return nivelesDAO.thirdNivelesToList(second);
	}

}
