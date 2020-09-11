package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Pedido;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {
	
		@Autowired
		private PedidoRepository pedidoRepository;
		private Pedido findById(Integer id) throws DataNotFoundException {
			Optional<Pedido> pedido = pedidoRepository.findById(id);
			if(pedido.isPresent()) {
				return pedido.get();
			} else {
				throw new DataNotFoundException(id);
			}
		}
		public Pedido buscarPorId(Integer id) throws DataNotFoundException {
			return findById(id);
		}
		
		//@GetMapping    
		public List <Pedido> buscaTodos(){
			return pedidoRepository.findAll();
		}
		
		@Transactional		
		public Pedido adicionar(Pedido pedido) {
			return pedidoRepository.save(pedido);
		}
		
		@Transactional
		public Pedido atualizar(Integer id , Pedido pedidoNovo) throws DataNotFoundException{
			Pedido pedido = findById(id);
			pedido.setDataPedido(pedidoNovo.getDataPedido());
			pedido.setCliente(pedidoNovo.getCliente());
			return pedidoRepository.save(pedido);
		}
		
		public void apagar(Integer id) throws DataNotFoundException{
			Pedido pedido = findById(id);
			pedidoRepository.delete(pedido);
		}
		
		
		

		
}
