package com.lens.gurucourse.recipeproject.recipes.services;

import com.lens.gurucourse.recipeproject.recipes.commands.RecipeCommand;
import com.lens.gurucourse.recipeproject.recipes.converters.RecipeCommandToRecipe;
import com.lens.gurucourse.recipeproject.recipes.converters.RecipeToRecipeCommand;
import com.lens.gurucourse.recipeproject.recipes.domain.Recipe;
import com.lens.gurucourse.recipeproject.recipes.exceptions.NotFoundException;
import com.lens.gurucourse.recipeproject.recipes.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository,recipeCommandToRecipe,recipeToRecipeCommand);
    }

    @Test
    public void getRecipeById() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned",recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTest_NotFound() throws Exception{
        Optional<Recipe> recipeOptional = Optional.empty();

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        //this should fail
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipeSet = recipeService.getRecipes();

        assertEquals(recipeSet.size(),1);

        // verify that findAll is called exactly once !!
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() throws Exception{
        //given
        Long idToDelete = Long.valueOf(2L);

        //when
        recipeService.deleteById(idToDelete);

        //then
        //verify that recipeRepository gets called ONE time and that the deleteById gets invoked :
        verify(recipeRepository,times(1)).deleteById(anyLong());
    }

    @Test
    public void getRecipeCommandByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

        RecipeCommand commandById = recipeService.findCommandById(1L);

        assertNotNull("Null recipe returned", commandById);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}