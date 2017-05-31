package gob.imss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"TipoDeAcuerdoDefinitivo\"")
public class TipoDeAcuerdoDefinitivo {
	
	@Id
	@Column(name="\"id\"")
	private int id;
	
	@Column(name="\"acuerdo\"")
	private String acuerdo;
	
	public TipoDeAcuerdoDefinitivo(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}

	@Override
	public String toString() {
		return "TipoDeAcuerdoDefinitivo [id=" + id + ", acuerdo=" + acuerdo + "]";
	}
	
	
	
	

}
