package com.udea.registro_actividades.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_Roles")
public class Roles {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rolSeq")
	@SequenceGenerator(name="rolSeq", sequenceName="tbl_usuarios_seq",allocationSize=1)
	@Column(name = "PK_rol_id")
	private Integer id;
	
	@NotNull
	@Column(name = "rol_nombre")
	private String rolNombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public Roles(Integer id, String rolNombre) {
		super();
		this.id = id;
		this.rolNombre = rolNombre;
	}
	
	public Roles() {
		super();
	}
	
}
