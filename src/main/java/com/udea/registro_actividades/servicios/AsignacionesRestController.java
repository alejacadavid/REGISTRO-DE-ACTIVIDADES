/**
 * Esta clase define Los servicios REST para el objeto Asignaciones
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.AsignacionesDAO;
import com.udea.registro_actividades.modelo.Asignaciones;

//crossorigin para que permita ser usado desde afuera, se pueden hacer más configuraciones. con crossorigin sin parámetros queda abierto para cualquier maquina
@CrossOrigin
@Controller
public class AsignacionesRestController {

	final static Logger logger = Logger.getLogger(AsignacionesRestController.class);

	@Autowired
	AsignacionesDAO asignacionesDAO;

	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	 @RequestMapping("/asignaciones")
	  @ResponseBody
	  public String index() {
	    return "servicios para asignaciones: /asignaciones/findAll, /asignaciones/findBy?id=";
	  }
	 

	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 21/04/2017/
	 */
	@RequestMapping("/asignaciones/findAll")
	@ResponseBody
	public List<Asignaciones> getAllAsignaciones() {
		List<Asignaciones> asignaciones = new ArrayList<Asignaciones>();
		asignaciones = (List<Asignaciones>) asignacionesDAO.findAll();
		logger.info("todas las Asignaciones buscadas desde la funcion getAllAsignaciones /asignaciones/findAll");
		return asignaciones;

	}
	
	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 21/04/2017/
	 */
	@RequestMapping("/asignaciones/findBy")
	@ResponseBody
	public Asignaciones getAsignaciones(Integer id) {
		Asignaciones asignaciones = asignacionesDAO.findById(id);
		return asignaciones;
	}
	
	
}
