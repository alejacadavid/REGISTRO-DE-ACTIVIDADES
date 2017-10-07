/**
 * Esta clase define la entidad para el objeto Asignaciones
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.modelo;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_Asignaciones")
public class Asignaciones {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="asignacionSeq")
	@SequenceGenerator(name="asignacionSeq", sequenceName="tbl_asignaciones_seq", allocationSize=1)
	@Column(name = "PK_asig_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "FK_sem_id")
	private Semestres semestre;
	
	@ManyToOne
	@JoinColumn(name = "FK_gru_id")
	private Grupos grupos;
	
	@NotNull
	@Column(name="FK_usu_id")
	private Integer usuId;

	@OneToMany(mappedBy="asignaciones")
	private Collection<Registro_Actividades> registro_Actividades;


	public Asignaciones(Integer asigId, Semestres semestre, Grupos grupos, Integer usuId) {
		super();
		this.id = asigId;
		this.semestre = semestre;
		this.grupos = grupos;
		this.usuId = usuId;
		//this.registro_Actividades = (Collection<Registro_Actividades>) registro_Actividades;
	}

	public Asignaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAsigId() {
		return id;
	}

	public void setAsigId(Integer asigId) {
		this.id = asigId;
	}

	public Semestres getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestres semestre) {
		this.semestre = semestre;
	}

	public Grupos getGrupos() {
		return grupos;
	}

	public void setGrupos(Grupos grupos) {
		this.grupos = grupos;
	}

	public Integer getUsuId() {
		return usuId;
	}

	public void setUsuId(Integer usuId) {
		this.usuId = usuId;
	}
	
	

	@Override
	public String toString() {
		return "Asignaciones [asigId=" + id + ", semestre=" + semestre + ", grupos=" + grupos + ", usuId=" + usuId
				+ "]";
	}

	
	
	}
