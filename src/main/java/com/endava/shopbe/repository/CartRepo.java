package com.endava.shopbe.repository;

import com.endava.shopbe.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Long> {

    List<Cart> getCartByUserUsername(String username);
}
