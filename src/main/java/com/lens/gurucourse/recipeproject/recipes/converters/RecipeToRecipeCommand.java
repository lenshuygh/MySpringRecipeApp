package com.lens.gurucourse.recipeproject.recipes.converters;

import com.lens.gurucourse.recipeproject.recipes.commands.RecipeCommand;
import com.lens.gurucourse.recipeproject.recipes.domain.Category;
import com.lens.gurucourse.recipeproject.recipes.domain.Ingredient;
import com.lens.gurucourse.recipeproject.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe,RecipeCommand>{
    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final NotesToNotesCommand notesToNotesCommand;

    public RecipeToRecipeCommand(CategoryToCategoryCommand caegoryConverter, IngredientToIngredientCommand ingredientToIngredientCommand, NotesToNotesCommand notesToNoteCommand) {
        this.categoryConverter = caegoryConverter;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.notesToNotesCommand = notesToNoteCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if(source == null) {
            return null;
        }

        final RecipeCommand command = new RecipeCommand();
        command.setId(source.getId());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setDescription(source.getDescription());
        command.setDifficulty(source.getDifficulty());
        command.setDirections(source.getDirections());
        command.setServings(source.getServings());
        command.setSource(source.getSources());
        command.setUrl(source.getUrl());
        command.setImage(source.getImage());
        command.setNotes(notesToNotesCommand.convert(source.getNotes()));

        if(source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach((Category category) -> command.getCategories().add(categoryConverter.convert(category)));
        }

        if(source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach((Ingredient ingredient) -> command.getIngredients().add(ingredientToIngredientCommand.convert(ingredient)));
        }

        return command;

    }
}
