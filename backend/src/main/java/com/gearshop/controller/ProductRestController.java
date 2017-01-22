package com.gearshop.controller;

import com.gearshop.entity.Product;
import com.gearshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), OK);
    }

    @GetMapping(value = "/products/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> get(@PathVariable("id") Long id) {
        Optional<Product> product = productService.get(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    @GetMapping(value = "/categories/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") Long categoryId) {
        return new ResponseEntity<>(productService.getByCategory(categoryId), OK);
    }
}
