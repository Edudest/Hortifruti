package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.Entity.Produto;
import br.edu.fiec.Hortifruti.Service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class ProdutoController {

    private final ProdutoService produtoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody Produto produto) {
        produtoService.createProduct(produto);
    }
}
