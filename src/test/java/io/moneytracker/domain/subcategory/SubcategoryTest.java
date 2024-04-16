package io.moneytracker.domain.subcategory;

import io.moneytracker.domain.category.model.Category;
import io.moneytracker.domain.subcategory.model.Subcategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubcategoryTest {
    private Category category;
    private Subcategory subcategory;

    @BeforeEach
    public void setUp(){
        category = new Category();
        subcategory = new Subcategory();
    }

    @Test
    public void setParentCategoryToANewSubcategory(){
        subcategory.setParentCategory(category);
        assertEquals(category, subcategory.getParentCategory());
    }
}
