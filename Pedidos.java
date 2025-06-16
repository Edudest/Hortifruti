package br.edu.fiec.Hortifruti.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pedido")
public class Pedidos {

    @Id
    @GeneratedValue
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_Funcionario")
    private Funcionarios funcionario;

    @ManyToMany
    @JoinTable(
            name = "pedido_Produto",
            joinColumns = @JoinColumn(name = "id_Pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_Produto")
    )
    private List<Produtos> produto = new ArrayList<>();

    private LocalDate data;

    public Pedidos(Integer clienteId, Integer funcionarioId, List<Integer> produtoId, LocalDate data) {
        setCliente(cliente);
        setFuncionario(funcionario);
        setProduto(produto);
        setData(data);
    }
}


