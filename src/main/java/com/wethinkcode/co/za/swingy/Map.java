package com.wethinkcode.co.za.swingy;

import java.util.Random;
import java.util.Scanner;

public class Map {
    static int a = 4;
    static int b = 4;


    public boolean battle(){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //Game varaible
        String[] enemies = {"Puppy", "Doll", "Ex's"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player variable
        int health = 100;
        int attackDamage = 50;
        int numHealthPotion = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;//percentage

        boolean running = true;

        System.out.println("Welcome to War room");

        while(running)
        {
            System.out.println("--------------------------------------");

            int  enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy +"'s has appeared to Fight you #\n");

            while(enemyHealth > 0)
            {
                System.out.println("\tYour Hp: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\tHow would you like to response?");
                System.out.println("\t1. Attack ");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run like a motherfather");

                String chosen_input = input.nextLine();
                if(chosen_input.equals("1"))
                {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -=damageDealt;
                    health -= damageTaken;

                    System.out.println("\t You strike the "+ enemy + " for "+ damageDealt+" damage");
                    System.out.println("\t You received " + damageTaken + " daamage from " + enemy);

                    if(health < 1)
                    {
                        System.out.println(" Your health is too low use potion");
                        break;
                    }

                }else if(chosen_input.equals("2"))
                {

                    if(numHealthPotion > 0)
                    {
                        health +=  healthPotionHealAmount;
                        numHealthPotion--;
                        System.out.println("\t You used a potion , that healed you for " + healthPotionHealAmount+
                                "\nYour health is now at " + health + " Hp" + "\n Potion now at " + numHealthPotion);
                    }
                    else
                    {
                        System.out.println("You out of potions , Beat A monster for one");
                    }
                }else if(chosen_input.equals("3"))
                {
                    //return false so we can return every piece back to normal site
                    System.out.println("You ran away like a coward");
                    return false;
                }
                else
                {
                    System.out.println("In correct option chosen");
                }
            }

            if(health < 1)
            {
                System.out.println("you walk away from the battle injured");
                break;
            }

            System.out.println("# " + enemy + "was defeated! ");
            System.out.println("#you have " + health + "HP left.");
            if(rand.nextInt(100) < healthPotionDropChance)
            {
                numHealthPotion++;
                System.out.println("the " + enemy + " Dropped a potion increasing ur potion count by one");
            }


            System.out.println("\nWhat would you like to do now");
            System.out.println("1. Exit War room");

            String chosen_input = input.nextLine();

            while(!chosen_input.equals("1") && !chosen_input.equals("2"))
            {
                System.out.println("In correct option chosen");
                chosen_input = input.nextLine();
            }

            if(chosen_input.equals("1"))
            {
                System.out.println(" you chose to leave war room");
                return true;
                 
            }
            // return true;

        }
        return running;

    }

    public boolean postion(String array[][], int x, int y) {
        array[a][b] = "* ";
        a += x;
        b += y;

        boolean result;

        result = collision(array, a, b);

        if (a == 0 || a >= 9 || b == 0 || b >= 9) {
            System.out.println("out of bond");
            return false;
        }
        else{

        if(result == false)
        {
            array[a][b] = "E ";
            a-=x;
            b-=y;
            array[a][b] = "H ";
            System.out.println("Help");
        }else
        {
            array[a][b] = "H ";
        }
    }
     
     
        return true;

    }

    //1.check current postion and search if new co-ordinates holds enemy location before fighting
    //2.fight to activate battle simulation
    //3. revert hero back to former location on map and returns enemy  
    public boolean collision(String array[][], int x, int y)
    {
        int map_size = 9;
        int i = 0;
        int j = 0;

        boolean result = true;

        if(array[x][y].equals("E "))
        {
            System.out.println("mommy told me");
            result=battle();

            if(result == true)
            {
                System.out.println("Winner");

            }
            else if(result == false)
            {
                System.out.println("Loser");
                return(result);
            }
        }
        return result;
    
    }

    public void enemies(String array[][]) {
        Random rand = new Random();
        int size = 9;

        int a;
        int b;

        a = rand.nextInt(size);
        b = rand.nextInt(size);

        array[a][b] = "E ";
        

    }

    // constructor
    public Map(int map_size) {

        String map[][] = new String[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = "* ";
            }
            // 
            // System.out.print("\n");

        }
        Scanner input = new Scanner(System.in);
        enemies(map);
        postion(map, 0, 0);
        while (true) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }

                System.out.print("\n");
            }
            System.out.println("Pick move\n");
            String chosen_command = input.nextLine();
            
            if (chosen_command.equals("w")) {
                postion(map, -1, 0);
            } else if (chosen_command.equals("s")) {
              
                postion(map, 1, 0);
            } else if (chosen_command.equals("d")) {
                
                postion(map, 0, 1);
            } else if (chosen_command.equals("a")) {
                postion(map, 0, -1);
            }
            

        }

    }

}