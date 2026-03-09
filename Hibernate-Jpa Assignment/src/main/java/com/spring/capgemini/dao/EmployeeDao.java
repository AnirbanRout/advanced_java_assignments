package com.spring.capgemini.dao;

import java.util.List;

import com.spring.capgemini.entity.Employee;

interface EmployeeDao {

    public String addEmployee(Employee employee);

    public String updateEmployee(int emp_code, String designation);

    public String deleteEmployee(int emp_code);

    public String getEmployeeById(int emp_id);

    public String getEmployeeByEmpCode(int emp_code);

    List<Employee> getAllEmployees();

}
