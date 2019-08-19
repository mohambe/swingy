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

        if (a == 0 || a >= 9 || b == 0 || b >= 9) {
            System.out.println("out of bond");
            return false;
        } else
            array[a][b] = "H ";
        return true;

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
            String chosen_command = input.nextLine();
            System.out.println("Pick move");
            if (chosen_command.equals("w")) {
                System.out.println("Do u work");
                postion(map, -1, 0);
            } else if (chosen_command.equals("s")) {
                System.out.println("Do u work south");
                postion(map, 1, 0);
            } else if (chosen_command.equals("d")) {
                System.out.println("Do u work west");
                postion(map, 0, 1);
            } else if (chosen_command.equals("a")) {
                System.out.println("Do u work east");
                postion(map, 0, -1);
            }

            // input.close();

        }

    }

}