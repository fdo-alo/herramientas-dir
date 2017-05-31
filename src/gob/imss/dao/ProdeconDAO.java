package gob.imss.dao;

import java.util.List;

import gob.imss.entity.Prodecon;

public interface ProdeconDAO {
	
	public List<Prodecon> getProdecon();
	public void saveProdecon(Prodecon prodecon);
	public void updateProdecon(Prodecon prodecon);
	public Prodecon prodeconById(int id);
	public List<Prodecon> prodeconBetweenDatesPendientes(String inicDate, String finalDate);
	public List<Prodecon> prodeconBetweenDates(String inicDate, String finalDate);
	
	

}
