package com.wethinkcode.co.za.swingy;

import com.wethinkcode.co.za.swingy.*;
import com.wethinkcode.co.za.swingy.Database.DatabaseMethod;

import java.util.Random;

import java.util.Scanner;;

public class App 
{
    public static void main( String[] args )
    {


        System.out.println("**************");
        System.out.println("*   Swingy   *");
        System.out.println("**************");

        System.out.println("1.Select Hero");
        System.out.println("2.Create Hero");

        Scanner input = new Scanner(System.in);
        String choice  = input.nextLine();
        if(choice.equals("1"))
        {
            //call fetch hero list
            DatabaseMethod fetch = new DatabaseMethod();
            fetch.fetch_all();
            System.out.println("Select Hero's name");
            String hero =input.next();

            System.out.println(hero);
            fetch.fetch_hero_name(hero);

        }else if(choice.equals("2"))
        {
            //create
            //insert to database
        }else
        {
            System.out.println("incorrect option");
        }


        /**

        //work on sizing
        //
        int level = 1;
        // might need to make map return something so we can determine whether to increase map level
        int map_size=(level -1)*5+10-(level/2);

        Map Map = new Map(map_size);

         **/

    }

}
