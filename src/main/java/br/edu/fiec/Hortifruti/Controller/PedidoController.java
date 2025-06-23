package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.DTO.PedidoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Pedidos;
import br.edu.fiec.Hortifruti.Service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "Pedido")
public class PedidoController {

    @Autowired
    private final PedidoService pedidoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createPedido(@RequestBody PedidoDTO pedidoDTO) throws Exception {
        pedidoService.createPedido(pedidoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "id", produces = APPLICATION_JSON_VALUE)
    public Pedidos getPedidoById(Integer id) throws Exception {
        return pedidoService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "All", produces = APPLICATION_JSON_VALUE)
    public List<Pedidos> getAll() throws Exception {
        return pedidoService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "status", produces = APPLICATION_JSON_VALUE)
    public List<Pedidos> findByStatus(String status) throws Exception {
        return pedidoService.getByStatus(status);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateOrder(@PathVariable Integer id, @RequestBody PedidoDTO pedidoDTO) throws Exception {
        pedidoService.updateOrder(id, pedidoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deletePedido(Integer id) {
        pedidoService.deletePedido(id);
    }
}
