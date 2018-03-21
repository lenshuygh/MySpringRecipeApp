package com.lens.gurucourse.recipeproject.recipes.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, description);
    }
}
