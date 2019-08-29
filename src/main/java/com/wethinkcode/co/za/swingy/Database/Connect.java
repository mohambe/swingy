package com.wethinkcode.co.za.swingy.Database;
import  java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Connect {

//    Connect to a sample database
    public static void connect()
    {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            //db parameters
            String url = "jdbc:sqlite:myDB.sqlite";

            //create a connection to the database

            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been establish");
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }


    //@param args the command line arguments
//    public static void main(String[] args){
//        connect();
//    }
}


