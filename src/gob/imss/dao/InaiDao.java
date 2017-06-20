package gob.imss.dao;

import java.util.List;

import gob.imss.entity.Inai;

public interface InaiDao {
	
	public List<Inai> getInai();
	public void saveInai(Inai inai);
	public Inai getInaibyId(int id);

}
