package com.lens.gurucourse.recipeproject.recipes.services;

import com.lens.gurucourse.recipeproject.recipes.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
