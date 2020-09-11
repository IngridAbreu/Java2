package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Categoria;
import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	private Categoria findById(Integer id) throws DataNotFoundException {
	Optional<Categoria> categoria = categoriaRepository.findById(id);
	if(categoria.isPresent()) {
		return categoria.get();
	} else {
		throw new DataNotFoundException(id);
	}
	}
	
	public Categoria buscarPorId(Integer id) throws DataNotFoundException {
		return findById(id);
	}

	//@GetMapping    
	public List <Categoria> buscaTodos(){
		return categoriaRepository.findAll();
	}
	
	
	@Transactional
	public Categoria adicionar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@Transactional
	public Categoria atualizar(Integer id ,Categoria categoriaNova) throws DataNotFoundException{
		Categoria categoria = findById(id);
		categoria.setNomeCategoria(categoriaNova.getNomeCategoria());
		categoria.setDescricaoCategoria(categoriaNova.getDescricaoCategoria());
		return categoriaRepository.save(categoria);
	}
	
	public void apagar(Integer id) throws DataNotFoundException{
		Categoria categoria = findById(id);
		categoriaRepository.delete(categoria);
	}

	
	
}
