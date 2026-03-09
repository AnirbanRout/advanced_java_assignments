package com.jdbc.proj.entity;

public class Student {

    private int id;
    private String name;
    private String email;
    private int marks;

    public Student() {
    }

    public Student(String name, String email, int marks) {
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    public Student(int id, String name, String email, int marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for marks
    public int getMarks() {
        return marks;
    }

    // Setter for marks
    public void setMarks(int marks) {
        this.marks = marks;
    }
}