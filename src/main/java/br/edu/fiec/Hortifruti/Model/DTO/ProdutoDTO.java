package br.edu.fiec.Hortifruti.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String nome;

    private Double precoUnitario;

    private String tipo;

    private Integer estoque;
}