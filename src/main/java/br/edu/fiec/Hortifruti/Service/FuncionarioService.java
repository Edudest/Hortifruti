package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ClienteDTO;
import br.edu.fiec.Hortifruti.Model.DTO.FuncionarioDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Clientes;
import br.edu.fiec.Hortifruti.Model.Entity.Funcionarios;
import br.edu.fiec.Hortifruti.Repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public FuncionarioDTO getEmployeeById(Integer id) {
        return funcionarioRepository.findById(id).map(funcionario ->
                new FuncionarioDTO(
                        funcionario.getNome(),
                        funcionario.getCpf(),
                        funcionario.getCargo(),
                        funcionario.getTelefone()
                )).orElse(null);
    }

    public List<FuncionarioDTO> getEmployeeAllByNome(String nome) {
        List<FuncionarioDTO> FuncionarioDTOList = new ArrayList<>();

        funcionarioRepository.findAllByNome(nome).ifPresent(FuncionarioList -> {
            FuncionarioList.forEach(funcionario -> {
                FuncionarioDTOList.add(new FuncionarioDTO(
                        funcionario.getNome(),
                        funcionario.getCpf(),
                        funcionario.getCargo(),
                        funcionario.getTelefone()
                ));
            });
        });
        return FuncionarioDTOList;
    }

    public void updateEmployee(Integer id, FuncionarioDTO funcionarioDTO) {

        funcionarioRepository.findById(id)
                .ifPresent(employeeReturn -> {
                    employeeReturn.setNome(funcionarioDTO.getNome());
                    employeeReturn.setCpf(funcionarioDTO.getCpf());
                    employeeReturn.setCargo(funcionarioDTO.getCargo());
                    employeeReturn.setTelefone(funcionarioDTO.getTelefone());
                    funcionarioRepository.save(employeeReturn);
                });
    }

    public void deleteEmployee (Integer id){
        funcionarioRepository.deleteById(id);
    }
}
