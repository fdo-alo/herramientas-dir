package gob.imss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.dao.RutasDAO;
import gob.imss.entity.Rutas;

@Service
public class RutasServiceImpl implements RutasService {
	
	@Autowired
	private RutasDAO rutasDAO;

	@Override
	@Transactional
	public List<Rutas> getAllRutas() {
		// TODO Auto-generated method stub
		return rutasDAO.getAllRutas();
	}

	@Override
	@Transactional
	public void saveRutas(Rutas rutas) {
		// TODO Auto-generated method stub
		rutasDAO.saveRutas(rutas);

	}

	@Override
	@Transactional
	public Rutas rutasById(int id) {
		
		return rutasDAO.rutasById(id);
	}

}
