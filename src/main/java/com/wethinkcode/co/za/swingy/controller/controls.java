package com.wethinkcode.co.za.swingy.controller;

import com.wethinkcode.co.za.swingy.Database.DatabaseMethod;
import com.wethinkcode.co.za.swingy.HeroBuilder.HeroEngineer;

import java.util.Random;

public class controls {

    public boolean found = false;
    public boolean winner = false;
    int enemies_health=0;

    // 1.check current postion and search if new co-ordinates holds enemy location
    // before fighting
    // 2.fight to activate battle simulation
    // 3. revert hero back to former location on map and returns enemy
    public boolean collision(String array[][], int x, int y, String Hero_name) {

        boolean result = true;
        DatabaseMethod data = new DatabaseMethod();
        HeroEngineer heroEngineer;

        if (array[x][y].equals("E ")) {
            heroEngineer = data.fetchHeroEngine(Hero_name);

            battleSim battleThing = new battleSim();
            result = battleThing.battle(heroEngineer);

            if (result == true) {
                System.out.println("Winner");
                //update hero status
                data.update_hero(Hero_name);

            } else if (result == false) {
                System.out.println("Loser");
                return (result);
            }
        }
        return result;

    }


    public boolean collision_gui(String array[][], int x, int y, String Hero_name) {

        boolean result = false; // need to create a function that result the result health of enemie and set to true

        if (array[x][y].equals("E ")) {
            interaction();
            result = true;
        }
        if(getEnemies_health() <= 0)//getter
        {
            //set result to false
        }
        return result;

    }

    public void interaction()
    {
        found = true;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public  boolean getWinner()
    {
        return this.winner;
    }

    public void setEnemyHp(int enemyHp)
    {
        this.enemies_health = enemyHp;
    }

    public int getEnemies_health() {
        return enemies_health;
    }

    public void enemies(String array[][], int enemy_zone) {
        Random rand = new Random();
        int size = enemy_zone;
        // map_max;//so enemies don't show up on edge
        int a;
        int b;
        a = rand.nextInt(size);
        b = rand.nextInt(size);
        array[a][b] = "E ";
    }

}