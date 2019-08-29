package com.wethinkcode.co.za.swingy.Database;

import com.wethinkcode.co.za.swingy.HeroBuilder.HeroBuilder;
import com.wethinkcode.co.za.swingy.HeroBuilder.HeroEngineer;
import com.wethinkcode.co.za.swingy.HeroBuilder.OldHeroBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseMethod {


    public HeroEngineer fetchHeroEngine() {
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();
        int id;
        String name = "";
        String clan_name = "";
        int health = 0;
        int damage = 0;
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HEROS WHERE ID = 2;");

            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                clan_name = rs.getString("clan_name");
                health = rs.getInt("health");
                damage = rs.getInt("damage");

                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("CLAN_NAME = " + clan_name);
                System.out.println("HEALTH = " + health);
                System.out.println("DAMAGE = " + damage);
                System.out.println();
            }

            HeroBuilder oldStyleHero = new OldHeroBuilder(name, clan_name, health, damage);
            HeroEngineer HeroEngineer = new HeroEngineer(oldStyleHero);
//            HeroEngineer.makeHero();
            rs.close();
            stmt.close();
            connect.close();
            System.out.println("Operation done successfully");
            return HeroEngineer;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
            return null;
        }

    }


    public void fetch_all()
    {
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();


        try{

            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM HEROS");
            int i =1;
            while(rs.next())
            {

                String name =  rs.getString("name");
                String clan= rs.getString("clan_name");
                System.out.println(i + "."+ name +" of clan " +clan);
                i++;
            }
            System.out.println("Table accessed successfully");
            connect.close();
        }
    catch (Exception e) {
        //            HeroEngineer.makeHero();
        System.out.println("Error: " + e.getMessage());
        System.exit(0);

    }
    }

    public String fetch_hero_name(String H_name)
    { System.out.println(".11of clan " );
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect= connection.connectionClass();
        try{
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM HEROS WHERE NAME = H_name;");
//    ResultSet rs = stmt.executeQuery("SELECT * FROM HEROS WHERE ID = 2;");
            {
                String name =  rs.getString("name");
//                String clan= rs.getString("clan_name");
                System.out.println("."+ name +" of clan " );
            }

        }catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}