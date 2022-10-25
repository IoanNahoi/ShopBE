package com.endava.shopbe.service;

import com.endava.shopbe.entity.WishList;
import com.endava.shopbe.repository.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WishListService {
    @Autowired
    public final WishListRepo wishListRepo;

    public WishListService(WishListRepo wishListRepo) {
        this.wishListRepo = wishListRepo;
    }

    public List<WishList> findAll() {
        return wishListRepo.findAll();
    }

    public <S extends WishList> S save(S entity) {
        return wishListRepo.save(entity);
    }

    public Optional<WishList> findById(Long aLong) {
        return wishListRepo.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return wishListRepo.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        wishListRepo.deleteById(aLong);
    }

    public void delete(WishList entity) {
        wishListRepo.delete(entity);
    }
}
