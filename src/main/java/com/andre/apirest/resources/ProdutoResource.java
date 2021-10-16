package com.andre.apirest.resources;

import java.util.List;

import com.andre.apirest.models.Produto;
import com.andre.apirest.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
    
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna a Lista dos produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna um produto pelo id")
    public Produto listaProdutoPeloID(@PathVariable(value="id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value="Salva um produto")
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value="Deleta um produto")
    public void deletarProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value="Atualiza um produto")
    public Produto atualizarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

}
