package com.spring.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.spring.capgemini.entity.Review;

public class ReviewDaoImp implements ReviewDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-unit");

    @Override
    public void insertReview(Review review) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();
            entityManager.persist(review);
            entityTransaction.commit();

        }

        catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
                System.out.println("failed to add review...");
            }
            e.printStackTrace();
        }

        finally {
            entityManager.close();
        }

    }

    @Override
    public void updateReview(int id, String comment) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();

            Review review = entityManager.find(Review.class, id);

            if (review != null) {
                review.setComments(comment);
                entityTransaction.commit();
            }

            else {
                System.out.println("no review found with this id...");
            }

        }

        catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
                System.out.println("error updating review...");
            }

            e.printStackTrace();
        }

        finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteReview(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {

            entityTransaction.begin();

            Review review = entityManager.find(Review.class, id);
            if (review != null) {
                entityManager.remove(review);
                entityTransaction.commit();
                System.out.println("review successfully deleted...");
            }

            else {
                System.out.println("no review found with this id...");
            }

        }

        catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
                System.out.println("failed to delete review...");
            }
            e.printStackTrace();
        }

        finally {
            entityManager.close();
        }
    }

    @Override
    public void fetchAllReviews(int emp_code) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            String query = "SELECT r FROM Review r WHERE r.emp_code=:emp_code";
            TypedQuery<Review> q = entityManager.createQuery(query, Review.class);
            q.setParameter("emp_code", emp_code);

            List<Review> review = q.getResultList();

            if (!review.isEmpty()) {

                for (Review r : review) {
                    System.out.println(r);
                }

            }

            else {
                System.out.println("no reviews found with this emp code...");
            }

        }

        catch (Exception e) {
            System.out.println("error fetching reviews...");
            e.printStackTrace();
        }

        finally {
            entityManager.close();
        }
    }

}
