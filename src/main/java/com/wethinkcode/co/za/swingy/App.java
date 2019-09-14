package com.wethinkcode.co.za.swingy;

import com.wethinkcode.co.za.swingy.Database.DatabaseMethod;
import com.wethinkcode.co.za.swingy.controller.HeroCreation;
import com.wethinkcode.co.za.swingy.views.test.Story;
import com.wethinkcode.co.za.swingy.views.test.VisibilityManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DatabaseMethod create = new DatabaseMethod();
        VisibilityManager vm = null;
        Story story= null;

        create.SwingyTable();
        while (true) {
            System.out.println("**************");
            System.out.println("*   Swingy   *");
            System.out.println("**************");

            System.out.println("1.Select Hero");
            System.out.println("2.Create Hero");

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            String Hero_name = null;
            if (choice.equals("1")) {
                // call fetch hero list
                DatabaseMethod fetch = new DatabaseMethod();
                fetch.fetch_all();
                System.out.println("Select Hero's name");
                String hero = input.next();
                System.out.println(hero);
                Hero_name = fetch.fetch_hero_name(hero);

                int level = 1;
                // might need to make map return something so we can determine whether to
                // increase map level
                int map_size = (level - 1) * 5 + 10 - (level / 2);
                Map Map = new Map(map_size, Hero_name, vm);

            } else if (choice.equals("2")) {
                // create
                // insert to database

                HeroCreation creator = new HeroCreation();

                System.out.println("Please provide Hero chosen name :");
                String new_hero = input.nextLine();
                System.out.println("Please choose Class :");
                System.out.println("Ninja");
                System.out.println("Pirate");
                String new_clan = input.nextLine();
                creator.HeroCreation(new_hero, new_clan);

                create.create_new_hero(creator.getName(), creator.getClan(), creator.getHp(), creator.getDp());
            } else {
                System.out.println("incorrect option");
            }
        }
    }

}
