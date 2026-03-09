
package com.jdbc.proj.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn_class {

    public Connection createConnection() {

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/jdbc_demo";
            String username = "postgres";
            String password = "lime12";

            Connection cn = DriverManager.getConnection(url, username, password);

            if (cn != null)
                return cn;
        }

        catch (ClassNotFoundException e) {
            System.out.println("postgresql server error...");
            e.printStackTrace();
        }

        catch (SQLException e) {
            System.out.println("sql error...");
            e.printStackTrace();
        }

        return null;

    }
}
