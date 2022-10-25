package com.endava.shopbe.repository;

import com.endava.shopbe.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {

    Supplier getSupplierByCompanyName(String companyName);

}