package com.wethinkcode.co.za.swingy;

import java.util.Random;
import java.util.Scanner;
import com.wethinkcode.co.za.swingy.controller.*;

public class Map {
    static int a = 0;
    static int b = 0;
    static int map_max = 0;

    public boolean postion(String array[][], int x, int y, String Hero_name) {
        array[a][b] = "* ";
        a += x;
        b += y;

        boolean result;
        controls control = new controls();
        result = control.collision(array, a, b, Hero_name);

        if (a == 0 || a >= map_max || b == 0 || b >= map_max) {
            System.out.println("out of bond");
            return false;
        } else {

            if (result == false) {
                array[a][b] = "E ";
                a -= x;
                b -= y;
                array[a][b] = "H ";
                System.out.println("Help");
            } else {
                array[a][b] = "H ";
            }
        }

        return true;

    }

    // constructor
    public Map(int map_size, String Hero_name) {

        String map[][] = new String[map_size][map_size];

        for (int i = 0; i < map_size; i++) {
            for (int j = 0; j < map_size; j++) {
                map[i][j] = "* ";
            }

        }
        controls control = new controls();
        Scanner input = new Scanner(System.in);
        control.enemies(map, map_size - 1);
        a = map_size / 2;
        b = map_size / 2;
        map_max = map_size - 1;

        postion(map, 0, 0, Hero_name);
        while (true) {
            for (int i = 0; i < map_size; i++) {
                for (int j = 0; j < map_size; j++) {
                    System.out.print(map[i][j]);
                }

                System.out.print("\n");
            }
            System.out.println("Pick move\n");
            String chosen_command = input.nextLine();
            if (chosen_command.equals("w")) {
                postion(map, -1, 0, Hero_name);
            } else if (chosen_command.equals("s")) {

                postion(map, 1, 0, Hero_name);
            } else if (chosen_command.equals("d")) {

                postion(map, 0, 1, Hero_name);
            } else if (chosen_command.equals("a")) {
                postion(map, 0, -1, Hero_name);
            }

        }

    }

}