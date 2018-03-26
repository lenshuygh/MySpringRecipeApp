package com.lens.gurucourse.recipeproject.recipes.converters;

import com.lens.gurucourse.recipeproject.recipes.commands.CategoryCommand;
import com.lens.gurucourse.recipeproject.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {
    public static final Long LONG_VALUE = new Long(1L);
    public static final String DESCIPTION = "description";

    CategoryCommandToCategory converter;


    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void TestNullParameter() throws Exception{
        assertNull(converter.convert(null));

    }

    @Test
    public void TestEmptyObject() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        //given
        CategoryCommand command = new CategoryCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCIPTION);

        //when
        Category category = converter.convert(command);

        //then
        assertEquals(category.getId(),LONG_VALUE);
        assertEquals(category.getDescription(),DESCIPTION);
    }
}