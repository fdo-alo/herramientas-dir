package gob.imss.service;

import java.util.List;

import gob.imss.entity.Prodecon;

public interface ProdeconService {
	
	public List<Prodecon> getProdecon();
	public void saveProdecon(Prodecon prodecon);
	public void updateProdecon(Prodecon prodecon);
	public Prodecon prodeconById(int id);
	public int prodeconLastRegisterDesc();
	public List<Prodecon> prodeconBetweenDatesPendientes(String inicDate, String finalDate);
	public List<Prodecon> prodeconBetweenDates(String inicDate, String finalDate);
	int prodeconLastRegisterAsc();

}
