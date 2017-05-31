package gob.imss.dao;

import java.util.LinkedHashMap;
import java.util.List;

import gob.imss.entity.TipoDeAcuerdoDefinitivo;;

public interface TipoDeAcuerdoDefinitivoDAO {
	
	public List<TipoDeAcuerdoDefinitivo> getTipoDeAcuerdoDefinitivo();
	public LinkedHashMap<String, String> tipoDeAcuerdoDefinitivoToHashMap();

}
