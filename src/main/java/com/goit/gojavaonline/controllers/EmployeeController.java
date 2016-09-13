package com.goit.gojavaonline.controllers;

import com.goit.gojavaonline.model.Cook;
import com.goit.gojavaonline.model.Employee;
import com.goit.gojavaonline.model.Position;
import com.goit.gojavaonline.model.Waiter;
import com.goit.gojavaonline.model.dao.EmployeeDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tamila on 8/22/16.
 */
public class EmployeeController {
    private EmployeeDao employeeDao;

    @Transactional
    public void initEmployee() {
        Waiter john = new Waiter();
        john.setName("John");
        john.setLastName("Smith");
        john.setPosition(Position.WAITER);
        john.setPhone("0987654321");
        john.setSalary(10000.00F);
        employeeDao.save(john);

        Waiter mary = new Waiter();
        mary.setName("Mary");
        mary.setLastName("Smith");
        mary.setPhone("555-55-55");
        mary.setPosition(Position.WAITER);
        mary.setSalary(25000.0F);
        employeeDao.save(mary);

        Cook alan = new Cook();
        alan.setName("Alan");
        alan.setLastName("Johnson");
        alan.setPosition(Position.COOK);
        alan.setPhone("111-11-11");
        alan.setSalary(100.00F);
        employeeDao.save(alan);
    }

    @Transactional
    public void createEmployee() {
        /*Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();
        employee.setName("John");
        employee.setLastName("Smith");
        employee.setPosition();
        employee.setPhone("0987654321");
        employee.setSalary(10000.00F);

        if(!allEmployees.contains(employee)){
            employeeDao.save(employee);
        }*/
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Transactional
    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Transactional
    public void removeAll() {
        employeeDao.removeAll();
    }

    @Transactional
    public void printEmployee(Long id) {
        System.out.println(employeeDao.load(id));
    }

    @Transactional
    public void printAllEmployees() {
        employeeDao.findAll().forEach(System.out::println);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
