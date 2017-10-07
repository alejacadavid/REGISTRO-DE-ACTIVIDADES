package com.udea.registro_actividades.servicios;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.registro_actividades.dao.AsignacionesDAO;
import com.udea.registro_actividades.dao.CursoDAO;
import com.udea.registro_actividades.dao.GruposDAO;
import com.udea.registro_actividades.dao.SemestresDAO;
import com.udea.registro_actividades.modelo.Asignaciones;
import com.udea.registro_actividades.modelo.CursoProfesor;
import com.udea.registro_actividades.modelo.Cursos;
import com.udea.registro_actividades.modelo.Grupos;
import com.udea.registro_actividades.modelo.Semestres;


@CrossOrigin
@Controller
public class CursoRestController {

	final static Logger logger = Logger.getLogger(CursoRestController.class);

	@Autowired
	CursoDAO cursoDAO;
	
	@Autowired
	AsignacionesDAO asignacionDAO;
	
	@Autowired
	GruposDAO grupoDAO;
	
	@Autowired
	SemestresDAO semestreDAO;
	
	
	@RequestMapping("/Curso/findAsingXGroup")
	@ResponseBody
	public Asignaciones  obtenerAsigPorGrupo(Integer usuId, Integer grupoId){
		Asignaciones asignaciones = new Asignaciones();
		Grupos grupo = new Grupos();
		
		try{
			grupo = grupoDAO.findById(grupoId);
			asignaciones= asignacionDAO.findByGruposAndUsuId(grupo, usuId);
		}catch(Exception e) {
			e.getMessage();
			return null;
		}
		
		return asignaciones;
	}
		
	@RequestMapping("/Curso/findAsing")
	@ResponseBody
	public List<CursoProfesor> buscarAsignacion(Integer usuId, Integer semId) {
		List<Asignaciones> asignaciones = new ArrayList<Asignaciones>();
		List<CursoProfesor> cursos = new ArrayList<CursoProfesor>();
		CursoProfesor profesor=null;
		CursoProfesor cursoExistente=null;
		Boolean existe=null;
		
		
		Semestres semestre = new Semestres();
		semestre = semestreDAO.findById(semId);
		asignaciones = (List<Asignaciones>) asignacionDAO.findByUsuIdAndSemestre(usuId, semestre);
		for(Asignaciones asignacion: asignaciones){
			profesor= new CursoProfesor();
			
			existe=false;
			
			for(CursoProfesor p: cursos){
				//ArrayList<Cursos> listaCursos = new ArrayList<Cursos>();				
				if(p.getId()==asignacion.getGrupos().getCursos().iterator().next().getCurId()){
					cursoExistente=p;
					existe=true;
					break;
				}
			}
			
			if(!existe){
				profesor.setId(asignacion.getGrupos().getCursos().iterator().next().getCurId());
				profesor.setNombre(asignacion.getGrupos().getCursos().iterator().next().getCurNombre());
				profesor.setCantidadCreditos(asignacion.getGrupos().getCursos().iterator().next().getCurCantidadCreditos());
				profesor.setTotalHorasSemestre(asignacion.getGrupos().getCursos().iterator().next().getCurTotalHorasSemestre());
				profesor.getGrupos().add(asignacion.getGrupos());
				for(Grupos grupo: profesor.getGrupos()){
					grupo.getCursos().removeAll(getAllCursos());					
				}
				cursos.add(profesor);	
			}else{
				cursoExistente.getGrupos().add(asignacion.getGrupos());
				for(Grupos grupo: cursoExistente.getGrupos()){
					grupo.getCursos().removeAll(getAllCursos());
				}
			}
		}
		
		return cursos;
	}

	/**
	 * Metodo que retorna los grupos 
	 * @return
	 */
	@RequestMapping("/Curso/findGrupos")
	@ResponseBody
	public List<Grupos> getAllGrupos() {
		List<Grupos> grupos = new ArrayList<Grupos>();
		grupos = (List<Grupos>) grupoDAO.findAll();
		logger.info("todos los grupos buscados desde la funcion getAllGrupos //findGrupos");
		return grupos;

	}
	
	@RequestMapping("/Curso/findBySem")
	@ResponseBody
	public Semestres getSemestre(Integer semId) {
		Semestres semestre = new Semestres();
		semestre = semestreDAO.findById(semId);
		logger.info("sEMESTRE buscado desde la funcion getSEMESTRE /find. codigo: " + semId);
		return semestre;

	}
	
		
	@RequestMapping("/Curso/findBy")
	@ResponseBody
	public Cursos getCurso(Integer curId) {
		Cursos curso = new Cursos();
		curso = cursoDAO.findById(curId);
		logger.info("Curso buscado desde la funcion getCurso /find. codigo: " + curId);
		return curso;

	}

	@RequestMapping("/Curso/findAll")
	@ResponseBody
	public List<Cursos> getAllCursos() {
		List<Cursos> cursos = new ArrayList<Cursos>();
		cursos = (List<Cursos>) cursoDAO.findAll();
		logger.info("todos los cursos buscados desde la funcion getAllCursos /findAll");
		return cursos;

	}
	
	/*
	@RequestMapping(method = RequestMethod.GET,  value = "/findCursos")
	@ResponseBody
	public void getReportes(HttpServletResponse response, Integer idCurso){
		
		Reportes pruebaReporte = new Reportes();
		
		try{
			pruebaReporte.mostrarReporteCurso(response, idCurso);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/Curso/save")
	@ResponseBody
	public String setCursos(@RequestBody Cursos curso) {

		try {
			if (curso.getCurId() == null || curso.getCurId() == 0) {
				throw new Exception("El Id no puede ser nulo o cero");
			}

			if (curso.getCurNombre() == null || curso.getCurNombre() == "") {
				throw new Exception("El nombre no puede ser nulo o vacio");
			}

			if (curso.getCurCantidadCreditos() == null || curso.getCurCantidadCreditos() == 0) {
				throw new Exception("La cantidad de creditos no puede ser nulo o cero");
			}

			if (curso.getCurTotalHorasSemestre() == null || curso.getCurTotalHorasSemestre() == 0) {
				throw new Exception("El total de horas en el semestre no puede ser nulo o cero");
			}

			cursoDAO.save(curso);
			logger.info("curso insertado desde la funcion setCurso /save. id: " + curso.getCurId() + ", nombre: "
					+ curso.getCurNombre() + ", horas: " + curso.getCurTotalHorasSemestre());
			return "curso con código: " + curso.getCurId() + " guardado correctamente";
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Curso/update")
	@ResponseBody
	public String update (@RequestBody Cursos cur){
		try{
			Cursos curso = cursoDAO.findById(cur.getCurId());
			
			if(curso==null){
				throw new Exception("El curso a actualizar no existe");
			}
			if (cur.getCurId() == null || cur.getCurId() == 0) {
				throw new Exception("El Id no puede ser nulo o cero");
			}

			if (cur.getCurNombre() == null || cur.getCurNombre() == "") {
				throw new Exception("El nombre no puede ser nulo o vacio");
			}

			if (cur.getCurCantidadCreditos() == null || cur.getCurCantidadCreditos() == 0) {
				throw new Exception("La cantidad de creditos no puede ser nulo o cero");
			}

			if (cur.getCurTotalHorasSemestre() == null || cur.getCurTotalHorasSemestre()== 0) {
				throw new Exception("El total de horas en el semestre no puede ser nulo o cero");
			}
			
			curso.setCurNombre(cur.getCurNombre());
			curso.setCurCantidadCreditos(cur.getCurCantidadCreditos());
			curso.setCurTotalHorasSemestre(cur.getCurTotalHorasSemestre());
			cursoDAO.save(curso);
			return "El curso fue actualizado";
			
		}catch(Exception e){
			e.getMessage();
			return "No se pudo actualizar el curso";
		}
	}
	
	
	
}
