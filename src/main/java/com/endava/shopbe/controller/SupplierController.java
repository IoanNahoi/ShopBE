package com.endava.shopbe.controller;

import com.endava.shopbe.entity.Supplier;
import com.endava.shopbe.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/supplier")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("getAllSupliers")
    public List<Supplier> findAll() {
        return supplierService.findAll();
    }

    @PostMapping("addSupplier")
    public <S extends Supplier> S save(@RequestBody S entity) {
        return supplierService.save(entity);
    }

    public Optional<Supplier> findById(Long aLong) {
        return supplierService.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return supplierService.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        supplierService.deleteById(aLong);
    }

    public void delete(Supplier entity) {
        supplierService.delete(entity);
    }
}
