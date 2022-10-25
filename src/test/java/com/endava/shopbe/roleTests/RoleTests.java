package com.endava.shopbe.roleTests;

import com.endava.shopbe.entity.Role;
import com.endava.shopbe.repository.RoleRepo;
import com.endava.shopbe.service.RoleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoleTests {

    @Mock
    private RoleRepo roleRepo;

    private RoleService roleService;

    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        roleService = new RoleService(roleRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void createRole() {
        Role rol = Role.builder()
                .name("ADMIN").build();
        roleRepo.save(rol);

        ArgumentCaptor<Role> roleArgumentCaptor = ArgumentCaptor.forClass(Role.class);
        verify(roleRepo).save(roleArgumentCaptor.capture());

        Role capturedRole = roleArgumentCaptor.getValue();
        Assertions.assertThat(capturedRole).isEqualTo(rol);
    }


    @Test
    void DeleteRole() {
        Role rol = Role.builder()
                .name("ADMIN").build();
        roleRepo.save(rol);

        roleRepo.delete(rol);
        Assertions.assertThat(roleRepo.findRoleByName("ADMIN")).isNull();

    }

    @Test
    @Disabled("folosim h2")
    void getRoleByName() {
        Assertions.assertThat(roleRepo.findRoleByName("USER")).isNotNull();
    }

    @Test
    void checkIfRoleExists() {
        Assertions.assertThat(Assertions.assertThat(roleRepo.findRoleByName("ADMIN"))).isNotNull();
    }


}
