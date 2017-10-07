/**
 * Esta clase define Los servicios REST para el objeto actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.SemestresDAO;
import com.udea.registro_actividades.modelo.Semestres;

//crossorigin para que permita ser usado desde afuera, se pueden hacer más configuraciones. con crossorigin sin parámetros queda abierto para cualquier maquina
@CrossOrigin
@Controller
public class SemestresRestController {

	final static Logger logger = Logger.getLogger(SemestresRestController.class);

	@Autowired
	SemestresDAO semestresDAO;

	 /**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	 @RequestMapping("/semestres")
	  @ResponseBody
	  public String index() {
	    return "servicios para semestres: /semestres/findAll, /semestres/findBy?id=x, /semestres/semestreActivo";
	  }
	 
	 
	 
	 /**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	@RequestMapping("/semestres/findAll")
	@ResponseBody
	public List<Semestres> getAllSemestres() {
		List<Semestres> semestres = new ArrayList<Semestres>();
		semestres = (List<Semestres>) semestresDAO.findAll();
		logger.info("todos los semestres buscados desde la funcion getAllSemestres /semestres/findAll");
		return semestres;

	}
	
	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	@RequestMapping("/semestres/findBy")
	@ResponseBody
	public Semestres getSemestre(Integer id) {
		Semestres semestres = semestresDAO.findById(id);
		return semestres;
	}
	
	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 05/05/2017/
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/semestres/semestreActivo")
	@ResponseBody
	public ResponseEntity<?> test() {
		Semestres semestre = semestresDAO.findByEstadoActivo();
		if (semestre == null) {
			return new ResponseEntity(new Exception("No hay ningún semestre activo"), HttpStatus.NOT_FOUND);
		}
		//logger.info("Registro de Actividad buscado desde la funcion getSemestreActivo /SemestreActivo");
		return new ResponseEntity<Semestres>(semestre, HttpStatus.OK);
	}
	
	
}
