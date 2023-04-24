package databaseconnectivity;

import java.sql.*;

public class CreateDatabaseClass {
    public void dbConnectivityMethod() {
        String url = "jdbc:mysql://localhost/";
        String dbName = "mydb";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "benji";
        String password = "123";

        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);

            Statement stmt = conn.createStatement();

            String sql;

            sql = "CREATE SCHEMA myUserDetails2";
            stmt.executeUpdate(sql);

            sql = "USE myUserDetails2";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE userDetails " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            System.out.println("Database created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

