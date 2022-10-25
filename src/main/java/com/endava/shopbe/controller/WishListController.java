package com.endava.shopbe.controller;

import com.endava.shopbe.entity.WishList;
import com.endava.shopbe.service.ProduceService;
import com.endava.shopbe.service.UserService;
import com.endava.shopbe.service.WishListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/wishlist")
@CrossOrigin
@AllArgsConstructor
public class WishListController {
    private final WishListService wishListService;

    private final UserService userService;

    private final ProduceService produceService;

    @GetMapping("getWishList")
    public List<WishList> findAll() {
        return wishListService.findAll();
    }

    @PostMapping("addWishList")
    public void save(@RequestParam("username") String username, @RequestParam("productName") String productName) {
        WishList wishList = new WishList(userService.getUserByUsername(username), produceService.getProductByName(productName));
        wishListService.save(wishList);
    }

    @GetMapping("findByID")
    public Optional<WishList> findById(Long aLong) {
        return wishListService.findById(aLong);
    }

    @DeleteMapping("deleteByID")
    public void deleteById(Long aLong) {
        wishListService.deleteById(aLong);
    }

    public void delete(WishList entity) {
        wishListService.delete(entity);
    }
}
