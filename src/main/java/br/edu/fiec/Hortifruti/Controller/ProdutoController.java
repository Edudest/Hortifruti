package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.Entity.Produto;
import br.edu.fiec.Hortifruti.Service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "Produto")

public class ProdutoController {

    private final ProdutoService produtoService;

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(Integer id){
        produtoService.deleteProduct(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestBody Produto produto){
        produtoService.updateProduct(produto);
    }

}
