package br.com.Crud.Crud.controllers;

import br.com.Crud.Crud.domain.Repository.ProdutosRepository;
import br.com.Crud.Crud.domain.RequestProduto;
import br.com.Crud.Crud.domain.entity.Produtos;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProdutosRepository pr;

    @GetMapping
    public ResponseEntity getAllproducts() {
        var allproducts = pr.findAllByActiveTrue();
        return ResponseEntity.ok(allproducts);
    }

    @PostMapping
    public ResponseEntity postProduto(@RequestBody @Valid RequestProduto data) {
        Produtos newProduto = new Produtos(data);
        System.out.println(data);
        pr.save(newProduto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduto(@RequestBody @Valid RequestProduto data) {
        Optional<Produtos> produto = pr.findById(data.id());
        if(produto.isPresent()) {
            Produtos produto1 = produto.get();
            produto1.setNome(data.nome());
            produto1.setPreco_em_centavos(data.preco_em_centavos());
            return ResponseEntity.ok(produto);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduto(@PathVariable long id) {
        Optional<Produtos> produto = pr.findById(id);
        if(produto.isPresent()) {
            Produtos produto1 = produto.get();
            produto1.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
