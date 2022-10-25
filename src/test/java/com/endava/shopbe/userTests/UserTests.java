package com.endava.shopbe.userTests;

import com.endava.shopbe.entity.Role;
import com.endava.shopbe.entity.User;
import com.endava.shopbe.repository.RoleRepo;
import com.endava.shopbe.repository.UserRepo;
import com.endava.shopbe.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserTests {

    @Mock
    private UserRepo userRepo;

    private UserService userService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllUsers() {
        userService.findAllUsers();
        verify(userRepo).findAll();
    }

    @Test
    void emailIsValid() {
        String email = "nahoi.ionut@yahoo.com";

        boolean isValid = userService.emailIsValid(email);

        Assertions.assertThat(isValid).isTrue();
    }

    public Role createRole() {
        return Role.builder()
                .id(130L)
                .name("USER").build();
    }

    @Test
    void saveUserTest() throws Exception {
        User user = User.builder()
                .username("testam123")
                .password("facemteste")
                .email("emailtest@yahoo.com")
                .role(createRole())
                .build();

        userService.save(user);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepo).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        Assertions.assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void findByRoleNameTest() throws Exception {
        User user1 = new User(1L, "username1", "123456", "email@yahoo.com", createRole());
        User user2 = new User(2L, "username2", "123456", "email2@yahoo.com", new Role(21L, "ADMIN"));
        User user3 = new User(3L, "username3", "123456", "email3@yahoo.com", createRole());
        User user4 = new User(4L, "username4", "123456", "email4@yahoo.com", createRole());
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);

        List<User> repositoryResponse = userService.findAllUsersByRole("USER");

        List<User> check = userService.findAllUsers();
        List<User> expectedResponse = new ArrayList<>();
        expectedResponse.add(user1);
        expectedResponse.add(user3);
        expectedResponse.add(user4);

//        Assertions.assertThat(repositoryResponse).isEqualTo(expectedResponse);
        when(userRepo.findByRoleName("USER")).thenReturn(expectedResponse);
    }

}
