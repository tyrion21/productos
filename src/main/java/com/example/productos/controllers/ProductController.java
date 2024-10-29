package com.example.productos.controllers;


import com.example.productos.models.Product;
import com.example.productos.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/purchase/{id}")
    public String purchaseProduct(@PathVariable Long id) {
        return productService.purchaseProduct(id);
    }
}