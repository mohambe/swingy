package com.wethinkcode.co.za.swingy.views.test;

import com.wethinkcode.co.za.swingy.controller.controls;
import com.wethinkcode.co.za.swingy.controller.*;

public class gui_map {

    static int a = 5;
    static int b = 4;
    static int map_max = 0;
    public String[][] main_map;

    public boolean postion(String array[][], int x, int y, String Hero_name) {
        array[a][b] = "* ";
        a += x;
        b += y;

        boolean result;
        controls control = new controls();
        System.out.println("in positions");
        System.out.println(a);
        System.out.println(b);
        array[a][b] = "H ";
        //
         result = control.collision(array, a, b, Hero_name);

        if (a == 0 || a >= 9 || b == 0 || b >= 9) {
            System.out.println("out of bond");
            return false;
        }
        array[a][b] = "H ";
//        } else {
////
////            if (result == false) {
//                array[a][b] = "E ";
//                a -= x;
//                b -= y;
//                array[a][b] = "H ";
//                System.out.println("Help");
//            } else {
        //}
        return true;

    }
    public void  map(int size) {
        try {

            controls control = new controls();
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