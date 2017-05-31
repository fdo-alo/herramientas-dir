package gob.imss.service;

import java.util.List;

import gob.imss.entity.Rutas;

public interface RutasService {
	
	public List<Rutas> getAllRutas();
	public void saveRutas(Rutas rutas);
	public Rutas rutasById(int id);

}
