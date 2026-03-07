
package com.spring.capgemini;

public class Employee {

    private int empid;
    private String empname;
    private double salary;
    private Department department;

    // No-args constructor
    public Employee() {
    }

    // All-args constructor
    public Employee(int empid, String empname, double salary, Department department) {
        this.empid = empid;
        this.empname = empname;
        this.salary = salary;
        this.department = department;
    }

    // Getter and Setter for empid
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    // Getter and Setter for empname
    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    // Getter and Setter for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter and Setter for department
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}