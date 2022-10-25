package com.endava.shopbe.controller;

import com.endava.shopbe.entity.Category;
import com.endava.shopbe.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
@CrossOrigin
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/getall")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    public <S extends Category> List<S> findAll(Example<S> example) {
        return categoryService.findAll(example);
    }

    @PostMapping("/addCategory")
    public <S extends Category> S save(@RequestBody S entity) {
        return categoryService.save(entity);
    }

    public Optional<Category> findById(Long aLong) {
        return Optional.ofNullable(categoryService.findById(aLong));
    }

    public void deleteById(Long aLong) {
        categoryService.deleteById(aLong);
    }

    public void delete(Category entity) {
        categoryService.delete(entity);
    }
}
