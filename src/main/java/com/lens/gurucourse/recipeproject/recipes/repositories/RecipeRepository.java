package com.lens.gurucourse.recipeproject.recipes.repositories;

import com.lens.gurucourse.recipeproject.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
}
