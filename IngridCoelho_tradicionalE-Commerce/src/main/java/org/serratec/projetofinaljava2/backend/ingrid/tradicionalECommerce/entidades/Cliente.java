package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;


@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_cliente")
	private Integer idCliente;
	
	@NotNull
	@Size(min=5, max=100)
	@Column( name = "nome_cliente", nullable = false , length=100)
	private String nomeCliente;
	
	@NotNull
	@Size(min=5,max=50)
	@Column(name= "rua", nullable=false, length=50)
	private String rua;

	@NotNull
	@Size(min=1,max=10)
	@Column(name= "numero", nullable=false, length=10)
	private String numero;

	@Size(min=0,max=30)
	@Column(name= "complemento", nullable=true, length=30)
	private String complemento;
		
	@NotNull
	@Size(min=0,max=50)
	@Column(name= "bairro", nullable=true, length=50)
	private String bairro;

	@NotNull
	@Size(min=8,max=9)
	@Column(name= "cep", nullable=false, length=9)
	private String cep;
	
	@NotNull
	@Size(min=3,max=40)
	@Column(name= "cidade", nullable=false, length=40)
	private String cidade;

	@NotNull
	@Size(min=2,max=2)
	@Column(name= "uf", nullable=false, length=2)
	private String estado;

	
	@NotNull
	@Size(min=10, max=13)
	@Column( name = "telefone_cliente", nullable = false , length=13)
	private String telefoneCliente;
	
	@NotNull
	@Size(min=5, max=20)
	@Column( name = "nome_usuario", nullable = false , length=20)
	private String nomeUsuario;
	
	
	@Size(min=15, max=50)
	@Column( name = "email_cliente", length=50)
	private String emailCliente;
	
	@NotNull
	@Size(min=11, max=14)
	@Column( name = "cpf_cliente", nullable = false , length=14)
	private String cpfCliente;
	
	@NotNull
	@Column(name = "data_nascimento_cliente" , nullable = false)
	@Past
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataNascimentoCliente;

	
	public Cliente(Integer idCliente, @Size(min = 5, max = 100) String nomeCliente, @Size(min = 5, max = 50) String rua,
			@Size(min = 1, max = 10) String numero, @Size(min = 0, max = 30) String complemento,
			@Size(min = 0, max = 50) String bairro, @Size(min = 8, max = 9) String cep,
			@Size(min = 3, max = 40) String cidade, @Size(min = 2, max = 2) String estado,
			@Size(min = 10, max = 13) String telefoneCliente, String nomeUsuario,
			@Size(min = 15, max = 50) String emailCliente, @Size(min = 11, max = 14) String cpfCliente,
			@Past Date dataNascimentoCliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.telefoneCliente = telefoneCliente;
		this.nomeUsuario = nomeUsuario;
		this.emailCliente = emailCliente;
		this.cpfCliente = cpfCliente;
		this.dataNascimentoCliente = dataNascimentoCliente;
	}

	
	

	public Cliente() {
		super();
	}




	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getTelefoneCliente() {
		return telefoneCliente;
	}


	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public Date getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}


	public void setDataNascimentoCliente(Date dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}
	
	
	

}
	
