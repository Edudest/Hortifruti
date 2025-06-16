package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.DTO.ClienteDTO;
import br.edu.fiec.Hortifruti.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "Cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createcustomer(@RequestBody ClienteDTO clienteDTO) {
        clienteService.createCustomer(clienteDTO);
    }
}
