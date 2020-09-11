package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoProdutoRepository extends JpaRepository <PedidoProduto , Integer>{

	

}
