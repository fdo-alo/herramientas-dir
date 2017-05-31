package gob.imss.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.dao.DelegacionesDAO;
import gob.imss.entity.Delegaciones;

@Service
public class DelegacionesServiceImpl implements DelegacionesService {
	
	@Autowired
	private DelegacionesDAO delegacionesDAO;
	

	@Override
	@Transactional
	public List<Delegaciones> getDelegaciones() {
		
		return delegacionesDAO.getDelegaciones();
	}

	@Override
	@Transactional
	public LinkedHashMap<String, String> delegacionesToHashMap() {
		// TODO Auto-generated method stub
		return delegacionesDAO.delegacionesToHashMap();
	}

	@Override
	@Transactional
	public List<String> subdelegacionesToList(String delegaciones) {
		// TODO Auto-generated method stub
		return delegacionesDAO.subdelegacionesToList(delegaciones);
	}

}
