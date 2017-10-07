/**
 * Esta clase define el DAO para el objeto Registro de actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.udea.registro_actividades.modelo.Asignaciones;
import com.udea.registro_actividades.modelo.Registro_Actividades;

//con Spring Data JPA una entidad DAO que extienda de CrudRepository 
// obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.
@Transactional
public interface Registro_ActividadesDAO extends CrudRepository<Registro_Actividades, Integer> {

	// No es necesario implementar el metodo, spring jpa lo hace siempre y
	// cuando
	// el nombre del parametro coincida con un atributo de product
	// para mas detalles ver:
	// http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation

	public Registro_Actividades findById(Integer id);
	
	
	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 * @param asignacion
	 * @return List<Registro_Actividades>
	 */	
	@Query("from Registro_Actividades where asignaciones=?1 ORDER BY regfecha DESC")
	public List<Registro_Actividades> findByAsignaciones(Asignaciones asignacion);
	
	//public List<Registro_Actividades> findByAsignacionesOrderByRegfechaDesc(Asignaciones asignacion);
	
	

}
