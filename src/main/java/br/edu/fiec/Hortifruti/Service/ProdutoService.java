package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ProdutoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Produtos;
import br.edu.fiec.Hortifruti.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public void createProduct(ProdutoDTO produtoDTO) {
        Produtos produto = new Produtos(
                produtoDTO.getNome(),
                produtoDTO.getPreco(),
                produtoDTO.getTipo(),
                produtoDTO.getEstoque()
        );

        produtoRepository.save(produto);
    }

    public ProdutoDTO getById(Integer id) {
        return produtoRepository.findById(id).map(produtos ->
            new ProdutoDTO(
                produtos.getNome(),
                produtos.getPreco(),
                produtos.getTipo(),
                produtos.getEstoque()
        )).orElse(null);
    }

    public ProdutoDTO getByNome(String Nome) {
        return produtoRepository.findByNome(Nome).map(produtos ->
            new ProdutoDTO(
                produtos.getNome(),
                produtos.getPreco(),
                produtos.getTipo(),
                produtos.getEstoque()
            )).orElse(null);

    }

}
