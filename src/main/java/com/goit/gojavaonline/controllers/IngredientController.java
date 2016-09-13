package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.Ingredient;
import com.goit.gojavaonline.model.dao.IngredientDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tamila on 9/9/16.
 */
public class IngredientController {
    private IngredientDao ingredientDao;

    @Transactional
    public void removeAll() {
        ingredientDao.removeAll();
    }

    @Transactional
    public void initIngredients() {
        Ingredient carrot = new Ingredient();
        carrot.setTitle("carrot");

        Ingredient meat = new Ingredient();
        meat.setTitle("meat");

        Ingredient onion = new Ingredient();
        onion.setTitle("onion");

        Ingredient rice = new Ingredient();
        rice.setTitle("rice");

        Ingredient oil = new Ingredient();
        oil.setTitle("oil");

        Ingredient tomato = new Ingredient();
        tomato.setTitle("tomato");

        Ingredient potato = new Ingredient();
        potato.setTitle("potato");

        ingredientDao.save(carrot);
        ingredientDao.save(meat);
        ingredientDao.save(onion);
        ingredientDao.save(rice);
        ingredientDao.save(oil);
        ingredientDao.save(tomato);
        ingredientDao.save(potato);
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
