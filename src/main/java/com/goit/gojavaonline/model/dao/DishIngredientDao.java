package com.goit.gojavaonline.model.dao;

import com.goit.gojavaonline.model.DishIngredient;

import java.util.List;

/**
 * Created by tamila on 9/12/16.
 */
public interface DishIngredientDao {
    void save(DishIngredient dishIngredient);
    void delete(int ingredientId, int dishId);
    List<DishIngredient> getIngredientsByDishName(String dish);

    void removeAll();
}
