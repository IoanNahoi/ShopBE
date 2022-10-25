package com.endava.shopbe.repository;

import com.endava.shopbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User readUserByUsername(String username);

    boolean existsUserByEmailOrUsername(String email, String username);

    @Query("SELECT b from User b where b.role.name=:name")
    List<User> findByRoleName(String name);
}
