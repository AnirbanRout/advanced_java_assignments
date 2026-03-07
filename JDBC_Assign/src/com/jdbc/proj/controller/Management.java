package com.jdbc.proj.controller;

import com.jdbc.proj.dao.Studentdao;
import com.jdbc.proj.entity.Student;

public class Management {

    public static void main(String[] args) {

        Studentdao studentdao = new Studentdao();

        // 1️⃣ create table
        studentdao.createTable();


        // 2️⃣ create 5 student objects

        Student s1 = new Student();
        s1.setName("Rahul");
        s1.setEmail("rahul@gmail.com");
        s1.setMarks(85);

        Student s2 = new Student();
        s2.setName("Aman");
        s2.setEmail("aman@gmail.com");
        s2.setMarks(78);

        Student s3 = new Student();
        s3.setName("Priya");
        s3.setEmail("priya@gmail.com");
        s3.setMarks(92);

        Student s4 = new Student();
        s4.setName("Riya");
        s4.setEmail("riya@gmail.com");
        s4.setMarks(88);

        Student s5 = new Student();
        s5.setName("Arjun");
        s5.setEmail("arjun@gmail.com");
        s5.setMarks(75);


        // 3️⃣ add students

        System.out.println(studentdao.addstduent(s1));
        System.out.println(studentdao.addstduent(s2));
        System.out.println(studentdao.addstduent(s3));
        System.out.println(studentdao.addstduent(s4));
        System.out.println(studentdao.addstduent(s5));


        // 4️⃣ get student by id

        System.out.println("----- Get Student By ID -----");
        studentdao.getstudentbyid(3);


        // 5️⃣ update student email

        System.out.println("----- Update Student -----");
        studentdao.updatestudent(2, "aman_new@gmail.com");


        // 6️⃣ delete student

        System.out.println("----- Delete Student -----");
        String msg = studentdao.deletestudent(5);
        System.out.println(msg);


        // 7️⃣ display all students

        System.out.println("----- All Students -----");
        studentdao.getallstudents();
    }
}