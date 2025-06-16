package br.edu.fiec.Hortifruti.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

   private Integer clienteId;

   private Integer funcionarioId;

   private List<Integer> produtoId;

   private LocalDate data;
}