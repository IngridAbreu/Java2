package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Categoria;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.CategoriaService;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping
	public List<Categoria> buscaTodos(){
		return categoriaService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Categoria buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return categoriaService.buscarPorId(id);
	}
	
	@PostMapping
	public Categoria adicionar(@Valid @RequestBody Categoria categoria) {
		return categoriaService.adicionar(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria atualizar(@PathVariable Integer id, @Valid @RequestBody Categoria categoria) throws DataNotFoundException{
		return categoriaService.atualizar(id , categoria);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apagar(@PathVariable Integer id) throws DataNotFoundException{
		categoriaService.apagar(id);
		return ResponseEntity.ok().build();
	}
	
	
	
}
