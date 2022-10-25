package com.endava.shopbe.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userWishList;

    @ManyToOne
    private Product productWishList;

    public WishList(User user, Product product) {
    this.userWishList=user;
    this.productWishList=product;
    }
}
