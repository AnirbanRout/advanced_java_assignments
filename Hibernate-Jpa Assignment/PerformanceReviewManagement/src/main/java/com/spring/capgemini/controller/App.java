
package com.spring.capgemini.controller;

import java.sql.Date;
import com.spring.capgemini.dao.ReviewDaoImp;
import com.spring.capgemini.entity.Review;

public class App {

    public static void main(String[] args) {

        ReviewDaoImp reviewDao = new ReviewDaoImp();

        Review r1 = new Review(101, 5, Date.valueOf("2026-03-01"), "Excellent performance");
        Review r2 = new Review(102, 4, Date.valueOf("2026-03-02"), "Good job overall");
        Review r3 = new Review(103, 3, Date.valueOf("2026-03-03"), "Average performance");
        Review r4 = new Review(101, 2, Date.valueOf("2026-03-04"), "Needs improvement");
        Review r5 = new Review(104, 5, Date.valueOf("2026-03-05"), "Outstanding work");

        reviewDao.insertReview(r1);
        reviewDao.insertReview(r2);
        reviewDao.insertReview(r3);
        reviewDao.insertReview(r4);
        reviewDao.insertReview(r5);

        System.out.println("\n--- Fetch all reviews for emp_code 101 ---");
        reviewDao.fetchAllReviews(101);

        System.out.println("\n--- Update review with id 3 ---");
        reviewDao.updateReview(3, "Improved performance after training");

        System.out.println("\n--- Fetch all reviews for emp_code 103 ---");
        reviewDao.fetchAllReviews(103);

        System.out.println("\n--- Delete review with id 4 ---");
        reviewDao.deleteReview(4);

        System.out.println("\n--- Fetch all reviews for emp_code 101 after deletion ---");
        reviewDao.fetchAllReviews(101);
    }
}