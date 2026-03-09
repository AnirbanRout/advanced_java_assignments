package com.spring.capgemini.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review_table")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "emp_code")
    private int emp_code;

    @Column(name = "ratings")
    private int ratings;

    @Column(name = "review_date")
    private Date review_date;

    @Column(name = "comments")
    private String comments;

    public Review() {
    }

    public Review(int emp_code, int ratings, Date review_date, String comments) {
        this.emp_code = emp_code;
        this.ratings = ratings;
        this.review_date = review_date;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_code() {
        return emp_code;
    }

    public void setEmp_code(int emp_code) {
        this.emp_code = emp_code;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", emp_code=" + emp_code +
                ", ratings=" + ratings +
                ", review_date=" + review_date +
                ", comments='" + comments + '\'' +
                '}';
    }
}