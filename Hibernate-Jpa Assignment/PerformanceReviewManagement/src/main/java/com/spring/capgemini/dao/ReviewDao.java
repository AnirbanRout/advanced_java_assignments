package com.spring.capgemini.dao;

import com.spring.capgemini.entity.Review;

interface ReviewDao {

    void insertReview(Review review);

    void updateReview(int id, String comment);

    void deleteReview(int id);

    void fetchAllReviews(int emp_code);

}
