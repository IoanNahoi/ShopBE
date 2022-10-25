package com.endava.shopbe.controller;

import com.endava.shopbe.email.SendEmail;
import com.endava.shopbe.entity.User;
import com.endava.shopbe.repository.RoleRepo;
import com.endava.shopbe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    private final RoleRepo roleRepo;

    @GetMapping("/getAllUsers")
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    @PostMapping("/register")
    public <S extends User> S save(@Valid @RequestBody S user) {
        try {
            SendEmail sendEmail = new SendEmail();
            sendEmail.RegisterSendEmail(user.getEmail());
            user.setRole(roleRepo.findRoleByName("USER"));
            return userService.save(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<User> findById(Long aLong) {
        return userService.findById(aLong);
    }

    public void deleteById(Long aLong) {
        userService.deleteById(aLong);
    }

    public void delete(User entity) {
        userService.delete(entity);
    }
}
