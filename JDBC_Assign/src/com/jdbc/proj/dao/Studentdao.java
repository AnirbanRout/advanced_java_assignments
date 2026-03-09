package com.jdbc.proj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.proj.entity.Student;
import com.jdbc.proj.utility.Conn_class;

public class Studentdao {

    Conn_class conn_class = new Conn_class();
    Connection cn = conn_class.createConnection();

    public void createTable() {
        try {
            String tablequery = "CREATE TABLE IF NOT EXISTS student_demo("
                    + "id SERIAL PRIMARY KEY," + "name VARCHAR(100)," +
                    "email VARCHAR(100)," + "marks INT)";

            Statement st = cn.createStatement();
            st.executeUpdate(tablequery);

            System.out.println("table created successfully...");
            st.close();
        }

        catch (SQLException e) {
            System.out.println("sql error...");
            e.printStackTrace();
        }
    }

    public String addstduent(Student student) {

        try {

            String addquery = "INSERT INTO student_demo(name,email,marks) VALUES(?,?,?)";
            PreparedStatement ps = cn.prepareStatement(addquery);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getMarks());

            int rows = ps.executeUpdate();
            System.out.println(rows);

            ps.close();

            return "student added successfully...";

        }

        catch (SQLException e) {
            System.out.println("sql error...");
            e.printStackTrace();
        }

        return "student data not added successfully...";
    }

    public void getstudentbyid(int id) {

        try {

            String sql = "SELECT * FROM student_demo WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet set = ps.executeQuery();
            boolean found = false;

            while (set.next()) {
                found = true;
                int db_id = set.getInt("id");
                String db_name = set.getString("name");
                String db_email = set.getString("email");
                int db_marks = set.getInt("marks");

                System.out.println("id:" + db_id);
                System.out.println("name:" + db_name);
                System.out.println("email:" + db_email);
                System.out.println("marks:" + db_marks);
                System.out.println();
            }

            if (!found) {
                System.out.println("no student found with this id...");
            }

            ps.close();

        }

        catch (SQLException e) {
            System.out.println("sql error...");
            e.printStackTrace();
        }

    }

    public String deletestudent(int id) {

        try {
            String sql = "DELETE FROM student_demo WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            ps.close();

            if (rows == 1) {
                return "student data deleted...";
            } else {
                return "student data not deleted...";
            }
        }

        catch (SQLException e) {
            System.out.println("sql error...");
            e.printStackTrace();
        }

        return "error happened...";

    }

    public void updatestudent(int id, String email) {

        try {

            String query = "UPDATE student_demo SET email=? WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, email);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            ps.close();

            if (rows == 1) {
                System.out.println("updated successfully...");
            }

            else {
                System.out.println("not updated successfully...");
            }

        }

        catch (SQLException e) {
            System.out.println("sql error...");
            e.printStackTrace();
        }

    }

    public void getallstudents() {
        try {

            String sql = "SELECT * FROM student_demo";
            Statement ps = cn.createStatement();
            ResultSet set = ps.executeQuery(sql);

            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String email = set.getString("email");
                int marks = set.getInt("marks");

                System.out.println("id:" + id);
                System.out.println("name:" + name);
                System.out.println("email:" + email);
                System.out.println("marks:" + marks);
                System.out.println();
            }

            ps.close();

        }

        catch (SQLException e) {
            System.out.println("sql error...");
            e.printStackTrace();
        }
    }

}
