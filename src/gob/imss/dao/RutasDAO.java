package gob.imss.dao;

import java.util.List;

import gob.imss.entity.Rutas;

public interface RutasDAO {
	
	public List<Rutas> getAllRutas();
	public void saveRutas(Rutas rutas);
	public Rutas rutasById(int id);

}
