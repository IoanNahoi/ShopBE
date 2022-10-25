package com.endava.shopbe.wishListTests;

import com.endava.shopbe.entity.*;
import com.endava.shopbe.repository.WishListRepo;
import com.endava.shopbe.service.WishListService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WishListTests {

    @Mock
    private WishListRepo wishListRepo;

    private WishListService wishListService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        wishListService = new WishListService(wishListRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    public Product createProduct() {
        return Product.builder()
                .name("Iphone 13")
                .price(1300.0)
                .cantity(120)
                .category(new Category(1L, "Electrocasnice"))
                .supplier(new Supplier(1L, "Apple"))
                .build();
    }

    public Role createRole() {
        return Role.builder()
                .id(130L)
                .name("ADMIN").build();
    }

    public User createUser() {
        return User.builder()
                .username("testam123")
                .password("facemteste")
                .email("emailtest@yahoo.com")
                .role(createRole())
                .build();
    }

    @Test
    void saveWishListTest() {
        WishList wishList = WishList.builder()
                .id(12L)
                .productWishList(createProduct())
                .userWishList(createUser())
                .build();

        wishListService.save(wishList);

        ArgumentCaptor<WishList> wishListArgumentCaptor = ArgumentCaptor.forClass(WishList.class);
        verify(wishListRepo).save(wishListArgumentCaptor.capture());

        WishList capturedWishList = wishListArgumentCaptor.getValue();
        Assertions.assertThat(capturedWishList).isEqualTo(wishList);

    }

    @Test
    void findAllWishList() {
        wishListService.findAll();
        verify(wishListRepo).findAll();
    }

}
