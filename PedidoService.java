package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.PedidoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Clientes;
import br.edu.fiec.Hortifruti.Model.Entity.Funcionarios;
import br.edu.fiec.Hortifruti.Model.Entity.Pedidos;
import br.edu.fiec.Hortifruti.Model.Entity.Produtos;
import br.edu.fiec.Hortifruti.Repository.ClienteRepository;
import br.edu.fiec.Hortifruti.Repository.FuncionarioRepository;
import br.edu.fiec.Hortifruti.Repository.PedidoRepository;
import br.edu.fiec.Hortifruti.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedidos createPedido(PedidoDTO pedidoDTO) throws Exception {
        Clientes cliente = clienteRepository.findById(pedidoDTO.getClienteId())
            .orElseThrow(() -> new Exception("Cliente não encontrado"));

        Funcionarios funcionario = funcionarioRepository.findById(pedidoDTO.getFuncionarioId())
            .orElseThrow(() -> new Exception("Funcionario não encontrado"));

        List<Produtos> produtos = pedidoDTO.getProdutoId().stream()
            .map(id -> {
                try {
                    return produtoRepository.findById(id)
                            .orElseThrow(() -> new Exception("Produto do id:" + id + "não encontrado"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            })
                .toList();

        Pedidos pedido = new Pedidos();
            pedidoDTO.setClienteId(cliente.getId());
            pedidoDTO.setFuncionarioId(funcionario.getId()),
            pedidoDTO.setProdutoId(produtos.get()),
            pedidoDTO.getData();


        pedidoRepository.save(pedido);
        return pedido;
    }

}
