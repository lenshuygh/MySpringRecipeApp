package com.lens.gurucourse.recipeproject.recipes.converters;

import com.lens.gurucourse.recipeproject.recipes.commands.UnitOfMeasureCommand;
import com.lens.gurucourse.recipeproject.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void TestNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void TestEmptyObject() throws Exception{
        assertNotNull(new UnitOfMeasureCommand());
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE,uom.getId());
        assertEquals(DESCRIPTION,uom.getDescription());
    }
}