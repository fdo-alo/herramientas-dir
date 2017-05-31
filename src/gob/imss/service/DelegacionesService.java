package gob.imss.service;

import java.util.LinkedHashMap;
import java.util.List;

import gob.imss.entity.Delegaciones;

public interface DelegacionesService {
	
	public List<Delegaciones> getDelegaciones();
	public LinkedHashMap<String, String> delegacionesToHashMap();
	public List<String> subdelegacionesToList(String delegaciones);

}
