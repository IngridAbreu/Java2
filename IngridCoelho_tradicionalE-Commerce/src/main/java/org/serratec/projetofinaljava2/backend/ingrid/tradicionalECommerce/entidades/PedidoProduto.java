package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table(name = "pedidoProduto")
public class PedidoProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_produto_pedido")
	private Integer idProdutoPedido;
	
	@NotNull
	@Column( name = "quantidade", nullable = false )
	private String quantidade;
	
	@ManyToOne
	@JoinColumn(name="id_pedido", referencedColumnName = "id_pedido", nullable = false)
	private Pedido pedido;
	

	@ManyToOne
	@JoinColumn(name="id_produto", referencedColumnName = "id_produto", nullable = false)
	private Produto produto;
	
	
	public PedidoProduto(Integer idProdutoPedido, String quantidade, Pedido pedido, Produto produto) {
		super();
		this.idProdutoPedido = idProdutoPedido;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}


	public PedidoProduto() {
		super();
	}

	public Integer getIdProdutoPedido() {
		return idProdutoPedido;
	}
	public void setIdProdutoPedido(Integer idProdutoPedido) {
		this.idProdutoPedido = idProdutoPedido;
	}

	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	
	
	
	
	
}
