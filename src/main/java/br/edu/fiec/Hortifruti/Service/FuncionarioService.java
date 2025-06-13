package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ClienteDTO;
import br.edu.fiec.Hortifruti.Model.DTO.FuncionarioDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Clientes;
import br.edu.fiec.Hortifruti.Model.Entity.Funcionarios;
import br.edu.fiec.Hortifruti.Repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public void createEmployee(FuncionarioDTO funcionarioDTO) {
        Funcionarios funcionario = new Funcionarios(
                funcionarioDTO.getNome(),
                funcionarioDTO.getCpf(),
                funcionarioDTO.getCargo(),
                funcionarioDTO.getTelefone()
        );

        funcionarioRepository.save(funcionario);
    }
}
