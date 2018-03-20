package com.lens.gurucourse.recipeproject.recipes.repositories;

import com.lens.gurucourse.recipeproject.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long>{
    Optional<Category> findByDescription(String description);
}
