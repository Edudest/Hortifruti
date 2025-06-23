package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.DTO.FuncionarioDTO;
import br.edu.fiec.Hortifruti.Model.DTO.ProdutoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Funcionarios;
import br.edu.fiec.Hortifruti.Service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "Funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createEmployee(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.createEmployee(funcionarioDTO);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Id", produces = APPLICATION_JSON_VALUE)
    public FuncionarioDTO getEmployeeById(Integer id) {
        return funcionarioService.getEmployeeById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Nome", produces = APPLICATION_JSON_VALUE)
    public List<FuncionarioDTO> getEmployeeAllByName(String nome) {
        return funcionarioService.getEmployeeAllByNome(nome);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "All", produces = APPLICATION_JSON_VALUE)
    public List<Funcionarios> getAll() {
        return funcionarioService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteEmployee(Integer id){
        funcionarioService.deleteEmployee(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateEmployee(@RequestParam Integer id, @RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioService.updateEmployee(id, funcionarioDTO);
    }
}
