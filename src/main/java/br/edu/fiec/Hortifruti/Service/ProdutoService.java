package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ProdutoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Produtos;
import br.edu.fiec.Hortifruti.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    public void createProduct(ProdutoDTO produtoDTO) {

        Produtos produto = new Produtos(
                produtoDTO.getNome(),
                produtoDTO.getPrecoUnitario(),
                produtoDTO.getTipo(),
                produtoDTO.getEstoque()
        );

        produtoRepository.save(produto);
    }

    public ProdutoDTO getProductById(Integer id) {
        return produtoRepository.findById(id).map(produtos ->
            new ProdutoDTO(
                produtos.getNome(),
                produtos.getPrecoUnitario(),
                produtos.getTipo(),
                produtos.getEstoque()
        )).orElse(null);
    }

    public List<ProdutoDTO> getProductAllByNome(String nome) {
        List<ProdutoDTO> ProdutosDTOList = new ArrayList<>();

        produtoRepository.findAllByNome(nome).ifPresent(ProdutosList -> {
            ProdutosList.forEach(produtos -> {
                ProdutosDTOList.add(new ProdutoDTO(
                    produtos.getNome(),
                    produtos.getPrecoUnitario(),
                    produtos.getTipo(),
                    produtos.getEstoque()
                ));
            });
        });
        return ProdutosDTOList;
    }

    public List<ProdutoDTO> getProductAllByTipo(String tipo) {
        List<ProdutoDTO> ProdutosDTOList = new ArrayList<>();

        produtoRepository.findByTipo(tipo).ifPresent(ProdutosList -> {
            ProdutosList.forEach(produtos -> {
                ProdutosDTOList.add(new ProdutoDTO(
                        produtos.getNome(),
                        produtos.getPrecoUnitario(),
                        produtos.getTipo(),
                        produtos.getEstoque()
                ));
            });
        });
        return ProdutosDTOList;
    }

    public void updateProduct(Integer id, ProdutoDTO produtoDTO) {

        produtoRepository.findById(id)
                .ifPresent(productReturn -> {
                    productReturn.setNome(produtoDTO.getNome());
                    productReturn.setPrecoUnitario(produtoDTO.getPrecoUnitario());
                    productReturn.setTipo(produtoDTO.getTipo());
                    productReturn.setEstoque(produtoDTO.getEstoque());
                    produtoRepository.save(productReturn);
                });
    }

    public void deleteProduct (Integer id){
        produtoRepository.deleteById(id);
    }
}