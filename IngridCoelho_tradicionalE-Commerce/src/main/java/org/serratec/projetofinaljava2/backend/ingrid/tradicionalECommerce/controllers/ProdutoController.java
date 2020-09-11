package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.controllers;

import java.util.List;
import javax.validation.Valid;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Produto;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.DataNotFoundException;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.ProdutoService;
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
@RequestMapping("/produto")   
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	
	@GetMapping
	public List<Produto> buscaTodos(){
		return produtoService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Produto buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return produtoService.buscarPorId(id);
	}
	
	@PostMapping
	public Produto adicionar(@Valid @RequestBody Produto produto) {
		return produtoService.adicionar(produto);
	}
	
	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Integer id, @Valid @RequestBody Produto produto) throws DataNotFoundException{
		return produtoService.atualizar(id , produto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apagar(@PathVariable Integer id) throws DataNotFoundException{
		produtoService.apagar(id);
		return ResponseEntity.ok().build();
	}
	
}
