package br.edu.fiec.Hortifruti.Repository;

import br.edu.fiec.Hortifruti.Model.Entity.Pedidos;
import br.edu.fiec.Hortifruti.Model.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {

    Optional<List<Pedidos>> findByStatus(String status);
}
