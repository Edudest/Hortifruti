package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.DTO.PedidoDTO;
import br.edu.fiec.Hortifruti.Service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
