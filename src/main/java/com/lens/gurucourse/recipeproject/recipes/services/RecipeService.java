package com.lens.gurucourse.recipeproject.recipes.services;

import com.lens.gurucourse.recipeproject.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
