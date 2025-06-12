package br.edu.fiec.Hortifruti.Service;

import br.edu.fiec.Hortifruti.Model.DTO.ProdutoDTO;
import br.edu.fiec.Hortifruti.Model.Entity.Produtos;
import br.edu.fiec.Hortifruti.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {


    private final ProdutoRepository produtoRepository;

    public void createProduct(ProdutoDTO produtoDTO) {
        List<ProdutoDTO> ProdutoDTOlist = new ArrayList<>();

        Produtos produtos = new Produtos(
                produtoDTO.getNome(),
                produtoDTO.getPreco(),
                produtoDTO.getTipo(),
                produtoDTO.getEstoque()
        );

        produtoRepository.save(produtos);
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

    public List<ProdutoDTO> getAllByNome(String nome) {
        List<ProdutoDTO> ProdutosDTOList = new ArrayList<>();

        produtoRepository.findAllByNome(nome).ifPresent(ProdutosList -> {
            ProdutosList.forEach(produtos -> {
                ProdutosDTOList.add(new ProdutoDTO(
                        produtos.getNome(),
                        produtos.getPreco(),
                        produtos.getTipo(),
                        produtos.getEstoque()
                ));
            });
        });
        return ProdutosDTOList;
    }

    public List<ProdutoDTO> getAllByTipo(String tipo) {
        List<ProdutoDTO> ProdutosDTOList = new ArrayList<>();

        produtoRepository.findByTipo(tipo).ifPresent(ProdutosList -> {
            ProdutosList.forEach(produtos -> {
                ProdutosDTOList.add(new ProdutoDTO(
                        produtos.getNome(),
                        produtos.getPreco(),
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
                    productReturn.setPreco(produtoDTO.getPreco());
                    productReturn.setTipo(produtoDTO.getTipo());
                    productReturn.setEstoque(produtoDTO.getEstoque());
                    produtoRepository.save(productReturn);
                });
    }


//       produtoRepository.findById(id)
//               .ifPresent(productReturn -> {
//                   productReturn.setNome(produtoDTO.getNome());
//                   produtoRepository.save(productReturn);
//               });
//
//    }

        public void deleteProduct (Integer id){
            produtoRepository.deleteById(id);
        }
    }


