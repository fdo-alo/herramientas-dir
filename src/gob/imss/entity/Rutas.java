package gob.imss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Rutas\"")
public class Rutas {
	
	@Id
	@Column(name="\"id\"")
	private int id;
	
	@Column(name="\"nombre\"")
	private String nombre;
	
	@Column(name="\"ruta\"")
	private String ruta;
	
	public Rutas() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Rutas [id=" + id + ", nombre=" + nombre + ", ruta=" + ruta + "]";
	}
	
	
}
