package br.edu.fiec.Hortifruti.Repository;

import br.edu.fiec.Hortifruti.Model.Entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {
}
