package com.udea.registro_actividades.modelo;

import java.util.ArrayList;
import java.util.Collection;


import com.udea.registro_actividades.modelo.Grupos;

public class CursoProfesor3 {

	private Integer id;
	
	private String nombre;
	
	private String grupo;
	
	private String horario;

	public CursoProfesor3(Integer id, String nombre, String grupo, String horario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.grupo = grupo;
		this.horario = horario;
	}

	public CursoProfesor3() {
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

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
}
