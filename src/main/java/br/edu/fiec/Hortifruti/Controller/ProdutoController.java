package br.edu.fiec.Hortifruti.Controller;

import br.edu.fiec.Hortifruti.Model.DTO.ProdutoDTO;
import br.edu.fiec.Hortifruti.Service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = "Produto")

public class ProdutoController {

    private final ProdutoService produtoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProdutoDTO produtoDTO) {

        produtoService.createProduct(produtoDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Id", produces = APPLICATION_JSON_VALUE)
    public ProdutoDTO getById(Integer id) {
        return produtoService.getProductById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Nome", produces = APPLICATION_JSON_VALUE)
    public List<ProdutoDTO> getAllByName(String nome) {
        return produtoService.getProductAllByNome(nome);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Tipo", produces = APPLICATION_JSON_VALUE)
    public List<ProdutoDTO> findByTipo(String tipo) {
        return produtoService.getProductAllByTipo(tipo);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(Integer id){
        produtoService.deleteProduct(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public void updateProduct(@RequestParam Integer id, @RequestBody ProdutoDTO produtoDTO){
        produtoService.updateProduct(id, produtoDTO);
    }

}


