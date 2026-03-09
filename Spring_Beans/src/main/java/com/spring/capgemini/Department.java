
package com.spring.capgemini;

public class Department {

    private int deptid;
    private String deptname;

    // No-args constructor
    public Department() {
    }

    // All-args constructor
    public Department(int deptid, String deptname) {
        this.deptid = deptid;
        this.deptname = deptname;
    }

    // Getter and Setter for deptid
    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    // Getter and Setter for deptname
    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    // toString method
    @Override
    public String toString() {
        return "Department{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}