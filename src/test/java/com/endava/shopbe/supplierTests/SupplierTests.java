package com.endava.shopbe.supplierTests;

import com.endava.shopbe.entity.Supplier;
import com.endava.shopbe.repository.SupplierRepo;
import com.endava.shopbe.service.SupplierService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SupplierTests {

    @Mock
    private SupplierRepo supplierRepo;

    private SupplierService supplierService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        supplierService = new SupplierService(supplierRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void saveSupplierTest() {
        Supplier supplier = Supplier.builder()
                .companyName("Apple")
                .build();
        supplierService.save(supplier);
        ArgumentCaptor<Supplier> supplierArgumentCaptor = ArgumentCaptor.forClass(Supplier.class);
        verify(supplierRepo).save(supplierArgumentCaptor.capture());

        Supplier capturedSupplier = supplierArgumentCaptor.getValue();
        Assertions.assertThat(capturedSupplier).isEqualTo(supplier);
    }

    @Test
    void getAllSuppliers() {
        supplierService.findAll();
        verify(supplierRepo).findAll();
    }
}
