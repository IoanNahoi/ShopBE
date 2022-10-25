package com.endava.shopbe.repository;

import com.endava.shopbe.entity.Role;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    public Role findRoleByName(String name);


}
