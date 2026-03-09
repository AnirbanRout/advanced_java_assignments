
package com.spring.capgemini.controller;

import java.time.LocalDate;
import java.util.List;

import com.spring.capgemini.dao.EmployeeDaoImp;
import com.spring.capgemini.entity.Employee;

public class App {

    public static void main(String[] args) {

        EmployeeDaoImp dao = new EmployeeDaoImp();

        Employee emp1 = new Employee(101, "John", "john@gmail.com", "Developer", "IT", LocalDate.of(2023, 5, 10), true);
        Employee emp2 = new Employee(102, "Alice", "alice@gmail.com", "Tester", "QA", LocalDate.of(2022, 3, 15), true);
        Employee emp3 = new Employee(103, "Bob", "bob@gmail.com", "Manager", "HR", LocalDate.of(2021, 7, 20), true);

        System.out.println(dao.addEmployee(emp1));
        System.out.println(dao.addEmployee(emp2));
        System.out.println(dao.addEmployee(emp3));

        System.out.println(dao.updateEmployee(101, "Senior Developer"));

        System.out.println(dao.getEmployeeById(1));

        System.out.println(dao.getEmployeeByEmpCode(102));

        List<Employee> list = dao.getAllEmployees();
        for (Employee e : list) {
            System.out.println(e);
        }

        System.out.println(dao.deleteEmployee(103));
    }
}