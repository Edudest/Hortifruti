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
        return produtoService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Nome", produces = APPLICATION_JSON_VALUE)
    public List<ProdutoDTO> getAllByName(String nome) {
        return produtoService.getAllByNome(nome);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "Tipo", produces = APPLICATION_JSON_VALUE)
    public List<ProdutoDTO> findByTipo(String tipo) {
        return produtoService.getAllByTipo(tipo);
    }

}