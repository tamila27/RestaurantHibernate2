package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.*;
import com.goit.gojavaonline.model.dao.DishDao;
import com.goit.gojavaonline.model.dao.DishIngredientDao;
import com.goit.gojavaonline.model.dao.StorageDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tamila on 8/23/16.
 */
public class DishController {
    private DishDao dishDao;
    private StorageDao storageIngredientDao;
    private DishIngredientDao dishIngredientDao;

    @Transactional
    public void initDishes() {
        List<DishIngredient> ingredients1 = new ArrayList<>();
//        ingredients1.add();
//        ingredients1.add(IngredientHelper.convert(storageIngredientDao.getIngredientFromStorage("carrot").getIngredient()));
//        ingredients1.add(IngredientHelper.convert(storageIngredientDao.getIngredientFromStorage("rice").getIngredient()));
//        ingredients1.add(IngredientHelper.convert(storageIngredientDao.getIngredientFromStorage("oil").getIngredient()));
//        ingredients1.add(IngredientHelper.convert(storageIngredientDao.getIngredientFromStorage("onion").getIngredient()));

        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN_DISH);
        plov.setPrice(5.0F);
        plov.setWeight(300F);

        dishDao.save(plov);
        addDishIngredient(plov, "meat", 5);
        addDishIngredient(plov, "rice", 5);
        addDishIngredient(plov, "carrot", 5);
        addDishIngredient(plov, "oil", 1);
        addDishIngredient(plov, "onion", 2);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(DishCategory.SNACK);
        salad.setPrice(2.0F);
        salad.setWeight(100F);

        dishDao.save(salad);
        addDishIngredient(salad, "tomato", 10);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.MAIN_DISH);
        potato.setPrice(3.0F);
        potato.setWeight(200F);

        dishDao.save(potato);
        addDishIngredient(potato, "potato", 3);

    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    @Transactional
    public void deleteDish(Dish dish) {
        dishDao.deleteDish(dish);
    }

    @Transactional
    public void removeAll() {
        dishIngredientDao.removeAll();
        dishDao.removeAll();
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setStorageIngredientDao(StorageDao storageIngredientDao) {
        this.storageIngredientDao = storageIngredientDao;
    }

    public void setDishIngredientDao(DishIngredientDao dishIngredientDao) {
        this.dishIngredientDao = dishIngredientDao;
    }

    private void addDishIngredient(Dish dish, String ingredientName, Integer quantity) {
        IngredientsStorage ingredientFromStorage = storageIngredientDao.getIngredientFromStorage(ingredientName);
        if (ingredientFromStorage == null) {
            throw new IllegalStateException("Database has no the requested ingredient [" + ingredientName + "]");
        }
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setIngredient(ingredientFromStorage.getIngredient());
        dishIngredient.setDish(dish);
        dishIngredient.setQuantity(quantity);

        dishIngredientDao.save(dishIngredient);
    }
}
