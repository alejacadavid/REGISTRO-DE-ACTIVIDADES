/**
 * Esta clase define el DAO para el objeto  actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.udea.registro_actividades.modelo.Semestres;


/*Con Spring Data JPA una entidad DAO que extienda de CrudRepository 
 obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.*/

//@Transactional metadato que especifica que una interfaz, clase o método debe tener semántica transacciona
@Transactional
public interface SemestresDAO extends CrudRepository<Semestres, Integer> {

	// No es necesario implementar el método, spring jpa lo hace siempre y cuando el nombre del parámetro
	// coincida con un atributo de product para más detalles ver:
	// http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation

/**
 * Método que permite determinar el estado de un semestre
 * @param id  recibe el id
 * @return retorna el estado
 */
	public Semestres findById(Integer id);
	
	@Query("from Semestres where semEstado='1'")
	public Semestres findByEstadoActivo();
}
