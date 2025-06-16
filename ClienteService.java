package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ClienteDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Clientes;
import br.edu.fiec.Hortifruti.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public void createCustomer(ClienteDTO clienteDTO) {
        Clientes cliente = new Clientes(
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getEndereco(),
                clienteDTO.getTelefone()
        );

        clienteRepository.save(cliente);
    }
}
