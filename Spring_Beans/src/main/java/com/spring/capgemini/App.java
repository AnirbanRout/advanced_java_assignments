package com.spring.capgemini;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        System.out.println();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Bean-config.xml");
        User user = applicationContext.getBean("userobj", User.class);
        Department department = applicationContext.getBean("dept_bean", Department.class);

        System.out.println(user);
        System.out.println(department);

        System.out.println();

        Employee employee = applicationContext.getBean("emp_bean", Employee.class);
        System.out.println(employee);

        System.out.println();

    }

}
