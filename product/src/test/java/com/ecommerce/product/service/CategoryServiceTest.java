package com.ecommerce.product.service;

import com.ecommerce.product.dto.CategoryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void listWithTree() {
        List<CategoryDto> categoryDtoList = categoryService.listWithTree();
        for (CategoryDto parent : categoryDtoList) {
            for (CategoryDto child : parent.getChildren()) {
                assert child.getParentCid().equals(parent.getCatId());
            }
        }
    }
}
