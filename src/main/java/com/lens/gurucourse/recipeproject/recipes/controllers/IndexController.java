package com.lens.gurucourse.recipeproject.recipes.controllers;

import com.lens.gurucourse.recipeproject.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        log.debug("Gettung Index Page");

        model.addAttribute("recipes",recipeService.getRecipes());

        return "index";
    }

}
