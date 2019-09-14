package com.wethinkcode.co.za.swingy.Database;

import com.wethinkcode.co.za.swingy.HeroBuilder.HeroBuilder;
import com.wethinkcode.co.za.swingy.HeroBuilder.HeroEngineer;
import com.wethinkcode.co.za.swingy.HeroBuilder.OldHeroBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseMethod {

    public void SwingyTable() {
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();

        try {
            // table creation
            stmt = connect.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS HEROS " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL,"
                    + "NAME      TEXT    NOT NULL UNIQUE," + "CLAN_NAME   TEXT  NOT NULL," + "HEALTH     INT NOT NULL,"
                    + "DAMAGE     INT  NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            connect.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public HeroEngineer fetchHeroEngine(String Hero_name) {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM HEROS WHERE NAME =  + '" + Hero_name + "'");

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
            rs.close();
            stmt.close();
            connect.close();
            return HeroEngineer;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
            return null;
        }

    }

    public void fetch_all() {
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HEROS");
            int i = 1;
            while (rs.next()) {
                String name = rs.getString("name");
                String clan = rs.getString("clan_name");
                int hp=rs.getInt("health");
                int dp =rs.getInt("damage");
                System.out.println(i + "." + name + " of clan " + clan + "Hp:"+hp +"  Dp:"+dp);
                i++;
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    public String[] fetch_into_list() {
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();
        String [] list1 = new String[20];
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HEROS");
            int i = 1;
            int j= 0;
            while (rs.next()) {
                String name = rs.getString("name");
                String clan = rs.getString("clan_name");
                int hp=rs.getInt("health");
                int dp =rs.getInt("damage");
                System.out.println(i + "." + name + " of clan " + clan + "Hp:"+hp +"  Dp:"+dp);
                list1[j] = i + "." + name + " of clan " + clan + "Hp:"+hp +"  Dp:"+dp;
                j++;
                i++;
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        return list1;
    }

    public String fetch_hero_name(String H_name) {
        Connection connect = null;
        Statement stmt = null;
        String name = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();
        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HEROS WHERE NAME =  + '" + H_name + "'");
            {
                name = rs.getString("name");
                String clan = rs.getString("clan_name");

                System.out.println("." + name + " of clan " + clan);
                connect.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        return name;
    }

    public void update_hero(String H_name)
    {
        Connection connect = null;
        Statement stmt= null;
        Statement stmt_1= null;
        // String name =null;
        int new_hp;
        int new_dp;

        ConnectionClass  connection = new ConnectionClass();
        connect = connection.connectionClass();
        try{
//            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT HEALTH, DAMAGE FROM HEROS WHERE NAME = '"+ H_name+"'");
            {
                new_hp = rs.getInt("HEALTH") + 20;
                new_dp = rs.getInt("DAMAGE") + 20;
                System.out.println(new_hp);
                System.out.println(new_dp);
            }
//            connect.setAutoCommit(false);
            System.out.println("\n\n"+new_hp);
            System.out.println(new_dp);


//            stmt_1 = connect.createStatement();
            System.out.println("1");
            String sql="UPDATE  HEROS SET HEALTH = '"+ new_hp+"', DAMAGE = '"+new_dp+"' WHERE NAME = '"+ H_name+"'";
            System.out.println("2" + new_hp);
            stmt.executeUpdate(sql);
            System.out.println("3" + new_dp);
//            stmt_1.close();
            stmt.close();
//            connect.close();
            System.out.println("4");
        }catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }

        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM HEROS WHERE NAME = '"+ H_name+"' ");
            int i = 1;
            while (rs.next()) {
                String name = rs.getString("name");
                String clan = rs.getString("clan_name");
                int hp=rs.getInt("health");
                int dp =rs.getInt("damage");
                System.out.println(i + "." + name + " of clan " + clan + "Hp:"+hp +"  Dp:"+dp);
                i++;
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    public void create_new_hero(String Hero_name, String clan, int hp, int dp) {
        Connection connect = null;
        Statement stmt = null;
        ConnectionClass connection = new ConnectionClass();
        connect = connection.connectionClass();

        try {
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            System.out.println("1");
            String sql = "INSERT INTO HEROS (NAME,CLAN_NAME,HEALTH,DAMAGE) " + "VALUES ('" + Hero_name + "', '"
                    + clan + "', '" + hp + "',' " + dp + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connect.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Created");
    }

}