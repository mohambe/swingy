package com.wethinkcode.co.za.swingy;

import com.wethinkcode.co.za.swingy.Database.ConnectionClass;

import java.sql.*;


public class Main{
    public static void main(String[] args)
    {
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();

//        try {
//            //table creation
//            stmt = connect.createStatement();
//            String sql = "CREATE TABLE IF NOT EXISTS HEROS " +
//                    "(ID INT PRIMARY KEY    NOT NULL," +
//                    " NAME      TEXT    NOT NULL," +
//                    "CLAN_NAME   TEXT  NOT NULL," +
//                    "HEALTH     INT NOT NULL," +
//                    "DAMAGE     INT  NOT NULL)";
//            stmt.executeUpdate(sql);
//            stmt.close();
//
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Hero table created successfully");
//
//
//        try{
//            //Insertion of hero information
//            connect.setAutoCommit(false);
//            stmt = connect.createStatement();
//            System.out.println("1");
//            String sql = "INSERT INTO HEROS (ID,NAME,CLAN_NAME,HEALTH,DAMAGE) " +
//                    "VALUES (2, 'King', 'pirate', 110, 30);";
//            System.out.println("2");
//            stmt.executeUpdate(sql);
//            System.out.println("3");
//
//            stmt.close();
//            connect.commit();
//
//        }catch(Exception e)
//        {
//            System.out.println("Error: " + e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Records succesfully inserted");

        try{

            connect.setAutoCommit(false);


            stmt = connect.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM HEROS WHERE ID = 2;");

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name =rs.getString("name");
                String clan_name =rs.getString("clan_name");
                int health = rs.getInt("health");
                int damage = rs.getInt("damage");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "CLAN_NAME = " + clan_name );
                System.out.println( "HEALTH = " + health );
                System.out.println( "DAMAGE = " + damage );
                System.out.println();
            }
            rs.close();
            stmt.close();
            connect.close();
        }catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
 }

