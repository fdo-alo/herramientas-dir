package gob.imss.service;

import java.util.LinkedHashMap;
import java.util.List;

import gob.imss.entity.TipoDeAcuerdoDefinitivo;

public interface TipoDeAcuerdoDefinitivoService {
	
	public List<TipoDeAcuerdoDefinitivo> getTipoDeAcuerdoDefinitivo();
	public LinkedHashMap<String, String> tipoDeAcuerdoDefinitivoToHashMap();

}
