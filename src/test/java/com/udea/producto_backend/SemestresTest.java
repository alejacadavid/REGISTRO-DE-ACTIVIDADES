package com.udea.producto_backend;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.hibernate.service.spi.ServiceException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.udea.registro_actividades.dao.SemestresDAO;
import com.udea.registro_actividades.modelo.Semestres;
import com.udea.registro_actividades.servicios.SemestresRestController;

@RunWith(MockitoJUnitRunner.class)
public class SemestresTest {
	
	private Semestres semestresDto;
	
	@InjectMocks
	private SemestresRestController servicioSemestres = new SemestresRestController();
	
	@Mock
	private SemestresDAO semestresDao;
	
	@Before
	public void init() throws ServiceException, ValidationException{
		semestresDto = new Semestres();
		
		List<Semestres> todosLosSemestres = new ArrayList<Semestres>();
		todosLosSemestres.add(semestresDto);
		
	    when(semestresDao.findAll()).thenReturn(todosLosSemestres);
	    
	    when(semestresDao.findById(anyInt())).thenReturn(semestresDto);
	}

	@Test
	public void testIndex() {
		String mensaje = servicioSemestres.index();
		assertTrue(mensaje.equals("servicios para semestres: /semestres/findAll, /semestres/findBy?id=x, /semestres/semestreActivo"));
	}

	@Test
	public void testGetAllSemestres() {
		List<Semestres> todosLosSemestres;
		todosLosSemestres = servicioSemestres.getAllSemestres();
		assertNotNull(todosLosSemestres);
		assertTrue(todosLosSemestres.size()>0);
	}

	@Test
	public void testGetSemestre() {
		Semestres semestre = servicioSemestres.getSemestre(5);
		assertNotNull(semestre);
	}

	@Test
	public void testTest() {
		assertNotNull(servicioSemestres.test());
	}
	

}
