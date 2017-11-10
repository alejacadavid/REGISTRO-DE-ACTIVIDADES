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
@Table(name = "TBL_Usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuarioSeq")
	@SequenceGenerator(name="usuarioSeq", sequenceName="tbl_usuarios_seq",allocationSize=1)
	@Column(name = "PK_usu_id")
	private Integer id;
	
	@NotNull
	@Column(name = "usu_numeroDocumento")
	private String usuNumeroDocumento;
	
	@NotNull
	@Column(name = "usu_nombres")
	private String usuNombres;
	
	@NotNull
	@Column(name = "usu_apellidos")
	private String usuApellidos;
	
	@NotNull
	@Column(name = "usu_usuario")
	private String usuUsuario;
	
	@NotNull
	@Column(name = "usu_email")
	private String usuEmail;
	
	@NotNull
	@Column(name = "usu_estado")
	private boolean usuEstado;
	
	@NotNull
	@Column(name = "usu_password")
	private String usuPassword;
	
	@NotNull
	@Column(name = "usu_rol")
	private Roles rol;
	
	public Usuarios(Integer id, String usuNumeroDocumento, String usuNombres, String usuApellidos, String usuUsuario,
			String usuEmail, boolean usuEstado, String usuPassword, Roles rol) {
		super();
		this.id = id;
		this.usuNumeroDocumento = usuNumeroDocumento;
		this.usuNombres = usuNombres;
		this.usuApellidos = usuApellidos;
		this.usuUsuario = usuUsuario;
		this.usuEmail = usuEmail;
		this.usuEstado = usuEstado;
		this.usuPassword = usuPassword;
		this.rol = rol;
	}

	public Usuarios() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuNumeroDocumento() {
		return usuNumeroDocumento;
	}

	public void setUsuNumeroDocumento(String usuNumeroDocumento) {
		this.usuNumeroDocumento = usuNumeroDocumento;
	}

	public String getUsuNombres() {
		return usuNombres;
	}

	public void setUsuNombres(String usuNombres) {
		this.usuNombres = usuNombres;
	}

	public String getUsuApellidos() {
		return usuApellidos;
	}

	public void setUsuApellidos(String usuApellidos) {
		this.usuApellidos = usuApellidos;
	}

	public String getUsuUsuario() {
		return usuUsuario;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	public String getUsuEmail() {
		return usuEmail;
	}

	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}

	public boolean isUsuEstado() {
		return usuEstado;
	}

	public void setUsuEstado(boolean usuEstado) {
		this.usuEstado = usuEstado;
	}

	public String getUsuPassword() {
		return usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}
	
	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
}
