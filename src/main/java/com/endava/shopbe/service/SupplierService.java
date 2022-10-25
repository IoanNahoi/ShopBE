package com.endava.shopbe.service;

import com.endava.shopbe.entity.Supplier;
import com.endava.shopbe.repository.SupplierRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierService {
    @Autowired
    private final SupplierRepo supplierRepo;

    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }

    public <S extends Supplier> S save(S entity) {
        return supplierRepo.save(entity);
    }

    public Optional<Supplier> findById(Long aLong) {
        return supplierRepo.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return supplierRepo.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        supplierRepo.deleteById(aLong);
    }

    public void delete(Supplier entity) {
        supplierRepo.delete(entity);
    }
    public Supplier getSupplierByCompanyName(String name){
        System.out.println(supplierRepo.getSupplierByCompanyName(name));
        return supplierRepo.getSupplierByCompanyName(name);
    }
}
