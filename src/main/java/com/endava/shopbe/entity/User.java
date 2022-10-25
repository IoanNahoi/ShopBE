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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NonNull
    private String username;

    @Column
    @NonNull
    private String password;

    @Column(unique = true)
    @NonNull
    private String email;

    @OneToOne
    @JoinColumn
    private Role role;

}
