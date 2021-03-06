package com.goit.gojavaonline.model.dao;

import com.goit.gojavaonline.model.Employee;

import java.util.List;

/**
 * Created by tamila on 8/22/16.
 */
public interface EmployeeDao {
    /*List<Employee> getAll();
    Employee loadById(int id);
    Employee loadByTitle(String name);
    void insertEmployee(Employee employee);
    void deleteEmployeeById(int id);*/

    void save(Employee employee);
    Employee load(Long id);
    List<Employee> findAll();
    Employee findByName(String name);
    void remove(Employee employee);
    void removeAll();

}
