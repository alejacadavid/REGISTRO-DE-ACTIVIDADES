package com.udea.registro_actividades.modelo;

import java.util.ArrayList;
import java.util.Collection;


import com.udea.registro_actividades.modelo.Grupos;

public class CursoProfesor2 {

	private Integer id;
	
	private String nombre;
	
	private Integer cantidadCreditos;
	
	private Integer totalHorasSemestre;
	
	private Collection<Grupos> grupos= new ArrayList<Grupos>();

	private String nombreGrupo;

	private String horario; 
	
	
	public CursoProfesor2(Integer id, String nombre, Integer cantidadCreditos, Integer totalHorasSemestre,
			String nombreGrupo, String horario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidadCreditos = cantidadCreditos;
		this.totalHorasSemestre = totalHorasSemestre;
		this.nombreGrupo = nombreGrupo;
		this.horario = horario;
	}

	public CursoProfesor2() {
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

	public Integer getCantidadCreditos() {
		return cantidadCreditos;
	}

	public void setCantidadCreditos(Integer cantidadCreditos) {
		this.cantidadCreditos = cantidadCreditos;
	}

	public Integer getTotalHorasSemestre() {
		return totalHorasSemestre;
	}

	public void setTotalHorasSemestre(Integer totalHorasSemestre) {
		this.totalHorasSemestre = totalHorasSemestre;
	}

	public Collection<Grupos> getGrupos() {
		return grupos;
	}

	public void setGrupos(Collection<Grupos> grupos) {
		this.grupos = grupos;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	
}
