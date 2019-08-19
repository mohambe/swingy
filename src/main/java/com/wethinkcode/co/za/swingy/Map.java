package com.wethinkcode.co.za.swingy;

import java.util.Random;
import java.util.Scanner;

public class Map {
    static int a = 4;
    static int b = 4;

    public boolean postion(String array[][], int x, int y) {
        array[a][b] = "* ";
        a += x;
        b += y;

        collision(array, a, b);
        
        if (a == 0 || a >= 9 || b == 0 || b >= 9) {
            System.out.println("out of bond");
            return false;
        } else
            array[a][b] = "H ";
        return true;

    }

    //1.check current postion and search if new co-ordinates holds enemy location before fighting
    //2.fight to activate battle simulation
    //3. revert hero back to former location on map and returns enemy  
    public void collision(String array[][], int x, int y)
    {
        int map_size = 9;
        int i = 0;
        int j = 0;

        if(array[x][y].equals("E "))
        {
            System.out.println("mommy told me");
        }
        
        // while(j < map_size)
        // {
        //     while(i < map_size)
        //     {
        //         if(array[j][i].equals("E "))
        //         {
        //             System.out.println("mommy told me");
        //         }
        //         i++;
        //     }
        //     j++;
        // }
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