package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;


@Entity
@Table(name = "categoria")
public class Categoria {
	
	//PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_categoria")
	private Integer idCategoria;
	
	//NOME
	@NotNull
	@Size(min=5, max=50)
	@Column( name = "nome_categoria", nullable = false , length=50)
	private String nomeCategoria;
	
	//DESCRICAO
	@NotNull
	@Size(min=5, max=500)
	@Column( name = "descricao_categoria", nullable = false, length=500)
	private String descricaoCategoria;

	public Categoria(Integer idCategoria, @Size(min = 5, max = 50) String nomeCategoria,
			@Size(min = 5, max = 500) String descricaoCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}

	public Categoria() {
		super();
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	
	
	
	
	

}
