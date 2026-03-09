package com.spring.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.spring.capgemini.entity.SalaryRecord;

public class SalaryDaoImp implements SalaryDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-unit");

    @Override
    public void addSalaryRecord(SalaryRecord salaryRecord) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();

            salaryRecord.setNetSalary(salaryRecord.getBaseSalary() + salaryRecord.getBonus() - salaryRecord.getTax());

            entityManager.persist(salaryRecord);
            entityTransaction.commit();

        }

        catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }

            e.printStackTrace();

        }

        finally {
            entityManager.close();
        }

    }

    @Override
    public void updateSalaryRecord(int id, double base_salary) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();

            SalaryRecord salaryRecord = entityManager.find(SalaryRecord.class, id);

            if (salaryRecord != null) {
                salaryRecord.setBaseSalary(base_salary);
            }
            entityTransaction.commit();

        }

        catch (Exception e) {

            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }

            e.printStackTrace();

        }

        finally {
            entityManager.close();
        }

    }

    @Override
    public void deleteSalaryRecord(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            SalaryRecord salaryRecord = entityManager.find(SalaryRecord.class, id);
            if (salaryRecord != null) {
                entityManager.remove(salaryRecord);
            }
            entityTransaction.commit();
        }

        catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }

        finally {
            entityManager.close();
        }

    }

    @Override
    public void getSalaryRecordByEmpCode(int emp_code) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            String query = "SELECT s FROM SalaryRecord s WHERE s.emp_code=:emp_code";
            TypedQuery<SalaryRecord> q = entityManager.createQuery(query, SalaryRecord.class);
            q.setParameter("emp_code", emp_code);

            SalaryRecord salaryRecord = q.getSingleResult();
            System.out.println(salaryRecord);

        }

        catch (NoResultException e) {
            System.out.println("no record found with this id...");
        }

        catch (Exception e) {

            System.out.println("something went wrong...");

        }

        finally {
            entityManager.close();
        }

    }

    @Override
    public void getSalaryRecordBySalaryMonth(int salaryMonth) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            String query = "SELECT s FROM SalaryRecord s WHERE s.salary_month=:salarymonth";
            TypedQuery<SalaryRecord> q = entityManager.createQuery(query, SalaryRecord.class);
            q.setParameter("salarymonth", salaryMonth);

            SalaryRecord salaryRecord = q.getSingleResult();
            System.out.println(salaryRecord);

        }

        catch (NoResultException e) {
            System.out.println("no record found with this salary month...");
        }

        catch (Exception e) {

            System.out.println("something went wrong...");

        }

        finally {
            entityManager.close();
        }

    }

    @Override
    public void fetchAllSalaryRecords(int id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            String query = "SELECT s FROM SalaryRecord s WHERE s.id=:id";
            TypedQuery<SalaryRecord> salrec = entityManager.createQuery(query, SalaryRecord.class);
            salrec.setParameter("id", id);

            List<SalaryRecord> salrecordlist = salrec.getResultList();

            for (SalaryRecord s : salrecordlist) {
                System.out.println(s);
            }

        }

        catch (Exception e) {
            System.out.println("no salary record found with this id...");
        }

        entityManager.close();

    }

}
