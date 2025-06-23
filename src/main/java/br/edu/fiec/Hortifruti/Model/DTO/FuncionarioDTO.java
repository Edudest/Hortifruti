package br.edu.fiec.Hortifruti.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private String nome;

    private Long cpf;

    private String cargo;

    private Long telefone;
}