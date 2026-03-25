package com.example.productsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.productsearch.entity.Product;
import com.example.productsearch.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Insert sample data
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Category Search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Price Range Filter
    @GetMapping("/filter")
    public List<Product> getByPriceRange(@RequestParam double min, @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sorted Products
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repo.findAllSortedByPrice();
    }

    // Expensive Products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }
}