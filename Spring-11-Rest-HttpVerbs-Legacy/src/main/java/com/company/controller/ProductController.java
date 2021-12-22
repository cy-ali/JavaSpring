package com.company.controller;

import com.company.entity.Product;
import com.company.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @RequestMapping("/products/{id}")
    public @ResponseBody
    Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @RequestMapping("/products")
    public @ResponseBody
    List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody
    List<Product> saveProducts(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public @ResponseBody()
    List<Product> delete(@PathVariable("id") Long id) {
        return productService.delete(id);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    List<Product> update(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
