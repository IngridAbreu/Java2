package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;


@Entity
@Table(name = "produto")
public class Produto{
	
	//PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_produto", nullable = false)
	private Integer idProduto;
	
	//NOME
	@NotNull
	@Size(min=5, max=100)
	@Column( name = "nome_produto", nullable = false , length=100)
	private String nomeProduto;
	
	//DESCRICAO
	@NotNull
	@Size(min=5, max=500)
	@Column( name = "descricao_produto", nullable = false, length=500)
	private String descricaoProduto;
	
	//VALOR
	@NotNull
	@Column( name = "valor_unitario", nullable = false)
	private double valorUnitario;
	
	//DATA
	@NotNull
	@Column(name = "data_fabricacao" , nullable = false)
	@Temporal(TemporalType.DATE)
	@Past
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
	private Date dataFabricacao;
	
	@ManyToOne
	@JoinColumn(name="id_categoria", referencedColumnName = "id_categoria" , nullable = false)
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name="id_funcionario", referencedColumnName = "id_funcionario", nullable = false)
	private Funcionario funcionario;

	
	public Produto(Integer idProduto, @Size(min = 5, max = 100) String nomeProduto,
			@Size(min = 5, max = 500) String descricaoProduto, double valorUnitario, @Past Date dataFabricacao,
			Categoria categoria, Funcionario funcionario) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.valorUnitario = valorUnitario;
		this.dataFabricacao = dataFabricacao;
		this.categoria = categoria;
		this.funcionario = funcionario;
	}
	
	public Produto() {
		super();
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	

}
