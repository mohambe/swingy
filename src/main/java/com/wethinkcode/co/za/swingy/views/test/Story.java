package com.wethinkcode.co.za.swingy.views.test;

import com.wethinkcode.co.za.swingy.views.test2.*;

public class Story{

    Game game;
    Ui ui;
    VisibilityManager vm;
    Player player = new Player();
    superMonster monster;

    gui_map map_1;

    public Story(Game g, Ui userInterface, VisibilityManager vManager ,gui_map maps){

        game = g;
        ui = userInterface;
        vm = vManager;
        map_1 = maps;
        map_1.map(9);

    }

    public void defaultSetup(){// set default value to character info
        player.hp = 10;
        ui.hpNumberLabel.setText(" "+ player.hp);

        //player.weapon = new weaponTool();
        ui.weaponNameLabel.setText("knife");
    }



    public void selectpostion(String nextPostion)
    {
        switch (nextPostion) {
            case "talkGuard":talkGuard();break;
            case "attackGuard":attackGuard();break;
            case "crossRoad" : crossRoad();break;
            case "townGate" : townGate();break;
            case "north" : north1();break;
            case "north1" : map_1.moveNorth("test");break;// need to keep the previous north to differeniate
            case "south1" : map_1.moveSouth("test");break;
            case "east1" : map_1.moveEast("test");break;
            case "west1" : map_1.moveWest("test");break;
            case "east" : east();break;
            case "west" : west();break;
            case "fight" :fight();break;
            case "playerAttack" :playerAttack();break;
            case "monsterAttack" :monsterAttack();break;
            case "win" : win();break;
            case "lost" : lose();break;
            case "toTitle" : toTitle();break;
            case "map":crossMap();break;

        }
    }

    public void townGate(){
        ui.mainTextArea.setText("You are new in town\n don't reall trust you please leave");
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("AttackGuard");
        ui.choice3.setText("Leave");

        game.nextPostion1 = "talkGuard";
        game.nextPostion2 = "attackGuard";
        game.nextPostion3 = "map";



    }
    public void talkGuard()
    {

        ui.mainTextArea.setText("Again i don't recognise you please leave");
        ui.choice1.setText(">>");
        ui.choice2.setText("Go to map ");
        ui.choice3.setText(" ");

        game.nextPostion1 = "townGate";
        game.nextPostion2 = "map";
        game.nextPostion3 = " ";

    }

    public void crossMap(){ //journey around the map
        ui.mainTextArea.setText("you are in the maze.");
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("East");
        ui.choice4.setText("West");

        game.nextPostion1 = "north1";
        game.nextPostion2 = "south1";
        game.nextPostion3 = "east1";
        game.nextPostion4 = "west1";
    }




    public void crossRoad(){ //journey around the map
        ui.mainTextArea.setText("ypu are near the crossrod. if you go south you will be  back at town.");
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("East");
        ui.choice4.setText("West");

        game.nextPostion1 = "north";
        game.nextPostion2 = "townGate";
        game.nextPostion3 = "east";
        game.nextPostion4 = "west";
    }

    public void north1(){
        ui.mainTextArea.setText("you moved north");
        ui.hpNumberLabel.setText(""+ player.hp);
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("East");
        ui.choice4.setText("West");

        // map.setNorth()  movement

        // precaution check to see end of border
        game.nextPostion1 = "north1";
        game.nextPostion2 = "south";
        game.nextPostion3 = "east";
        game.nextPostion4 = "west";
    }

    public void north(){
        ui.mainTextArea.setText("you moved north");
        ui.hpNumberLabel.setText(""+ player.hp);
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("East");
        ui.choice4.setText("West");

        // map.setNorth()  movement

        // precaution check to see end of border
        game.nextPostion1 = "north1";
        game.nextPostion2 = "south1";
        game.nextPostion3 = "east1";
        game.nextPostion4 = "west1";
    }

    public void east(){
        ui.mainTextArea.setText("you moved north");
        ui.hpNumberLabel.setText(""+ player.hp);
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("East");
        ui.choice4.setText("West");

        // map.setNorth()  movement

        // precaution check to see end of border
        game.nextPostion1 = "north1";
        game.nextPostion2 = "south1";
        game.nextPostion3 = "east1";
        game.nextPostion4 = "west1";
    }


    public void map(){
        ui.mainTextArea.setText("you are at  a river you drink water and heal for +2.");
        player.hp +=2;
        ui.hpNumberLabel.setText(""+ player.hp);
        ui.choice1.setText("Go south");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");


        // map.setNorth()  movement

        // precaution check to see end of border
        game.nextPostion1 = "crossRoad";
        game.nextPostion2 = "";
        game.nextPostion3 = "";
        game.nextPostion4 = "";
    }

    public void attackGuard(){
        ui.mainTextArea.setText("You Attacked the town Guard\n  and received retailation damage of 3 hits ");
        player.hp = player.hp-3;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText("attack again ");
        ui.choice3.setText("crossGuard");

        game.nextPostion1 = "townGate";
        game.nextPostion2 = "attackGuard";
        game.nextPostion3 = "crossRoad";

    }

    public void west(){

        monster = new Monster_goblin();
        ui.mainTextArea.setText("You encountered a " + monster.name);

        ui.choice1.setText("fight");
        ui.choice2.setText("crossRoad");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPostion1 = "fight";
        game.nextPostion2 = "crossRoad";
        game.nextPostion3 = "";
        game.nextPostion4 = "";
    }

    public void fight(){

        ui.mainTextArea.setText(monster.name +": " + monster.hp);

        ui.choice1.setText("attack");
        ui.choice2.setText("crossRoad");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPostion1 = "playerAttack";
        game.nextPostion2 = "crossRoad";
        game.nextPostion3 = "";
        game.nextPostion4 = "";
    }

    public void playerAttack(){
        int playerDamge = 0;
        playerDamge = new java.util.Random().nextInt(12);
//        if( ui.weaponNameLabel.equals("Long sword"))
//            playerDamge = new java.util.Random().nextInt(12);
//        else if( ui.weaponNameLabel.equals("Knife"))
//            playerDamge = new java.util.Random().nextInt(3);
        ui.mainTextArea.setText("You attacked the "+ monster.name + "and gave " + playerDamge + " damage.");

        monster.hp = monster.hp - playerDamge ;

        ui.choice1.setText("> attack again");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(monster.hp >0) {
            game.nextPostion1 = "monsterAttack";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }
        else if(monster.hp< 1)
        {
            game.nextPostion1 = "win";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }
    }

    public void monsterAttack(){
        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText(" "+ player.hp);

        ui.choice1.setText("> ");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");


        if(player.hp >0) {
            game.nextPostion1 = "fight";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }
        else if(player.hp< 1)
        {
            game.nextPostion1 = "lost";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }

    }

    public void win(){
        ui.mainTextArea.setText("You hav beaten the " + monster);

        ui.choice1.setText("east");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPostion1 = "crossRoad";
        game.nextPostion2 = "";
        game.nextPostion3 = "";
        game.nextPostion4 = "";
    }


    public void lose(){
        ui.mainTextArea.setText("You dead"  + monster);

        ui.choice1.setText("To the title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPostion1 = "toTitle";
        game.nextPostion2 = "";
        game.nextPostion3 = "";
        game.nextPostion4 = "";
    }

    public void toTitle(){
        defaultSetup() ;
        vm.showTitleScreen();
    }

}