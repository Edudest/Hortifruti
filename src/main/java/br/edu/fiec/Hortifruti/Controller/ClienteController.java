package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.DTO.ClienteDTO;
import br.edu.fiec.Hortifruti.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Id", produces = APPLICATION_JSON_VALUE)
    public ClienteDTO getById(Integer id) {
        return clienteService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Nome", produces = APPLICATION_JSON_VALUE)
    public List<ClienteDTO> getAllByName(String nome) {
        return clienteService.getAllByNome(nome);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(Integer id){
        clienteService.deleteProduct(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestParam Integer id, @RequestBody ClienteDTO clienteDTO){
        clienteService.updateCustomer(id, clienteDTO);
    }
}
