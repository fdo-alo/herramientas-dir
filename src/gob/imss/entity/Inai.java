package gob.imss.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Inai\"")
public class Inai {
	
	@Id
	@Column(name="\"id\"")
	private int id;
	
	@Column(name="\"folio\"")
	private String folio;
	
	@Column(name="\"contenido\"")
	private String contenido;
	
	@Column(name="\"frecepcion\"")
	private Date frecepcion;
	
	@Column(name="\"frespuesta\"")
	private Date frespuesta;
	
	@Column(name="\"respuesta\"")
	private String respuesta;
	
	@Column(name="\"documento\"")
	private String documento;
	
	@Column(name="\"numcontrol\"")
	private String numcontrol;
	
	@Column(name="\"digital\"")
	private String digital;
	
	@Column(name="\"observaciones\"")
	private String observaciones;
	
	@Column(name="\"fvencimiento\"")
	private Date fvencimiento;
	
	@Column(name="\"rda\"")
	private String rda;
	
	@Column(name="\"recurso\"")
	private String recurso;
	
	@Column(name="\"ubicacion\"")
	private String ubicacion;
	
	public Inai(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFrecepcion() {
		return frecepcion;
	}

	public void setFrecepcion(Date frecepcion) {
		this.frecepcion = frecepcion;
	}

	public Date getFrespuesta() {
		return frespuesta;
	}

	public void setFrespuesta(Date frespuesta) {
		this.frespuesta = frespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNumcontrol() {
		return numcontrol;
	}

	public void setNumcontrol(String numcontrol) {
		this.numcontrol = numcontrol;
	}

	public String getDigital() {
		return digital;
	}

	public void setDigital(String digital) {
		this.digital = digital;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFvencimiento() {
		return fvencimiento;
	}

	public void setFvencimiento(Date fvencimiento) {
		this.fvencimiento = fvencimiento;
	}

	public String getRda() {
		return rda;
	}

	public void setRda(String rda) {
		this.rda = rda;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Inai [id=" + id + ", folio=" + folio + ", contenido=" + contenido + ", frecepcion=" + frecepcion
				+ ", frespuesta=" + frespuesta + ", respuesta=" + respuesta + ", documento=" + documento
				+ ", numcontrol=" + numcontrol + ", digital=" + digital + ", observaciones=" + observaciones
				+ ", fvencimiento=" + fvencimiento + ", rda=" + rda + ", recurso=" + recurso + ", ubicacion="
				+ ubicacion + "]";
	}
	
	

}
