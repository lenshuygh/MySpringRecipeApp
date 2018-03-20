package com.lens.gurucourse.recipeproject.recipes.controllers;

import com.lens.gurucourse.recipeproject.recipes.domain.Category;
import com.lens.gurucourse.recipeproject.recipes.domain.UnitOfMeasure;
import com.lens.gurucourse.recipeproject.recipes.repositories.CategoryRepository;
import com.lens.gurucourse.recipeproject.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository,UnitOfMeasureRepository unitOfMeasureRepository){
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is:"+ categoryOptional.get().getId());
        System.out.println("UOM Id is:"+ unitOfMeasureOptional.get().getId());

        return "index";
    }

}
