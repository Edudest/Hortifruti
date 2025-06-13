package br.edu.fiec.Hortifruti.Repository;

import br.edu.fiec.Hortifruti.Model.Entity.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Integer> {
}
