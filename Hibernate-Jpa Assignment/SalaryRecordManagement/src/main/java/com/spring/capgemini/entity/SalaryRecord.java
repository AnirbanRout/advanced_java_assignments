package com.spring.capgemini.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "salary_record")
public class SalaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "emp_code")
    private int emp_code;

    @Column(name = "base_salary")
    private double baseSalary;

    @Column(name = "bonus")
    private double bonus;

    @Column(name = "tax")
    private double tax;

    @Column(name = "net_salary")
    private double netSalary;

    @Column(name = "salary_month")
    private String salaryMonth;

    public SalaryRecord() {
    }

    public SalaryRecord(int id, int emp_code, double baseSalary, double bonus, double tax, double netSalary,
            String salaryMonth) {
        this.id = id;
        this.emp_code = emp_code;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.tax = tax;
        this.netSalary = netSalary;
        this.salaryMonth = salaryMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeCode() {
        return emp_code;
    }

    public void setEmployeeCode(int emp_code) {
        this.emp_code = emp_code;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    @Override
    public String toString() {
        return "Salary [id=" + id
                + ", employeeCode=" + emp_code
                + ", baseSalary=" + baseSalary
                + ", bonus=" + bonus
                + ", tax=" + tax
                + ", netSalary=" + netSalary
                + ", salaryMonth=" + salaryMonth
                + "]";
    }
}