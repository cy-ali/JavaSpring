package com.company.controller;

import com.company.entity.Product;
import com.company.entity.ResponseWrapper;
import com.company.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Company.V1");
        responseHttpHeaders.set("Operation", "Get List");
        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<List<Product>> saveProducts(@RequestBody Product product) {
        List<Product> set = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "Company.V1")
                .header("Operation", "Create")
                .body(set);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Product>> delete(@PathVariable("id") Long id) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "Company.V1");
        map.add("Operation", "Update");
        List<Product> list = productService.delete(id);

        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Product>> update(@PathVariable("id") Long id, @RequestBody Product product) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "Company.V1");
        map.add("Operation", "Update");
        List<Product> list = productService.updateProduct(id, product);

        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }


    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts(){
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved",productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") long id){
        return ResponseEntity.ok(new ResponseWrapper("product successfully deleted"));
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id") long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper("product successfully deleted"));
    }

}
