package com.endava.shopbe.repository;

import com.endava.shopbe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    public Category getCategoriesByProductCategory(String category);

//    public Optional<Category> findById(Long id);
}
