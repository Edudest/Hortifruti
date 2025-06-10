package br.edu.fiec.Hortifruti.Model.DTO;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String nome;

    private Double preco;

    private String tipo;

    private Integer estoque;

    public void veiculo(String nome, String tipo, Double preco, Integer estoque) {
        setNome(nome);
        setTipo(tipo);
        setPreco(preco);
        setEstoque(estoque);
    }
}


