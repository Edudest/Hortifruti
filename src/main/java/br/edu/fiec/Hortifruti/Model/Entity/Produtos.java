package br.edu.fiec.Hortifruti.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double preco;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer estoque;

    public Produtos(String nome, Double preco, String tipo, Integer estoque) {
        setNome(nome);
        setPreco(preco);
        setTipo(tipo);
        setEstoque(estoque);
    }
}

