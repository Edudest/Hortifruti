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

import java.util.ArrayList;
import java.util.List;

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
                .orElseThrow(() -> new Exception("Funcionário não encontrado"));

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

        Pedidos pedido = new Pedidos(
                cliente,
                funcionario,
                produtos,
                pedidoDTO.getData());
        pedido.setStatus(pedidoDTO.getStatus());

        return pedidoRepository.save(pedido);
    }

    public Pedidos getById(Integer id) throws Exception {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new Exception("Pedido com id " + id + " não encontrado"));
    }

    public List<Pedidos> getAll() {
        return pedidoRepository.findAll();
    }

    public List<Pedidos> getByStatus(String status) throws Exception {
        return pedidoRepository.findByStatus(status).
                orElseThrow(() -> new Exception("Pedido com  Status não encontrado"));
    }

    public void updateOrder(Integer id, PedidoDTO dto) throws Exception {
        Pedidos pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new Exception("Pedido não encontrado"));

        Clientes cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new Exception("Cliente não encontrado"));

        Funcionarios funcionario = funcionarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new Exception("Funcionário não encontrado"));

        List<Produtos> produtos = dto.getProdutoId().stream()
                .map(produtoId -> produtoRepository.findById(produtoId)
                        .orElseThrow(() -> new RuntimeException("Produto " + produtoId + " não encontrado")))
                .toList();

        pedido.setCliente(cliente);
        pedido.setFuncionario(funcionario);
        pedido.setProduto(new ArrayList<>(produtos));
        pedido.setData(dto.getData());
        pedido.setStatus(dto.getStatus());

        pedidoRepository.save(pedido);
    }

    public void deletePedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}