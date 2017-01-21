package com.gearshop.service;

import com.gearshop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    List<Product> getByCategory(Long categoryId);

    Optional<Product> get(Long id);
}
