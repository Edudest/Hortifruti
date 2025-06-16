package br.edu.fiec.Hortifruti.Repository;

import br.edu.fiec.Hortifruti.Model.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {

    Optional <List<Produtos>> findAllByNome(String nome);

    Optional<List<Produtos>> findByTipo(String tipo);
}
