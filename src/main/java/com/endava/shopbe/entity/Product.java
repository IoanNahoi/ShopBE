package com.endava.shopbe.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NonNull
    private String name;

    @Column
    @NonNull
    private Double price;

    @Column
    @NonNull
    private Integer cantity;

    @OneToOne
    private Category category;

    @OneToOne
    private Supplier supplier;

    public Product(@NonNull String name, @NonNull Double price, @NonNull Integer cantity, Category category, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.cantity = cantity;
        this.category = category;
        this.supplier = supplier;
    }
}
