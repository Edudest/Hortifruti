package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ClienteDTO;
import br.edu.fiec.Hortifruti.Model.DTO.ProdutoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Clientes;
import br.edu.fiec.Hortifruti.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public ClienteDTO getById(Integer id) {
        return clienteRepository.findById(id).map(clientes ->
                new ClienteDTO(
                        clientes.getNome(),
                        clientes.getCpf(),
                        clientes.getEndereco(),
                        clientes.getTelefone()
                )).orElse(null);
    }

    public List<ClienteDTO> getAllByNome(String nome) {
        List<ClienteDTO> ClientesDTOList = new ArrayList<>();

        clienteRepository.findAllByNome(nome).ifPresent(ClientesList -> {
            ClientesList.forEach(clientes -> {
                ClientesDTOList.add(new ClienteDTO(
                        clientes.getNome(),
                        clientes.getCpf(),
                        clientes.getEndereco(),
                        clientes.getTelefone()
                ));
            });
        });
        return ClientesDTOList;
    }

    public List<Clientes> getAll() {
        return clienteRepository.findAll();
    }

    public void updateCustomer(Integer id, ClienteDTO clienteDTO) {

        clienteRepository.findById(id)
                .ifPresent(customerReturn -> {
                    customerReturn.setNome(clienteDTO.getNome());
                    customerReturn.setCpf(clienteDTO.getCpf());
                    customerReturn.setEndereco(clienteDTO.getEndereco());
                    customerReturn.setTelefone(clienteDTO.getTelefone());
                    clienteRepository.save(customerReturn);
                });
    }

    public void deleteProduct (Integer id){
        clienteRepository.deleteById(id);
    }

}
