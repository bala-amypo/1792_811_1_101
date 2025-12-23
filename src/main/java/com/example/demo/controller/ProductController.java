package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @PostMapping("/")
    public String createProduct() {
        return "Product created";
    }

    @GetMapping("/")
    public List<String> getAllProducts() {
        return List.of("Product1", "Product2");
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id) {
        return "Product with id " + id;
    }
}
