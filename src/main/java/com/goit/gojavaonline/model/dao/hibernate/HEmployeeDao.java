package com.goit.gojavaonline.model.dao.hibernate;

import com.goit.gojavaonline.model.Employee;
import com.goit.gojavaonline.model.dao.EmployeeDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tamila on 8/29/16.
 */
public class HEmployeeDao implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional
    public Employee load(Long id) {
        Employee result = sessionFactory.getCurrentSession().load(Employee.class, id);
        if(result == null) {
            throw new RuntimeException("Cannot find Employee by id: "+ id);
        }
        return result;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e").list(); //select * from EMPLOYEE
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.name like :name");
        query.setParameter("name", name);

        return (Employee)query.uniqueResult();
    }

    @Override
    @Transactional
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Employee").executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
