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

import com.udea.registro_actividades.dao.GruposDAO;
import com.udea.registro_actividades.modelo.Grupos;
import com.udea.registro_actividades.servicios.MainController;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {
	
	private Grupos grupoDto;
	
	@InjectMocks
	private MainController servicioMain = new MainController();
	
	@Mock
	private GruposDAO gruposDao;
	
	@Before
	public void init() throws ServiceException, ValidationException{
		grupoDto = new Grupos();
		
		List<Grupos> todosLosGrupos = new ArrayList<Grupos>();
		todosLosGrupos.add(grupoDto);
		
	    when(gruposDao.findAll()).thenReturn(todosLosGrupos);
	    
	    when(gruposDao.findById(anyInt())).thenReturn(grupoDto);
	}

	@Test
	public void testIndex() {
		String mensaje = servicioMain.index();
		assertTrue(mensaje.equals("Microservicios de Registro Actividades "));

	}

	@Test
	public void testGetAllGrupos() {
		List<Grupos> todosLosGrupos;
		todosLosGrupos = servicioMain.getAllGrupos() ;
		assertNotNull(todosLosGrupos);
		assertTrue(todosLosGrupos.size()>0);
	}

	@Test
	public void testGetgrupo() {
		Grupos grupo = servicioMain.getgrupo(3);
		assertNotNull(grupo);
	}
	

}
