package gob.imss.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="\"Prodecon\"")
public class Prodecon {
	
	@Id
	@Column(name="\"numero\"")
	private int numero;
	
	@NotEmpty
	@Column(name="\"queja\"")
	private String queja;
	
	@NotEmpty
	@Column(name="\"promovente\"")
	private String promovente;
	
	@NotEmpty
	@Column(name="\"primerNivel\"")
	private String primerNivel;
	
	@NotEmpty
	@Column(name="\"segundoNivel\"")
	private String segundoNivel;
	
	@NotEmpty
	@Column(name="\"tercerNivel\"")
	private String tercerNivel;
	
	@NotNull
	@Column(name="\"fechaCorreo\"")
	private Date fechaCorreo;
	
	@NotEmpty
	@Column(name="\"delegacion\"")
	private String delegacion;
	
	@NotEmpty
	@Column(name="\"subdelegacion\"")
	private String subdelegacion;
	
	@Column(name="\"fechaRespuesta\"")
	private Date fechaRespuesta;
	
	@Column(name="\"fechaLimite\"")
	private Date fechaLimite;
	
	@Column(name="\"ubicacionFisica\"")
	private String ubicacionFisica;
	
	@Column(name="\"subcarpeta\"")
	private String subcarpeta;
	
	@Column(name="\"digital\"")
	private String digital;
	
	@Column(name="\"observaciones\"")
	private String observaciones;
	
	@Column(name="\"estado\"")
	private String estado;
	
	@Column(name="\"ultimoEdoProdecon\"")
	private String ultimoEdoProdecon;
	
	@Column(name="\"ofUltimoEdoProdecon\"")
	private String ofUltimoEdoProdecon;
	
	@Column(name="\"fechaUltimoEdoProdecon\"")
	private Date fechaUltimoEdoProdecon;
	
	@Column(name="\"regUltimoEdoProdecon\"")
	private String regUltimoEdoProdecon;
	
	@Column(name="\"orden\"")
	private String orden;
	
	@Column(name="\"resolucion\"")
	private String resolucion;
	
	@Column(name="\"monto\"")
	private double monto;
	
	@Column(name="\"acuerdosDefinitivos\"")
	private String acuerdosDefinitivos;
	
	@Column(name="\"rfc\"")
	String rfc;
	
	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Prodecon(){
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getQueja() {
		return queja;
	}

	public void setQueja(String queja) {
		this.queja = queja;
	}

	public String getPromovente() {
		return promovente;
	}

	public void setPromovente(String promovente) {
		this.promovente = promovente;
	}

	public String getPrimerNivel() {
		return primerNivel;
	}

	public void setPrimerNivel(String primerNivel) {
		this.primerNivel = primerNivel;
	}

	public String getSegundoNivel() {
		return segundoNivel;
	}

	public void setSegundoNivel(String segundoNivel) {
		this.segundoNivel = segundoNivel;
	}

	public String getTercerNivel() {
		return tercerNivel;
	}

	public void setTercerNivel(String tercerNivel) {
		this.tercerNivel = tercerNivel;
	}

	public Date getFechaCorreo() {
		return fechaCorreo;
	}

	public void setFechaCorreo(Date fechaCorreo) {
			this.fechaCorreo = fechaCorreo;
		
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getSubdelegacion() {
		return subdelegacion;
	}

	public void setSubdelegacion(String subdelegacion) {
		this.subdelegacion = subdelegacion;
	}

	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
			this.fechaRespuesta = fechaRespuesta;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
			this.fechaLimite = fechaLimite;
	}

	public String getUbicacionFisica() {
		return ubicacionFisica;
	}

	public void setUbicacionFisica(String ubicacionFisica) {
		this.ubicacionFisica = ubicacionFisica;
	}

	public String getSubcarpeta() {
		return subcarpeta;
	}

	public void setSubcarpeta(String subcarpeta) {
		this.subcarpeta = subcarpeta;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimoEdoProdecon() {
		return ultimoEdoProdecon;
	}

	public void setUltimoEdoProdecon(String ultimoEdoProdecon) {
		this.ultimoEdoProdecon = ultimoEdoProdecon;
	}

	public String getOfUltimoEdoProdecon() {
		return ofUltimoEdoProdecon;
	}

	public void setOfUltimoEdoProdecon(String ofUltimoEdoProdecon) {
		this.ofUltimoEdoProdecon = ofUltimoEdoProdecon;
	}

	public Date getFechaUltimoEdoProdecon() {
		return fechaUltimoEdoProdecon;
	}

	public void setFechaUltimoEdoProdecon(Date fechaUltimoEdoProdecon) {
			this.fechaUltimoEdoProdecon = fechaUltimoEdoProdecon;
	}

	public String getRegUltimoEdoProdecon() {
		return regUltimoEdoProdecon;
	}

	public void setRegUltimoEdoProdecon(String regUltimoEdoProdecon) {
		this.regUltimoEdoProdecon = regUltimoEdoProdecon;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getAcuerdosDefinitivos() {
		return acuerdosDefinitivos;
	}

	public void setAcuerdosDefinitivos(String acuerdosDefinitivos) {
		this.acuerdosDefinitivos = acuerdosDefinitivos;
	}

	@Override
	public String toString() {
		return "Prodecon [numero=" + numero + ", queja=" + queja + ", promovente=" + promovente + ", primerNivel="
				+ primerNivel + ", segundoNivel=" + segundoNivel + ", tercerNivel=" + tercerNivel + ", fechaCorreo="
				+ fechaCorreo + ", delegacion=" + delegacion + ", subdelegacion=" + subdelegacion + ", fechaRespuesta="
				+ fechaRespuesta + ", fechaLimite=" + fechaLimite + ", ubicacionFisica=" + ubicacionFisica
				+ ", subcarpeta=" + subcarpeta + ", digital=" + digital + ", observaciones=" + observaciones
				+ ", estado=" + estado + ", ultimoEdoProdecon=" + ultimoEdoProdecon + ", ofUltimoEdoProdecon="
				+ ofUltimoEdoProdecon + ", fechaUltimoEdoProdecon=" + fechaUltimoEdoProdecon + ", regUltimoEdoProdecon="
				+ regUltimoEdoProdecon + ", orden=" + orden + ", resolucion=" + resolucion + ", monto=" + monto
				+ ", acuerdosDefinitivos=" + acuerdosDefinitivos + ", rfc=" + rfc + "]";
	}

	
	
	
	

}
