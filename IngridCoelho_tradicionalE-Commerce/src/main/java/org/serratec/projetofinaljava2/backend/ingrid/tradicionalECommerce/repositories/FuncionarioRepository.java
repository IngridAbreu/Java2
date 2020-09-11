package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario , Integer>{
	

}
