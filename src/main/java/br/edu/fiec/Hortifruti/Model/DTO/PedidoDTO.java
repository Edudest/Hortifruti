package br.edu.fiec.Hortifruti.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PedidoDTO {
   @JsonIgnore
   private Integer clienteId;

   private String clienteNome;

   @JsonIgnore
   private Integer funcionarioId;

   private String funcionarioNome;

   @JsonIgnore
   private List<Integer> produtoId;

   private List<String> produtoNomes;

   private LocalDate data;

}
