package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.Entity.Produto;
import br.edu.fiec.Hortifruti.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public void createProduct(Produto produto) {
        produtoRepository.save(produto);
    }
}
