// package com.wethinkcode.co.za.swingy.controller;

// import java.util.Random;

// public class controls {

//     static int a = 4;
//     static int b = 4;
//     public boolean postion(String array[][], int x, int y) {
//         array[a][b] = "* ";
//         a += x;
//         b += y;

//         boolean result;

//         result = collision(array, a, b);

//         if (a == 0 || a >= 9 || b == 0 || b >= 9) {
//             System.out.println("out of bond");
//             return false;
//         } else {

//             if (result == false) {
//                 array[a][b] = "E ";
//                 a -= x;
//                 b -= y;
//                 array[a][b] = "H ";
//                 System.out.println("Help");
//             } else {
//                 array[a][b] = "H ";
//             }
//         }

//         return true;

//     }

//      // 1.check current postion and search if new co-ordinates holds enemy location
//     // before fighting
//     // 2.fight to activate battle simulation
//     // 3. revert hero back to former location on map and returns enemy
//     public boolean collision(String array[][], int x, int y) {
//         int map_size = 9;
//         int i = 0;
//         int j = 0;

//         boolean result = true;

//         if (array[x][y].equals("E ")) {
//             System.out.println("mommy told me");
//             result = battle();

//             if (result == true) {
//                 System.out.println("Winner");

//             } else if (result == false) {
//                 System.out.println("Loser");
//                 return (result);
//             }
//         }
//         return result;

//     }

//     public void enemies(String array[][]) {
//         Random rand = new Random();
//         int size = 9;

//         int a;
//         int b;

//         a = rand.nextInt(size);
//         b = rand.nextInt(size);

//         array[a][b] = "E ";

//     }

// }