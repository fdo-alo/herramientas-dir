package gob.imss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Delegaciones\"")
public class Delegaciones {
	
	@Id
	@Column(name="\"id\"")
	private int id;
	
	@Column(name="\"Delegaciones\"")
	private String delegaciones;
	
	@Column(name="\"Subdelegaciones\"")
	private String subdelegaciones;
	
	public Delegaciones(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDelegaciones() {
		return delegaciones;
	}

	public void setDelegaciones(String delegaciones) {
		this.delegaciones = delegaciones;
	}

	public String getSubdelegaciones() {
		return subdelegaciones;
	}

	public void setSubdelegaciones(String subdelegaciones) {
		this.subdelegaciones = subdelegaciones;
	}

	@Override
	public String toString() {
		return "Delegaciones [id=" + id + ", delegaciones=" + delegaciones + ", subdelegaciones=" + subdelegaciones
				+ "]";
	}
	
	
}
