package gob.imss.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.imss.dao.TipoDeAcuerdoDefinitivoDAO;
import gob.imss.entity.TipoDeAcuerdoDefinitivo;

@Service
public class TipoDeAcuerdoDefinitivoServiceImpl implements TipoDeAcuerdoDefinitivoService {
	
	@Autowired
	private TipoDeAcuerdoDefinitivoDAO tipoDeAcuerdoDefinitivoDAO;

	@Override
	@Transactional
	public List<TipoDeAcuerdoDefinitivo> getTipoDeAcuerdoDefinitivo() {
		// TODO Auto-generated method stub
		return tipoDeAcuerdoDefinitivoDAO.getTipoDeAcuerdoDefinitivo();
	}

	@Override
	@Transactional
	public LinkedHashMap<String, String> tipoDeAcuerdoDefinitivoToHashMap() {
		// TODO Auto-generated method stub
		return tipoDeAcuerdoDefinitivoDAO.tipoDeAcuerdoDefinitivoToHashMap();
	}

}
