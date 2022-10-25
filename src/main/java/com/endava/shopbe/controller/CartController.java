package com.endava.shopbe.controller;

import com.endava.shopbe.entity.Cart;
import com.endava.shopbe.service.CartService;
import com.endava.shopbe.service.ProduceService;
import com.endava.shopbe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cart")
@CrossOrigin
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    private final ProduceService produceService;

    private final UserService userService;

    @GetMapping("getAllShops")
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @PostMapping("addToCart")
    public void save(@RequestParam("productName") String productName, @RequestParam("productCantity") Integer cantity, @RequestParam("username") String username) {
        Cart cart = new Cart(produceService.getProductByName(productName), cantity, userService.getUserByUsername(username));
        cartService.save(cart);
    }

    @GetMapping("getById")
    public Optional<Cart> findById(Long aLong) {
        return cartService.findById(aLong);
    }

    @DeleteMapping("deleteById")
    public void deleteById(Long aLong) {
        cartService.deleteById(aLong);
    }

    @DeleteMapping("deleteEntity")
    public void delete(Cart cart) {
        cartService.delete(cart);
    }

    @PutMapping("/modify")
    public void modify(Cart cart) {
        cartService.save(cart);
    }
}
