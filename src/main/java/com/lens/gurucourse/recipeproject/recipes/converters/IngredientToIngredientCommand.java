package com.lens.gurucourse.recipeproject.recipes.converters;

import com.lens.gurucourse.recipeproject.recipes.commands.CategoryCommand;
import com.lens.gurucourse.recipeproject.recipes.commands.IngredientCommand;
import com.lens.gurucourse.recipeproject.recipes.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient,IngredientCommand>{

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        final IngredientCommand command = new IngredientCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        command.setAmount(source.getAmount());
        command.setUnitOfMeasure(uomConverter.convert(source.getUom()));

        return command;
    }
}
