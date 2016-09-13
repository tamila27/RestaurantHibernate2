package com.goit.gojavaonline.model.dao;

import com.goit.gojavaonline.model.Dish;

import java.util.List;

/**
 * Created by tamila on 8/23/16.
 */
public interface DishDao {
    /*void insertDish(Dish dish);
    void deleteDish(int id);
    Dish findByName(String name);
    List<Dish> getAll();*/

    void save(Dish dish);
    List<Dish> findAll();
    Dish findByName(String name);
    void deleteDish(Dish dish);
    void removeAll();
}
