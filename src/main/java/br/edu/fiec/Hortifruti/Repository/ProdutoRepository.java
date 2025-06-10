package br.edu.fiec.Hortifruti.Repository;

import br.edu.fiec.Hortifruti.Model.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {

    Optional<Produtos> findByNome(String Nome);
}
