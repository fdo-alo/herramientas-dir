package gob.imss.service;

import java.util.List;

import gob.imss.entity.Inai;

public interface InaiService {
	
	public List<Inai> getInai();
	public void saveInai(Inai inai);
	public Inai getInaibyId(int id);
	public int inaiLastRegisterDesc();

}
