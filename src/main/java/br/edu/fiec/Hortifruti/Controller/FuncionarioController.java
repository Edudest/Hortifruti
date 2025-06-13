package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.DTO.FuncionarioDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Funcionarios;
import br.edu.fiec.Hortifruti.Service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
