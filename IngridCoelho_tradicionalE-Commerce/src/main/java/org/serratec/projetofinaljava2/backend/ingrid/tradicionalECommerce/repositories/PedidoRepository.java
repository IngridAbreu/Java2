package org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.repositories;

import org.serratec.projetofinaljava2.backend.ingrid.tradicionalECommerce.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido , Integer>{
	
}
