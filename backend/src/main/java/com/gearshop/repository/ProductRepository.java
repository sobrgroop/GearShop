package com.gearshop.repository;

import com.gearshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> getOneById(Long id);

    @SuppressWarnings("JpaQlInspection")
    @Query("select p from Product p where p.category.id = :id")
    List<Product> getByCategory(@Param("id") Long categoryId);
}
