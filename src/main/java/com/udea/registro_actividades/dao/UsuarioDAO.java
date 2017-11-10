package com.udea.registro_actividades.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;


import com.udea.registro_actividades.modelo.Usuarios;

@Transactional
public interface UsuarioDAO extends CrudRepository<Usuarios, String> {

	public Usuarios findByUsuEmail(String usuEmail);
	public Usuarios findByUsuUsuario(String usuUsuario);
}
