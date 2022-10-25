package com.endava.shopbe.controller;

import com.endava.shopbe.entity.Product;
import com.endava.shopbe.service.CategoryService;
import com.endava.shopbe.service.ProduceService;
import com.endava.shopbe.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/product")
@AllArgsConstructor
public class ProductController {
    private final ProduceService produceService;

    private final CategoryService categoryService;

    private final SupplierService supplierService;

    @GetMapping("getAllProducts")
    public List<Product> findAll() {
        return produceService.findAll();
    }

    public <S extends Product> List<S> findAll(Example<S> example) {
        return produceService.findAll(example);
    }

    @PostMapping("/addProduct")
    public void save(@RequestParam("name") String name, @RequestParam("price") Double price, @RequestParam("cantity") Integer cantity, @RequestParam("category") String category, @RequestParam("supplier") String supplier) {
        Product product = new Product(name, price, cantity, categoryService.getCategoryByName(category), supplierService.getSupplierByCompanyName(supplier));
        produceService.save(product);
    }

    public Optional<Product> findById(Long aLong) {
        return produceService.findById(aLong);
    }

    public void deleteById(Long aLong) {
        produceService.deleteById(aLong);
    }

    public void delete(Product entity) {
        produceService.delete(entity);
    }
}
