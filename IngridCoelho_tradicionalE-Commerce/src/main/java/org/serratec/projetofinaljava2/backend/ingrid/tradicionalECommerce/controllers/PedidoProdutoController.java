package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.PedidoProduto;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.DataNotFoundException;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.PedidoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidoproduto") 
public class PedidoProdutoController {
	@Autowired
	private PedidoProdutoService pedidoProdutoService;
	
	
	@GetMapping
	public List<PedidoProduto> buscaTodos(){
		return pedidoProdutoService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public PedidoProduto buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return pedidoProdutoService.buscarPorId(id);
	}
	
	@PostMapping
	public PedidoProduto adicionar(@Valid @RequestBody PedidoProduto pedidoProduto) {
		return pedidoProdutoService.adicionar(pedidoProduto);
	}
	
	@PutMapping("/{id}")
	public PedidoProduto atualizar(@PathVariable Integer id, @Valid @RequestBody PedidoProduto pedidoProduto) throws DataNotFoundException{
		return pedidoProdutoService.atualizar(id , pedidoProduto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apagar(@PathVariable Integer id) throws DataNotFoundException{
		pedidoProdutoService.apagar(id);
		return ResponseEntity.ok().build();
	}
}
