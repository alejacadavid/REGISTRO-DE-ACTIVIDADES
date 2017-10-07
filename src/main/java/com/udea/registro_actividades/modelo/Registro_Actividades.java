package com.udea.registro_actividades.modelo;

/**
 * Esta clase define la entidad para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TBL_Registro_Actividades", catalog = "", schema = "public")
public class Registro_Actividades {

	@Id
	@SequenceGenerator(name = "registroActividadesSeq", sequenceName = "tbl_registro_actividades_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registroActividadesSeq")
	@Column(name = "PK_reg_id")
	private Integer id;

	@Column(name = "reg_fecha")
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date regfecha;

	@Column(name = "reg_descripcion")
	@NotNull
	private String reg_descripcion;

	@Column(name = "reg_horasUtilizadas")
	@NotNull
	private Integer reg_horasUtilizadas;

	@JoinColumn(name = "FK_act_id")
	@ManyToOne
	private Actividades actividades;

	@JoinColumn(name = "FK_asig_id")
	@ManyToOne
	private Asignaciones asignaciones;

	// el optional = false es porque este valor no puede ser null, es decir,
	// siempre ha de existir.
	
	// CONSTRUCTOR
	public Registro_Actividades() {

	}

	public Registro_Actividades(Integer pk_reg_id, Date reg_fecha, String reg_descripcion, Integer reg_horasUtilizadas,
			Asignaciones asignaciones, Actividades actividades) {
		super();
		this.id = pk_reg_id;
		this.regfecha = reg_fecha;
		this.reg_descripcion = reg_descripcion;
		this.reg_horasUtilizadas = reg_horasUtilizadas;
		this.asignaciones = asignaciones;
		this.actividades = actividades;
	}

	public Integer getPk_reg_id() {
		return id;
	}

	public void setPk_reg_id(Integer pk_reg_id) {
		this.id = pk_reg_id;
	}

	public Date getReg_fecha() {
		return regfecha;
	}

	public void setReg_fecha(Date reg_fecha) {
		this.regfecha = reg_fecha;
	}

	public String getReg_descripcion() {
		return reg_descripcion;
	}

	public void setReg_descripcion(String reg_descripcion) {
		this.reg_descripcion = reg_descripcion;
	}

	public Integer getReg_horasUtilizadas() {
		return reg_horasUtilizadas;
	}

	public void setReg_horasUtilizadas(Integer reg_horasUtilizadas) {
		this.reg_horasUtilizadas = reg_horasUtilizadas;
	}

	

	public Asignaciones getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(Asignaciones asignaciones) {
		this.asignaciones = asignaciones;
	}

	public Actividades getActividades() {
		return actividades;
	}

	public void setActividades(Actividades actividades) {
		this.actividades = actividades;
	}

	// CONSTRUCTOR CON PARÁMETROS

}
