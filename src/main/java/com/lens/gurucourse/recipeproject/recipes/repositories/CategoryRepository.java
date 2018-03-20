package com.lens.gurucourse.recipeproject.recipes.repositories;

import com.lens.gurucourse.recipeproject.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long>{
}
