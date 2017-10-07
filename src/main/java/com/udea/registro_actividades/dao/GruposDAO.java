/**
 * Esta clase define el DAO para el objeto  actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.udea.registro_actividades.modelo.Grupos;


//con Spring Data JPA una entidad DAO que extienda de CrudRepository 
// obtiene por defecto los siguientes metodos save, delete, deleteAll, findOne y findAll.
@Transactional
public interface GruposDAO extends CrudRepository<Grupos, Integer> {

	// No es necesario implementar el metodo, spring jpa lo hace siempre y
	// cuando
	// el nombre del parametro coincida con un atributo de product
	// para mas detalles ver:
	// http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation


	public Grupos findById(Integer id);
}
