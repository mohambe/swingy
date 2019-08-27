package com.wethinkcode.co.za.swingy;

import com.wethinkcode.co.za.swingy.*;
import java.util.Random;

import java.util.Scanner;;

public class App 
{
    public static void main( String[] args )
    {

        //work on sizing
        //
        int level = 1;
        // might need to make map return something so we can determine whether to increase map level
        int map_size=(level -1)*5+10-(level/2);

        Map Map = new Map(map_size);

    }

}
