package com.wethinkcode.co.za.swingy.Database;
import java.sql.*;

public class SQLiteJJDBC {
    public static void main (String args[])
    {
        Connection c = null;
        Statement stmt = null;

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("open database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS COMPANY " +
                    "(ID INT PRIMARY KEY   NOT NULL," +
                    " NAME          TEXT    NOT NULL," +
                    " AGE            INT    NOT NULL," +
                    "ADDRESS        CHAR(30),"+
                    "SALARY         REAL)";
            System.out.println("1");
            stmt.executeUpdate(sql);
            System.out.println("2");
            stmt.close();
            c.close();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}
