package com.lens.gurucourse.recipeproject.recipes.converters;

import com.lens.gurucourse.recipeproject.recipes.commands.IngredientCommand;
import com.lens.gurucourse.recipeproject.recipes.commands.UnitOfMeasureCommand;
import com.lens.gurucourse.recipeproject.recipes.domain.Ingredient;
import com.lens.gurucourse.recipeproject.recipes.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "cheeseburger";
    public static final BigDecimal AMOUNT = new BigDecimal(1);
    public static final Long UOM_ID = new Long(2L);

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    public void TestNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void TestEmptyObject() throws Exception{
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUom(unitOfMeasureCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE,ingredient.getId());
        assertEquals(AMOUNT,ingredient.getAmount());
        assertEquals(DESCRIPTION,ingredient.getDescription());
        assertEquals(UOM_ID,ingredient.getUom().getId());

    }

    @Test
    public void convertWithNullUom() throws Exception{
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE,ingredient.getId());
        assertEquals(AMOUNT,ingredient.getAmount());
        assertEquals(DESCRIPTION,ingredient.getDescription());

    }
}