package com.lens.gurucourse.recipeproject.recipes.controllers;

import com.lens.gurucourse.recipeproject.recipes.commands.IngredientCommand;
import com.lens.gurucourse.recipeproject.recipes.services.IngredientService;
import com.lens.gurucourse.recipeproject.recipes.services.RecipeService;
import com.lens.gurucourse.recipeproject.recipes.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {
    RecipeService recipeService;

    IngredientService ingredientService;

    UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService,IngredientService ingredientService,UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping("/recipe/{id}/ingredients")
    public String getIngredients(@PathVariable String id, Model model){
        log.debug("Getting ingredient list for recipe id: " + id);

        //use command obj to avoid lazy load errors in thymeleaf
        model.addAttribute("recipe",recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,@PathVariable String id,Model model){
        model.addAttribute("ingredient",ingredientService.findByRecipeIdAndId(new Long(recipeId),new Long(id)));

        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,@PathVariable String id, Model model){
        model.addAttribute("ingredient",ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId),Long.valueOf(id)));
        model.addAttribute("uomList",unitOfMeasureService.listAllUoms());

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping
    @RequestMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved recipe idd: " + savedCommand.getRecipeId());
        log.debug("saved ingredient id: " + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}
