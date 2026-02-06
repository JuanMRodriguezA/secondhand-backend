package com.secondhand.secondhandbackend.controller;

import com.secondhand.secondhandbackend.model.Product;
import com.secondhand.secondhandbackend.repository.ProductRepository;
import com.secondhand.secondhandbackend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.saveProduct(product);
    }
}