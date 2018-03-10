/**
 * Esta clase define la entidad para el objeto Actividades
 * @author: Gonzalo Garcia gonchalo620@gmail.com
 * @version: 21/04/2017/
 */
package com.udea.registro_actividades.modelo;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "TBL_Actividades", catalog = "", schema = "public" )
public class Actividades {
	
	@Id
	@SequenceGenerator( name = "actividadesSeq", sequenceName = "tbl_actividades_seq", allocationSize = 1, initialValue = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "actividadesSeq" )
	@Column(name="PK_act_id")
	private Integer id;
	
	@Column(name="act_descripcion")
	@NotNull
	private String act_descripcion;
	
	@OneToMany(mappedBy="actividades")
	private Collection<Registro_Actividades> registro_Actividades;


	//Constructor
		public Actividades() {
			
		}
		
		public Actividades(Integer pk_act_id, String act_descripcion) {
			super();
			this.id = pk_act_id;
			this.act_descripcion = act_descripcion;
		}
	
		
		//Getter y Setter
	public Integer getPk_act_id() {
		return id;
	}

	public void setPk_act_id(Integer pk_act_id) {
		this.id = pk_act_id;
	}

	public String getAct_descripcion() {
		return act_descripcion;
	}

	public void setAct_descripcion(String act_descripcion) {
		this.act_descripcion = act_descripcion;
	}

	
	
	
	
	
	
}
