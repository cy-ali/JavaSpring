package com.company.controller;

import com.company.entity.Product;
import com.company.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public List<Product> saveProducts(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public List<Product> delete(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @PutMapping("/{id}")
    public List<Product> update(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
