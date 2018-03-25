package com.lens.gurucourse.recipeproject.recipes.repositories;

import com.lens.gurucourse.recipeproject.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setup() throws Exception{

    }

    @Test
    //@DirtiesContext //<= to start next test with a fresh context, so a restart of spring context
    public void findByDescription() {

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon",unitOfMeasureOptional.get().getDescription());

    }

    @Test
    public void findByDescriptionCup() {

        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cups");

        assertEquals("Cups",unitOfMeasureOptional.get().getDescription());

    }
}