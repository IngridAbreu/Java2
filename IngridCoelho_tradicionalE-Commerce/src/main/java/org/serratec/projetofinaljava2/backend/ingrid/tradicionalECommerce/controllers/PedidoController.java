package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Pedido;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.DataNotFoundException;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services.PedidoService;
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
@RequestMapping("/pedido") 
public class PedidoController {
		
		@Autowired
		private PedidoService pedidoService;
		
		
		@GetMapping
		public List<Pedido> buscaTodos(){
			return pedidoService.buscaTodos();
		}
		
		@GetMapping("/{id}")
		public Pedido buscaPorId(@PathVariable Integer id) throws DataNotFoundException {
			return pedidoService.buscarPorId(id);
		}
		
		@PostMapping
		public Pedido adicionar(@Valid @RequestBody Pedido  pedido) {
			return pedidoService.adicionar(pedido);
		}
		
		@PutMapping("/{id}")
		public Pedido atualizar(@PathVariable Integer id, @Valid @RequestBody Pedido pedido) throws DataNotFoundException{
			return pedidoService.atualizar(id , pedido);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity apagar(@PathVariable Integer id) throws DataNotFoundException{
			pedidoService.apagar(id);
			return ResponseEntity.ok().build();
		}
}
