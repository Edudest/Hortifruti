package br.edu.fiec.Hortifruti.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private Long telefone;

    public Funcionarios(String nome, Long cpf, String cargo, Long telefone) {
        setNome(nome);
        setCpf(cpf);
        setCargo(cargo);
        setTelefone(telefone);
    }
}
