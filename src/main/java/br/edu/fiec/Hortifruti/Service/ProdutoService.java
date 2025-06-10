package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ProdutoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Produto;
import br.edu.fiec.Hortifruti.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public void deleteProduct(Integer id) {
        produtoRepository.deleteById(id);
    }
    public void updateProduct(ProdutoDTO produtoDTO) {
        produtoRepository.
    }
}

