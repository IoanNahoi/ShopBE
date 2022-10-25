package com.endava.shopbe.service;

import com.endava.shopbe.entity.Cart;
import com.endava.shopbe.repository.CartRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    @Autowired
    public final CartRepo cartRepo;

    public List<Cart> findAll() {
        return cartRepo.findAll();
    }

    public <S extends Cart> S save(S entity) {
        return cartRepo.save(entity);
    }

    public Optional<Cart> findById(Long aLong) {
        return cartRepo.findById(aLong);
    }

    public void deleteById(Long aLong) {
        cartRepo.deleteById(aLong);
    }

    public void delete(Cart entity) {
        cartRepo.delete(entity);
    }
    public void update(Cart cart){
        cartRepo.save(cart);
    }
    public List<Cart> userCart(String username){
        return cartRepo.getCartByUserUsername(username);
    }
}
