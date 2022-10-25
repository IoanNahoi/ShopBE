package com.endava.shopbe.controller;

import com.endava.shopbe.entity.Role;
import com.endava.shopbe.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("getAllRoles")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @PostMapping("/role")
    public <S extends Role> S save(@RequestBody S entity) {
        return roleService.save(entity);
    }

    public Optional<Role> findById(Long aLong) {
        return roleService.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return roleService.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        roleService.deleteById(aLong);
    }

    public void delete(Role entity) {
        roleService.delete(entity);
    }
}
