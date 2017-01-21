package com.gearshop.repository;

import com.gearshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository/*@RepositoryRestResource*/
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
