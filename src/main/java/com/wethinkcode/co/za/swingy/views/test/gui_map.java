package com.wethinkcode.co.za.swingy.views.test;

import com.wethinkcode.co.za.swingy.controller.controls;
import com.wethinkcode.co.za.swingy.controller.*;

public class gui_map {

    static int a = 5;
    static int b = 4;
    static int map_max = 0;
    public String[][] main_map;
    controls control = new controls();

    boolean found = false;
    boolean bound = true;

    public boolean postion(String array[][], int x, int y, String Hero_name) {
        array[a][b] = "* ";
        a += x;
        b += y;

        boolean result;
         result = control.collision_gui(array, a, b, Hero_name);
         this.found = result;
        if (a == 0 || a >= 8 || b == 0 || b >=8) {
            System.out.println("out of bond");
            bound = false;
            return false;
        }
        else {
                    array[a][b] = "H ";
        }
        return true;
    }

    public boolean get_interaction()
    {
        return this.found;
    }

    public boolean get_getbound()
    {
        return this.bound;
    }

    public void  map(int size) {
        try {

            String map[][] = new String[size][size];

            System.out.println(a);
            System.out.println(b);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    map[i][j] = "* ";
                }
            }

            control.enemies(map,8);
            postion(map, 0, 0, "test");
            setMap(map);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);

                } System.out.print("\n");
            }
        }catch (Exception e)
        {
            System.out.println("Hi");
        }

    }

    public  void moveNorth( String Hero_name)
    {
        String[][] MAP;
        MAP =getMain_map(); // get latest updated map
        //create map getter here
        postion(MAP, -1, 0, Hero_name); //DEAL make postion by moving Hero

        setMap(MAP); // Set updated map to as new map to work with

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(MAP[i][j]);
            }
            System.out.print("\n");
        }
    }

    public  void moveSouth( String Hero_name)
    {
        String[][] MAP;
        MAP =getMain_map();
        //create map getter here
        postion(MAP, 1, 0, Hero_name);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(MAP[i][j]);
            }
            System.out.print("\n");
        }

        setMap(MAP);
    }

    public  void moveEast( String Hero_name)
    {
        String[][] MAP;
        MAP =getMain_map();
        //create map getter here
        postion(MAP, 0, 1, Hero_name);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(MAP[i][j]);
            }
            System.out.print("\n");
        }
        setMap(MAP);
    }

    public  void moveWest( String Hero_name)
    {
        String[][] MAP;
        MAP =getMain_map();
        //create map getter here
        postion(MAP, 0, -1, Hero_name);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(MAP[i][j]);
            }
            System.out.print("\n");
        }
        setMap(MAP);
    }

    public void setMap(String[][] map) {
        main_map = map;
    }

    public String[][] getMain_map()
    {
        return main_map;
    }
}