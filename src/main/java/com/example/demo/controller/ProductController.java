package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping
    public Product create(@RequestBody Product product) {
        return repo.save(product);
    }

    // READ ALL
    @GetMapping
    public List<Product> g
