package com.wethinkcode.co.za.swingy.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteJJDBC1 {
    public static void main (String args[])
    {
        Connection c = null;
        Statement stmt = null;

        try{
            Class.forName("org.sqlite.JDBC");

            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("open database successfully");

            stmt = c.createStatement();
            System.out.println("1");
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (1, 'Paul', 32, 'Johannesburg', 20000.00);";
            System.out.println("2");
            stmt.executeUpdate(sql);
            System.out.println("3");

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (2, 'Ice', 23, 'Durban', 25000.00);";
            System.out.println("4");
            stmt.executeUpdate(sql);
            System.out.println("5");

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                    "VALUES (3, 'Fire', 12, 'Cape-town', 20000.00);";
            System.out.println("6");
            stmt.executeUpdate(sql);
            System.out.println("7");

            stmt.close();
            c.commit();
            c.close();
        }catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records succesfully inserted");
    }
}
