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
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_funcionario" )
	private Integer idFuncionario;
	
	@NotNull
	@Size(min=5, max=100)
	@Column( name = "nome_funcionario", nullable = false , length=100)
	private String nomeFuncionario;
	
	@NotNull
	@Size(min=14, max=14)
	@Column( name = "cpf_funcionario", nullable = false , length=14)
	private String cpfFuncionario;
	
	
	
	public Funcionario(Integer idFuncionario, String nomeFuncionario, String cpfFuncionario) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.cpfFuncionario = cpfFuncionario;
	}
	public Funcionario() {
		super();
	}
	
	
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public String getCpfFuncionario() {
		return cpfFuncionario;
	}
	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}
	
	

}
