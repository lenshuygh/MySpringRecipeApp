package com.lens.gurucourse.recipeproject.recipes.controllers;

import com.lens.gurucourse.recipeproject.recipes.repositories.RecipeRepository;
import com.lens.gurucourse.recipeproject.recipes.services.RecipeService;
import com.lens.gurucourse.recipeproject.recipes.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        //verify that the returned string is 'index'
        String viewName = controller.getIndexPage(model);
        assertEquals("index",viewName);

        //check interactions with service and model
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
    }
}