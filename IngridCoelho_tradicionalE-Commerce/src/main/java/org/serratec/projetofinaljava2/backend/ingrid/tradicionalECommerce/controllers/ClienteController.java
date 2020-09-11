package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Cliente;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.ClienteService;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	

	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public List<Cliente> buscaTodos(){
		return clienteService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Cliente buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return clienteService.buscarPorId(id);
	}
	
	@PostMapping
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteService.adicionar(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) throws DataNotFoundException{
		return clienteService.atualizar(id , cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apagar(@PathVariable Integer id) throws DataNotFoundException{
		clienteService.apagar(id);
		return ResponseEntity.ok().build();
	}

}
