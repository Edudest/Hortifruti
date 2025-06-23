package br.edu.fiec.Hortifruti.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_Funcionario")
    private Funcionarios funcionario;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "pedido_Produto",
            joinColumns = @JoinColumn(name = "id_Pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_Produto")
    )
    private List<Produtos> produtos = new ArrayList<>();


    private LocalDate data;

    private String status;

    public Pedidos(Clientes cliente, Funcionarios funcionario, List<Produtos> produtos, LocalDate data) {
        setCliente(cliente);
        setFuncionario(funcionario);
        setProdutos(produtos);
        setData(data);
        setStatus(status);
    }
}