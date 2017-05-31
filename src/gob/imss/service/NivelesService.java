package gob.imss.service;

import java.util.LinkedHashMap;
import java.util.List;

import gob.imss.entity.Niveles;

public interface NivelesService {
	
	public List<Niveles> getNiveles();
	public LinkedHashMap<String, String> firstNivelesToHashMap();
	public List<String> secondNivelesToList(String first);
	public List<String> thirdNivelesToList(String second);

}
