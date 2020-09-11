package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.controllers;

import java.util.List;
import javax.validation.Valid;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Funcionario;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.DataNotFoundException;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	
	@GetMapping
	public List<Funcionario> buscaTodos(){
		return funcionarioService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Funcionario buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
		return funcionarioService.buscarPorId(id);
	}
	
	@PostMapping
	public Funcionario adicionar(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioService.adicionar(funcionario);
	}
	
	@PutMapping("/{id}")
	public Funcionario atualizar(@PathVariable Integer id, @Valid @RequestBody Funcionario funcionario) throws DataNotFoundException{
		return funcionarioService.atualizar(id , funcionario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apagar(@PathVariable Integer id) throws DataNotFoundException{
		funcionarioService.apagar(id);
		return ResponseEntity.ok().build();
	}
	
}
