package com.wethinkcode.co.za.swingy.Database;

import java.sql.*;

public class ConnectionClass {
    public Connection connectionClass(){

        Connection connect= null;

        try{
            Class.forName("org.sqlite.JDBC");
            connect=DriverManager.getConnection("jdbc:sqlite:Swingy.db");
            System.out.println("open database successfully");

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return connect;
    }
}
