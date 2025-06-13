package br.edu.fiec.Hortifruti.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Clientes")
public class Clientes{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Long telefone;

    public Clientes(String nome, Long cpf, String endereco, Long telefone) {
        setNome(nome);
        setCpf(cpf);
        setEndereco(endereco);
        setTelefone(telefone);
    }
}
