/**
 * Esta clase define el DAO para el objeto  actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.udea.registro_actividades.modelo.Asignaciones;
import com.udea.registro_actividades.modelo.Grupos;
import com.udea.registro_actividades.modelo.Semestres;


//Con Spring Data JPA una entidad DAO que extienda de CrudRepository 
// obtiene por defecto los siguientes métodos save, delete, deleteAll, findOne y findAll.

@Transactional
public interface AsignacionesDAO extends CrudRepository<Asignaciones, Integer> {

	// No es necesario implementar el método, spring jpa lo hace siempre y cuando el nombre del parámetro 
	// coincida con un atributo de product para más detalles ver:
	// http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation


	public Asignaciones findById(Integer id);
	
	public List<Asignaciones> findByUsuIdAndSemestre(Integer usuId, Semestres semId);
	
	public Asignaciones findByGruposAndUsuId(Grupos grupo, Integer usuId); 	
	
	public Asignaciones findByGruposAndSemestre(Grupos grupo, Semestres semestre);
}
