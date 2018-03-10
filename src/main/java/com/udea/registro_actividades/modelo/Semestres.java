package com.udea.registro_actividades.modelo;

import java.util.Collection;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//Clase que contiene los atributos del semestre
@Entity
@Table(name = "TBL_Semestres")
public class Semestres {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="semestreSeq")
	@SequenceGenerator(name="semestreSeq", sequenceName="tbl_semestres_seq", allocationSize=1)
	@Column(name = "PK_sem_id")
	private Integer id;
	
	@NotNull
	@Column(name="sem_nombre")
	private String semNombre;

	@NotNull
	@Column(name="sem_estado")
	private char semEstado;
	
	@OneToMany(mappedBy = "semestre")
	private Collection<Asignaciones> coleccion;

	
	public Semestres(Integer semId, String semNombre, char semEstado, Collection<Asignaciones> asignacionesCollection) {
		super();
		this.id = semId;
		this.semNombre = semNombre;
		this.semEstado = semEstado;
		
	}

	public Semestres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSemId() {
		return id;
	}

	public void setSemId(Integer semId) {
		this.id = semId;
	}

	public String getSemNombre() {
		return semNombre;
	}

	public void setSemNombre(String semNombre) {
		this.semNombre = semNombre;
	}

	public char getSemEstado() {
		return semEstado;
	}

	public void setSemEstado(char semEstado) {
		this.semEstado = semEstado;
	}


	@Override
	public String toString() {
		return "Semestre [semId=" + id + ", semNombre=" + semNombre + ", semEstado=" + semEstado
				+ "]";
	}
	
	

	}