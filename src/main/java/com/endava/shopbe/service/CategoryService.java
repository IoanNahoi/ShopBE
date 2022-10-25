package com.endava.shopbe.service;

import com.endava.shopbe.entity.Category;
import com.endava.shopbe.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    public final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public <S extends Category> List<S> findAll(Example<S> example) {
        return categoryRepo.findAll(example);
    }

    public <S extends Category> S save(S entity) {
        return categoryRepo.save(entity);
    }

    public Category findById(Long aLong) {
        return categoryRepo.findById(aLong).orElseThrow(()->new EntityNotFoundException(String.format("Category does not exist for id = %s!", aLong)));
    }

    public void deleteById(Long aLong) {
        categoryRepo.deleteById(aLong);
    }

    public void delete(Category entity) {
        categoryRepo.delete(entity);
    }

    public Category getCategoryByName(String category) {
        return categoryRepo.getCategoriesByProductCategory(category);
    }
}
