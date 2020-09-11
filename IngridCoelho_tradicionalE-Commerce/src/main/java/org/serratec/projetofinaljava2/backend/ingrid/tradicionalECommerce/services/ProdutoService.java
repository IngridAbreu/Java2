package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services;

import java.util.List;
import java.util.Optional;



import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Produto;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	private Produto findById(Integer id) throws DataNotFoundException {
	Optional<Produto> produto = produtoRepository.findById(id);
	if(produto.isPresent()) {
		return produto.get();
	} else {
		throw new DataNotFoundException(id);
		}
	}
	
	public Produto buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	
	//@GetMapping  
	public List <Produto> buscaTodos(){
		return produtoRepository.findAll();
	}
	
	@Transactional
	public Produto adicionar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto atualizar(Integer id , Produto produtoNovo) throws DataNotFoundException{
		Produto produto = findById(id);
		produto.setNomeProduto(produtoNovo.getNomeProduto());
		produto.setDescricaoProduto(produtoNovo.getDescricaoProduto());
		produto.setValorUnitario(produtoNovo.getValorUnitario());
		produto.setDataFabricacao(produtoNovo.getDataFabricacao());
		produto.setCategoria(produtoNovo.getCategoria());
		produto.setFuncionario(produtoNovo.getFuncionario());
		return produtoRepository.save(produto);
	}
	
	public void apagar(Integer id) throws DataNotFoundException{
		Produto produto = findById(id);
		produtoRepository.delete(produto);
	}

	
	

	

}
