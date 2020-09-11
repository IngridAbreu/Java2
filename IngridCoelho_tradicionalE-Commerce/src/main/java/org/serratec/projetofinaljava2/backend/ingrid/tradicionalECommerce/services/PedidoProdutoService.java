package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services;

import java.util.List;
import java.util.Optional;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.PedidoProduto;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories.PedidoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PedidoProdutoService {


	@Autowired
	private PedidoProdutoRepository pedidoProdutoRepository;
	private PedidoProduto findById(Integer id) throws DataNotFoundException {
	Optional<PedidoProduto> pedidoProduto = pedidoProdutoRepository.findById(id);
	if(pedidoProduto.isPresent()) {
		return pedidoProduto.get();
	} else {
		throw new DataNotFoundException(id);
		}
	}
	
	public PedidoProduto buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	
	//@GetMapping  
	public List <PedidoProduto> buscaTodos(){
		return pedidoProdutoRepository.findAll();
	}
	
	@Transactional
	public PedidoProduto adicionar(PedidoProduto pedidoProduto) {
		return pedidoProdutoRepository.save(pedidoProduto);
	}
	
	@Transactional
	public PedidoProduto atualizar(Integer id , PedidoProduto pedidoProdutoNovo) throws DataNotFoundException{
		PedidoProduto pedidoProduto = findById(id);
		pedidoProduto.setQuantidade(pedidoProdutoNovo.getQuantidade());
		pedidoProduto.setProduto(pedidoProdutoNovo.getProduto());
		pedidoProduto.setPedido(pedidoProdutoNovo.getPedido());
		return pedidoProdutoRepository.save(pedidoProduto);
	}
	
	public void apagar(Integer id) throws DataNotFoundException{
		PedidoProduto pedidoProduto = findById(id);
		pedidoProdutoRepository.delete(pedidoProduto);
	}

}
