package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Cliente;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	private Cliente findById(Integer id) throws DataNotFoundException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return cliente.get();
		} else {
			throw new DataNotFoundException(id);
		}
	}
	
	
	public Cliente buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	//@GetMapping    
	public List <Cliente> buscaTodos(){
		return clienteRepository.findAll();
	}
	
	
	@Transactional
	public Cliente adicionar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente atualizar(Integer id , Cliente clienteNovo) throws DataNotFoundException{
		Cliente cliente = findById(id);
		cliente.setNomeCliente(clienteNovo.getNomeCliente());
		cliente.setRua(clienteNovo.getRua());
		cliente.setNumero(clienteNovo.getNumero());
		cliente.setComplemento(clienteNovo.getComplemento());
		cliente.setBairro(clienteNovo.getBairro());
		cliente.setCep(clienteNovo.getCep());
		cliente.setCidade(clienteNovo.getCidade());
		cliente.setEstado(clienteNovo.getEstado());
		cliente.setTelefoneCliente(clienteNovo.getTelefoneCliente());
		cliente.setNomeUsuario(clienteNovo.getNomeUsuario());
		cliente.setEmailCliente(clienteNovo.getEmailCliente());
		cliente.setCpfCliente(clienteNovo.getCpfCliente());
		cliente.setDataNascimentoCliente(clienteNovo.getDataNascimentoCliente());
		
		return clienteRepository.save(cliente);
	}
	
	
	public void apagar(Integer id) throws DataNotFoundException{
		Cliente cliente = findById(id);
		clienteRepository.delete(cliente);
	}


	
	
	
}
