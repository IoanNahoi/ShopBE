package com.endava.shopbe.repository;

import com.endava.shopbe.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepo extends JpaRepository<WishList,Long> {
}
