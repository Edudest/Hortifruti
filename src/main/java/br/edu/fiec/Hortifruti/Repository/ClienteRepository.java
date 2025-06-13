package br.edu.fiec.Hortifruti.Repository;

import br.edu.fiec.Hortifruti.Model.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes, Integer> {
}
