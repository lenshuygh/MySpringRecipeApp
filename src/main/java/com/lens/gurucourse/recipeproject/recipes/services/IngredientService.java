package com.lens.gurucourse.recipeproject.recipes.services;

import com.lens.gurucourse.recipeproject.recipes.commands.IngredientCommand;

public interface IngredientService {
    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long ingredientId);

    public IngredientCommand saveIngredientCommand(IngredientCommand command);

    public void deleteById(Long recipeId,Long ingredientId);
}
