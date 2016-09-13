package com.goit.gojavaonline;

import com.goit.gojavaonline.controllers.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tamila on 9/5/16.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrdersController orderController;
    private StorageController storageController;
    private PreparedDishController preparedDishController;
    private MenuController menuController;
    private IngredientController ingredientController;

    private boolean reInit;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        context.getBean(Main.class).start();
    }

    public void init() {
        if (reInit) {
            preparedDishController.removeAll();
            orderController.removeAll();
            dishController.removeAll();
            employeeController.removeAll();
            storageController.removeAll();
            ingredientController.removeAll();

            ingredientController.initIngredients();
            storageController.initStorage();
            employeeController.initEmployee();
            dishController.initDishes();
            orderController.initOrders();
            preparedDishController.initPreparedDishes();
        }
    }

    public void start() {
        employeeController.printEmployee(3L);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    public void setOrderController(OrdersController orderController) {
        this.orderController = orderController;
    }

    public void setStorageController(StorageController storageController) {
        this.storageController = storageController;
    }

    public void setPreparedDishController(PreparedDishController preparedDishController) {
        this.preparedDishController = preparedDishController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setIngredientController(IngredientController ingredientController) {
        this.ingredientController = ingredientController;
    }

    public void setReInit(boolean reInit) {
        this.reInit = reInit;
    }

}
