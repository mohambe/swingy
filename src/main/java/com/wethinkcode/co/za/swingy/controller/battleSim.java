package com.wethinkcode.co.za.swingy.controller;

import com.wethinkcode.co.za.swingy.HeroBuilder.Hero;
import com.wethinkcode.co.za.swingy.HeroBuilder.HeroEngineer;
import java.util.Random;
import java.util.Scanner;

public class battleSim {
    public boolean battle(HeroEngineer HeroEngineer) {
        HeroEngineer.makeHero();
        Hero firstHero = HeroEngineer.getHero();
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Game varaible
        String[] enemies = { "Puppy", "Doll", "Ex" };
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 35;

        // Player variable
        int health = firstHero.getHeroHp();
        int attackDamage = firstHero.getHeroDp();
        int numHealthPotion = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;// percentage

        boolean running = true;

        System.out
                .println("Welcome " + firstHero.getHeroName() + " of " + firstHero.getHeroClan() + " clan to War room");

        while (running) {
            System.out.println("--------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("# " + enemy + "'s has appeared to Fight you #\n");

            while (enemyHealth > 0) {
                System.out.println("Your Hp: " + health);
                System.out.println("" + enemy + "'s HP: " + enemyHealth);
                System.out.println("How would you like to response?");
                System.out.println("1. Attack ");
                System.out.println("2. Drink health potion");
                System.out.println("3. Run like a motherfather");

                String chosen_input = input.nextLine();
                if (chosen_input.equals("1")) {
                    int damageDealt = attackDamage;
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("#You strike the " + enemy + " for " + damageDealt + " damage");
                    System.out.println("#You received " + damageTaken + " damage from " + enemy);

                    if (health < 1) {
                        System.out.println("Your health is too low use potion");
                        break;
                    }

                } else if (chosen_input.equals("2")) {

                    if (numHealthPotion > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotion--;
                        System.out.println("#You used a potion , that healed you for " + healthPotionHealAmount
                                + "\nYour health is now at " + health + " Hp" + "\n Potion now at " + numHealthPotion);
                    } else {
                        System.out.println("You out of potions , Beat A monster for one");
                    }
                } else if (chosen_input.equals("3")) {
                    // return false so we can return every piece back to normal site
                    System.out.println("You ran away like a coward");
                    return false;
                } else {
                    System.out.println("In correct option chosen");
                }
            }

            if (health < 1) {
                System.out.println("you walk away from the battle injured");
                break;
            }

            System.out.println("# " + enemy + " was defeated by " + firstHero.getHeroName() + " of "
                    + firstHero.getHeroClan() + " clan!");
            System.out.println("#you have " + health + "HP left.");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotion++;
                System.out.println("the " + enemy + " Dropped a potion increasing ur potion count by one");
            }

            System.out.println("\nWhat would you like to do now");
            System.out.println("1. Exit War room");
            String chosen_input = input.nextLine();

            while (!chosen_input.equals("1") && !chosen_input.equals("2")) {
                System.out.println("In correct option chosen");
                chosen_input = input.nextLine();
            }
            if (chosen_input.equals("1")) {
                System.out.println(" you chose to leave war room");
                return true;
            }
        }
        return running;
    }
}