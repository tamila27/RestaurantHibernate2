package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.Ingredient;
import com.goit.gojavaonline.model.IngredientsStorage;
import com.goit.gojavaonline.model.dao.IngredientDao;
import com.goit.gojavaonline.model.dao.StorageDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tamila on 8/24/16.
 */
public class StorageController {
    private StorageDao storageDao;
    private IngredientDao ingredientDao;

    @Transactional
    public void insertIngredientToStorage(IngredientsStorage ingredientsStorage) {
        storageDao.insertIngredientToStorage(ingredientsStorage);
    }

    @Transactional
    public void deleteIngredientFromStorage(int id) {
        storageDao.deleteIngredientFromStorage(id);
    }

    @Transactional
    public void changeIngredientQuantity(int id, float newQuantity) {
        storageDao.changeIngredientQuantity(id, newQuantity);
    }

    @Transactional
    public IngredientsStorage getIngredientFromStorage(String name) {
        return storageDao.getIngredientFromStorage(name);
    }

    @Transactional
    public List<IngredientsStorage> getAll() {
        return storageDao.getAll();
    }

    @Transactional
    public Ingredient getIngredientByName(String name) {
        return storageDao.getIngredientByName(name);
    }

    @Transactional
    public void initStorage() {
        List<Ingredient> ingredients = ingredientDao.getAll();
        ingredients.forEach(ingredient -> {
            IngredientsStorage ingredientsStorage = new IngredientsStorage();
            ingredientsStorage.setIngredient(ingredient);
            ingredientsStorage.setQuantity((float)Math.random()*100);
            storageDao.insertIngredientToStorage(ingredientsStorage);
        });
    }

    @Transactional
    public void removeAll() {
        storageDao.removeAll();
    }

    public void setStorageDao(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
}
