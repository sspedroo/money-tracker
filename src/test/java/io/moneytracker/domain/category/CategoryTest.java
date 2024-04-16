package io.moneytracker.domain.category;

import io.moneytracker.domain.category.model.Category;
import io.moneytracker.domain.subcategory.model.Subcategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CategoryTest {
    private Category category;


    @BeforeEach
    public void setUp(){
        category = new Category();
    }

    @Test
    public void setName(){
        category.setName("Food");
        assertEquals("Food", category.getName());
    }

    @Test
    public void addSubcategoryInCategorySubcategorySet(){
        Set<Subcategory> subcategories = category.getSubcategories();
        subcategories.add(mock(Subcategory.class));
        assertFalse(category.getSubcategories().isEmpty());
    }

    @Test
    public void removeSubcategoryInCategorySubcategorySet(){
        Set<Subcategory> subcategories = category.getSubcategories();
        Subcategory mock1 = mock(Subcategory.class);
        Subcategory mock2 = mock(Subcategory.class);

        subcategories.add(mock1);
        subcategories.add(mock2);
        subcategories.remove(mock1);

        assertEquals( 1, category.getSubcategories().size());
        assertFalse(category.getSubcategories().contains(mock1));
    }

//    @Test
//    public void createCategoryWithExistingName(){
//        category.setName("Food");
//        Category newCategory = new Category();
//
//        newCategory.getSubcategories().add(mock(Subcategory.class));
//        newCategory.setName("Food");
//        assertThrows(IllegalArgumentException.class, () -> new Category(newCategory.getName(), newCategory.getSubcategories()));
//    }
}
