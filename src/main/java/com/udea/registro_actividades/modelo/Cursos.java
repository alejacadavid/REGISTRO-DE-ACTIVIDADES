package com.udea.registro_actividades.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

//Clase que contiene los atributos de los cursos
@Entity
@Table(name = "TBL_Cursos")
public class Cursos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cursoSeq")
	@SequenceGenerator(name="cursoSeq", sequenceName="tbl_cursos_seq",allocationSize=1)
	@Column(name = "PK_cur_id")
	private Integer id;
	
	@NotNull
	@Column(name = "cur_nombre")
	private String curNombre;
	
	@NotNull
	@Column(name = "cur_cantidadCreditos")
	private Integer curCantidadCreditos;
	
	@NotNull
	@Column(name = "cur_totalHorasSemestre")
	private Integer curTotalHorasSemestre;
	
	@ManyToMany(mappedBy="cursos", cascade=CascadeType.ALL)
	private Collection<Grupos> grupos;

	public Cursos(Integer curId, String curNombre, Integer curCantidadCreditos, Integer curTotalHorasSemestre) {
		super();
		this.id = curId;
		this.curNombre = curNombre;
		this.curCantidadCreditos = curCantidadCreditos;
		this.curTotalHorasSemestre = curTotalHorasSemestre;
	}

	public Cursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCurId() {
		return id;
	}

	public void setCurId(Integer curId) {
		this.id = curId;
	}

	public String getCurNombre() {
		return curNombre;
	}

	public void setCurNombre(String curNombre) {
		this.curNombre = curNombre;
	}

	public Integer getCurCantidadCreditos() {
		return curCantidadCreditos;
	}

	public void setCurCantidadCreditos(Integer curCantidadCreditos) {
		this.curCantidadCreditos = curCantidadCreditos;
	}

	public Integer getCurTotalHorasSemestre() {
		return curTotalHorasSemestre;
	}

	public void setCurTotalHorasSemestre(Integer curTotalHorasSemestre) {
		this.curTotalHorasSemestre = curTotalHorasSemestre;
	}

	@Override
	public String toString() {
		return "Curso [curId=" + id + ", curNombre=" + curNombre + ", curCantidadCreditos=" + curCantidadCreditos
				+ ", curTotalHorasSemestre=" + curTotalHorasSemestre + "]";
	}
	
}