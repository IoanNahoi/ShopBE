package com.endava.shopbe.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String companyName;

//    @OneToOne(mappedBy = "supplier")
//    @JoinColumn
//    private Product productSupplier;
}
