package br.edu.fiec.Hortifruti.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Produtos")
public class Produtos {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double precoUnitario;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer estoque;

    public Produtos(String nome, Double precoUnitario, String tipo, Integer estoque) {
        setNome(nome);
        setPrecoUnitario(precoUnitario);
        setTipo(tipo);
        setEstoque(estoque);
    }

    @ManyToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Pedidos> pedido;
}

