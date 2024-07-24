package br.com.Crud.Crud.controllers;

import br.com.Crud.Crud.domain.Repository.ProdutosRepository;
import br.com.Crud.Crud.domain.RequestProduto;
import br.com.Crud.Crud.domain.entity.Produtos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProdutosRepository pr;

    @GetMapping
    public ResponseEntity getAllproducts() {
        var allproducts = pr.findAll();
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
    public ResponseEntity updateProduto() {
        return ResponseEntity.ok().build();
    }
}
