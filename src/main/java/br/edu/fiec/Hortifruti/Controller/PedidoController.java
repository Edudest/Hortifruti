package br.edu.fiec.Hortifruti.Controller;
import br.edu.fiec.Hortifruti.Model.DTO.PedidoDTO;
import br.edu.fiec.Hortifruti.Service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("Pedido")  // Mantém o endpoint como "/Pedido"
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody PedidoDTO pedidoDTO) throws Exception {
        pedidoService.createOrder(pedidoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public PedidoDTO getOrderById(@PathVariable Integer id) throws Exception {
        return pedidoService.getOrderById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        pedidoService.deleteOrder(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateOrder(@PathVariable Integer id, @RequestBody PedidoDTO pedidoDTO) throws Exception {
        pedidoService.updateOrder(id, pedidoDTO);
    }
}

