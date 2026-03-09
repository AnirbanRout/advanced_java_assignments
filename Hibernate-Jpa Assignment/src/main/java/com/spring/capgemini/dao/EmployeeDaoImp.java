package com.spring.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.spring.capgemini.entity.Employee;

public class EmployeeDaoImp implements EmployeeDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-unit");

    @Override
    public String addEmployee(Employee employee) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
            entityManager.close();

        }

        catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
                entityManager.close();
                return "failed to add employee data";
            }
        }

        entityManager.close();
        return "employee successfully added...";
    }

    @Override
    public String updateEmployee(int emp_code, String designation) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            String query = "SELECT e FROM Employee e WHERE e.empcode=:emp_code";
            TypedQuery<Employee> q = entityManager.createQuery(query, Employee.class);
            q.setParameter("emp_code", emp_code);

            Employee employee = q.getSingleResult();

            entityTransaction.begin();
            employee.setDesignation(designation);
            entityManager.merge(employee);
            entityTransaction.commit();

            entityManager.close();
            return "employee data updated successfully...";

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
                entityManager.close();
            }
        }

        entityManager.close();
        return "failed to update employee...";

    }

    @Override
    public String deleteEmployee(int emp_code) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();

            String query = "SELECT e FROM Employee e WHERE e.empcode=:emp_code";
            TypedQuery<Employee> q = entityManager.createQuery(query, Employee.class);
            q.setParameter("emp_code", emp_code);

            Employee employee = q.getSingleResult();

            if (employee != null) {
                entityManager.remove(employee);
                entityTransaction.commit();

                entityManager.close();
                return "employee data deleted...";
            }

            entityManager.close();

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
                entityManager.close();
            }
        }

        entityManager.close();
        return "failed to delete employee data...";

    }

    @Override
    public String getEmployeeById(int emp_id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, emp_id);

        if (employee != null) {
            System.out.println(employee);
            entityManager.close();
            return "employee found...";
        }

        entityManager.close();

        return "no employee found with this id...";

    }

    @Override
    public String getEmployeeByEmpCode(int emp_code) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String query = "SELECT e FROM Employee e WHERE e.empcode=:emp_code";
        TypedQuery<Employee> q = entityManager.createQuery(query, Employee.class);
        q.setParameter("emp_code", emp_code);

        try {
            Employee employee = q.getSingleResult();
            entityManager.close();
            if (employee != null) {
                System.out.println(employee);
                return "employee found...";
            }
        }

        catch (Exception e) {
            entityManager.close();
        }

        return "no employee found with this emp_code";

    }

    @Override
    public List<Employee> getAllEmployees() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String query = "SELECT e FROM Employee e";
        TypedQuery<Employee> q = entityManager.createQuery(query, Employee.class);

        List<Employee> emplist = q.getResultList();
        entityManager.close();

        return emplist;

    }

}
