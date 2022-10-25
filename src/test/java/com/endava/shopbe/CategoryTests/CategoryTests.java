package com.endava.shopbe.CategoryTests;

import com.endava.shopbe.entity.Category;
import com.endava.shopbe.repository.CategoryRepo;
import com.endava.shopbe.service.CategoryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryTests {

    @Mock
    private CategoryRepo categoryRepo;

    private CategoryService categoryService;

    private AutoCloseable autoCloseable;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        categoryService = new CategoryService(categoryRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void SaveCategoryTest() {
        Category category = Category.builder()
                .productCategory("Electrocasnice")
                .build();

//        Category category2 = Category.builder()
//                .productCategory("TV")
//                .build();

        categoryService.save(category);
        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepo).save(categoryArgumentCaptor.capture());

        Category capturedCategory = categoryArgumentCaptor.getValue();
        Assertions.assertThat(capturedCategory).isEqualTo(category);
    }

    @Test
    @Disabled
    void findByIdTest() {
        Category category = Category.builder()
                .id(1L)
                .productCategory("Electrocasnice")
                .build();
        categoryService.save(category);

//        verify(categoryRepo).findById(1L);
//        when((Publisher<?>) categoryService.findById(1L)).thenReturn(Collections.singleton(category));
        Mockito.when(categoryRepo.findAll()).thenReturn(Collections.singletonList(category));
    }

    @Test
    void getAllCategorisTest() {
        categoryService.findAll();
        verify(categoryRepo).findAll();
    }
}
