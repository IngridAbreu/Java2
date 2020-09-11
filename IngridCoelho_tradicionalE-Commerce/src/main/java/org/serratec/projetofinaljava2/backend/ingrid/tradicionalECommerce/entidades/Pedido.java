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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;



@Entity
@Table(name = "pedido")
public class Pedido {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column( name = "id_pedido")
		private Integer idPedido;
		
		@NotNull
		@Column(name = "data_pedido" , nullable = false)
		@Temporal(TemporalType.DATE)
		@Past
		@JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
		private Date dataPedido;

		@ManyToOne
		@JoinColumn(name="id_cliente", referencedColumnName = "id_cliente", nullable=false)
		private Cliente cliente;
		
		
		public Pedido(Integer idPedido, @Past Date dataPedido, Cliente cliente) {
			super();
			this.idPedido = idPedido;
			this.dataPedido = dataPedido;
			this.cliente = cliente;
		}

		

		public Pedido() {
			super();
		}

		public Integer getIdPedido() {
			return idPedido;
		}

		public void setIdPedido(Integer idPedido) {
			this.idPedido = idPedido;
		}

		public Date getDataPedido() {
			return dataPedido;
		}

		public void setDataPedido(Date dataPedido) {
			this.dataPedido = dataPedido;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		
		

}
