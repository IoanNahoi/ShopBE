package com.endava.shopbe.service;

import com.endava.shopbe.entity.Product;
import com.endava.shopbe.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProduceService {
    @Autowired
    public final ProductRepo productRepo;

    public ProduceService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public <S extends Product> List<S> findAll(Example<S> example) {
        return productRepo.findAll(example);
    }

    public <S extends Product> S save(S entity) {
        return productRepo.save(entity);
    }

    public Optional<Product> findById(Long aLong) {
        return productRepo.findById(aLong);
    }

    public void deleteById(Long aLong) {
        productRepo.deleteById(aLong);
    }

    public void delete(Product entity) {
        productRepo.delete(entity);
    }
    public Product getProductByName(String name){
        return productRepo.getProductByName(name);
    }
}

