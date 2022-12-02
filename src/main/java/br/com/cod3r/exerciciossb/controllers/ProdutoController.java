package br.com.cod3r.exerciciossb.controllers;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.lang.reflect.Method;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired// o Spring e responsavel por criar esse objeto produtorepository com a anotação @Autowired
    private ProdutoRepository produtoRepository;

    //@PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})// com essa anotação mapeamos um unico metodo para criar e alterar dados na tabela
    public @ResponseBody Produto novoProduto(@Valid Produto produto){//dessa forma ja recebemos o objeto e todos os seus parametros nao necessitando instacialos um a um.
        produtoRepository.save(produto);
        return produto;

  //  public @ResponseBody Produto novoProduto(@RequestParam String nome,@RequestParam double preco,@RequestParam double desconto){ //chamada do metodo
  //  Produto produto = new Produto(nome,preco,desconto);//instaciamento da classe produto ja recebendo um valor como parametro

    }
@GetMapping
    public Iterable<Produto> obterProduto(){
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/nome/{parteNome}")
    public Iterable<Produto> obterProdutoPorNome(@PathVariable String parteNome){
        return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }

    @GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
    public Iterable<Produto> obterProdutosPorPagina(
            @PathVariable int numeroPagina, @PathVariable int qtdePagina){
        if (qtdePagina >= 5) qtdePagina = 5;
        PageRequest page = PageRequest.of(numeroPagina, qtdePagina);
        return produtoRepository.findAll(page);
    }

    @GetMapping(path = "/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }
    @DeleteMapping(path = "/{id}")
    public void excluirRegistroPorId(@PathVariable int id){
       produtoRepository.deleteById(id);
    }

    //  @PutMapping
    // public Produto alterarProduto(@Valid Produto produto) {
    //   produtoRepository.save(produto);
    //  return produto;
    }

