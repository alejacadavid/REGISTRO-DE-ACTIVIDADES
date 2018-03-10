package com.udea.registro_actividades.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//Clase que recibe los atributos para los grupos
@Entity
@Table(name = "TBL_Grupos")
public class Grupos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grupoSeq")
	@SequenceGenerator(name="grupoSeq", sequenceName="tbl_grupos_seq", allocationSize=1)
	@Column(name = "PK_gru_id")
	private Integer id;
	
	@NotNull
	@Column(name="gru_nombre")
	private String nombre;
	
	@NotNull
	@Column(name="gru_cantidadCupos")
	private Integer cantidadCupos;
	
	@NotNull
	@Column(name="gru_horario")
	private String horario;
	
	@NotNull
	@Column(name="gru_observaciones")
	private String observaciones;
	
	@OneToMany(mappedBy = "grupos")
	private Collection<Asignaciones> asignaciones;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "TBL_Cursos_Grupos", joinColumns = @JoinColumn(name = "PK_gru_id"), inverseJoinColumns = @JoinColumn(name = "PK_cur_id"))
	private Collection<Cursos> cursos;
	
	
	public Grupos(Integer id, String nombre, Integer cantidadCupos, String horario, String observaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidadCupos = cantidadCupos;
		this.horario = horario;
		this.observaciones = observaciones;
	}

	public Grupos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadCupos() {
		return cantidadCupos;
	}

	public void setCantidadCupos(Integer cantidadCupos) {
		this.cantidadCupos = cantidadCupos;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

	public Collection<Cursos> getCursos() {
		return cursos;
	}

	public void setCursos(Collection<Cursos> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Grupos [id=" + id + ", nombre=" + nombre + ", cantidadCupos=" + cantidadCupos + ", horario=" + horario
				+ ", observaciones=" + observaciones + "]";
	}

	
	
}