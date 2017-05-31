package gob.imss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Niveles\"")
public class Niveles {
	
	@Id
	@Column(name="\"id\"")
	private int id;
	@Column(name="\"Primer\"")
	private String primer;
	@Column(name="\"Segundo\"")
	private String segundo;
	@Column(name="\"Tercer\"")
	private String tercer;
	
	public Niveles() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimer() {
		return primer;
	}

	public void setPrimer(String primer) {
		this.primer = primer;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public String getTercer() {
		return tercer;
	}

	public void setTercer(String tercer) {
		this.tercer = tercer;
	}

	@Override
	public String toString() {
		return "Niveles [id=" + id + ", primer=" + primer + ", segundo=" + segundo + ", tercer=" + tercer + "]";
	}
	
	
	
	
	

}
