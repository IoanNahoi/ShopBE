package com.endava.shopbe.repository;

import com.endava.shopbe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

    Product getProductByName(String name);
}
