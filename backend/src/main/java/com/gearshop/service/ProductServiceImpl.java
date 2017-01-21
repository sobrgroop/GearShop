package com.gearshop.service;

import com.gearshop.entity.Product;
import com.gearshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByCategory(Long categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    @Override
    public Optional<Product> get(Long id) {
        return productRepository.getOneById(id);
    }
}
