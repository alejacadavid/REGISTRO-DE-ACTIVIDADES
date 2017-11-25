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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.ActividadesDAO;
import com.udea.registro_actividades.dao.GruposDAO;
import com.udea.registro_actividades.modelo.Actividades;

 //crossorigin para que permita ser usado desde afuera, se pueden hacer más configuraciones.
 //con crossorigin sin parámetros queda abierto para cualquier máquina.
 
@CrossOrigin
@Controller


public class ActividadesRestController {

	final static Logger logger = Logger.getLogger(ActividadesRestController.class);

	@Autowired
	ActividadesDAO actividadesDAO;
	GruposDAO gruposDAO;

	 /**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	 @RequestMapping("/actividades")
	  @ResponseBody
	  public String index() {
	    return "servicios para actividades: /actividades/findAll, /actividades/findBy?id=";
	  }
	 
	 
	 
	 /**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	@RequestMapping("/actividades/findAll")
	@ResponseBody
	public List<Actividades> getAllActividades() {
		List<Actividades> actividades = new ArrayList<Actividades>();
		actividades = (List<Actividades>) actividadesDAO.findAll();
		logger.info("todos las Actividades buscadas desde la funcion getAllActividades /actividades/findAll");
		return actividades;

	}
	
	
	/**
	 * @author: Gonzalo Garcia gonchalo620@gmail.com
	 * @version: 03/05/2017/
	 */
	@RequestMapping("/actividades/findBy")
	@ResponseBody
	public Actividades getActividad(Integer id) {
		Actividades actividades = actividadesDAO.findById(id);
		return actividades;
	}
	
	
	
	
}
