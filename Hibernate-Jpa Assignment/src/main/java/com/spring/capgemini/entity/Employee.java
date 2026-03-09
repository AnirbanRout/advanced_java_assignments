
package com.spring.capgemini.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "emp_demo")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int id;

    @Column(unique = true, name = "emp_code")
    private int empcode;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "designation")
    private String designation;

    @Column(name = "department")
    private String department;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "active_status")
    private boolean active;

    // No Argument Constructor
    public Employee() {
    }

    // All Argument Constructor
    public Employee(int empcode, String name, String email,
            String designation, String department,
            LocalDate joiningDate, boolean active) {
        this.empcode = empcode;
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.department = department;
        this.joiningDate = joiningDate;
        this.active = active;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpCode() {
        return empcode;
    }

    public void setEmpCode(int employeeCode) {
        this.empcode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // toString Method
    @Override
    public String toString() {
        return "Employee [id=" + id +
                ", employeeCode=" + empcode +
                ", name=" + name +
                ", email=" + email +
                ", designation=" + designation +
                ", department=" + department +
                ", joiningDate=" + joiningDate +
                ", active=" + active + "]";
    }
}