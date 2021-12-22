package com.company.bootstrap;

import com.company.entity.Product;
import com.company.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Product pc = new Product("DELL");
        Product laptop = new Product("MACBOOK");
        Product phone = new Product("Iphone");
        Product tablet = new Product("IPAD");

        productRepository.save(pc);
        productRepository.save(laptop);
        productRepository.save(phone);
        productRepository.save(tablet);
    }
}
