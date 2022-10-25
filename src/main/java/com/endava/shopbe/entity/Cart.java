package com.endava.shopbe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer cantity;

    @OneToOne
    @JoinColumn
    private Product product;

    @OneToOne
    @JoinColumn
    private User user;

    public Cart(Product product, Integer cantity, User user) {
        this.product = product;
        this.cantity = cantity;
        this.user = user;
    }
}
