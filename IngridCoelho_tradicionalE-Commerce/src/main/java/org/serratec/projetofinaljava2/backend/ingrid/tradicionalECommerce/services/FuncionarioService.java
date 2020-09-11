package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Funcionario;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	private Funcionario findById(Integer id) throws DataNotFoundException {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			return funcionario.get();
		} else {
			throw new DataNotFoundException(id);
		}
	}
	
	public Funcionario buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}
	
	//@GetMapping    
	public List<Funcionario> buscaTodos(){
		return funcionarioRepository.findAll();
	}
	
	@Transactional	
	public Funcionario adicionar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional
	public Funcionario atualizar(Integer id , Funcionario funcionarioNovo) throws DataNotFoundException{
		Funcionario funcionario = findById(id);
		funcionario.setNomeFuncionario(funcionarioNovo.getNomeFuncionario());
		funcionario.setCpfFuncionario(funcionarioNovo.getCpfFuncionario());
		return funcionarioRepository.save(funcionario);
	}
	
	public void apagar(Integer id) throws DataNotFoundException{
		Funcionario funcionario = findById(id);
		funcionarioRepository.delete(funcionario);
	}

	
	
	
	
	
	
}
