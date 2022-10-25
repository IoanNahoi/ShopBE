package com.endava.shopbe.service;

import com.endava.shopbe.entity.User;
import com.endava.shopbe.repository.UserRepo;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public <S extends User> List<S> findAllUsers(Example<S> example) {
        return userRepo.findAll(example);
    }

    public <S extends User> List<S> findAllUsers(Example<S> example, Sort sort) {
        return userRepo.findAll(example, sort);
    }

    public boolean emailIsValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public <S extends User> S save(S entity) throws Exception {
        boolean existsEmailOrUsername = userRepo.existsUserByEmailOrUsername(entity.getEmail(), entity.getUsername());
        if (existsEmailOrUsername) {
            throw new Exception("Email " + entity.getEmail() + " or username " + entity.getUsername() + " are invalid! ");
        }
//        boolean emailValid = EmailValidator.getInstance().isValid(entity.getEmail());
        if (emailIsValid(entity.getEmail())) {
            return userRepo.save(entity);
        } else {
            throw new Exception("Email " + entity.getEmail() + " is not valid");
        }
    }

    public Optional<User> findById(Long aLong) {
        return userRepo.findById(aLong);
    }

    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    public void delete(User entity) {
        userRepo.delete(entity);
    }

    public User getUserByUsername(String username) {
        return userRepo.readUserByUsername(username);
    }

    public List<User> findAllUsersByRole(String roleName) {
        return userRepo.findByRoleName(roleName);
    }
}

