package com.wethinkcode.co.za.swingy.views.test;

import com.wethinkcode.co.za.swingy.views.test2.*;

public class Story{

    Game game;
    Ui ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(Game g, Ui userInterface, VisibilityManager vManager){

        game = g;
        ui = userInterface;
        vm = vManager;
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
                
              
        }
    }
    public void townGate(){
        ui.mainTextArea.setText("You are new in town\n don't reall trust you please leave");
        ui.choice1.setText("Talk to the guard");
        ui.choice2.setText("AttackGuard");
        ui.choice3.setText("Leave");

        game.nextPostion1 = "talkGuard";
        game.nextPostion2 = "attackGuard";
        game.nextPostion3 = "crossRoad";

    }
    public void talkGuard()
    {
        ui.mainTextArea.setText("Again i don't recognise you please leave");
        ui.choice1.setText(">>");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");

        game.nextPostion1 = "townGate";
        game.nextPostion2 = " ";
        game.nextPostion3 = " ";

    }

    public void attackGuard(){
        ui.mainTextArea.setText("You Attacked the town Guard\n do");
        ui.choice1.setText("attackGuard");
        ui.choice2.setText(" Use Postion");
        ui.choice3.setText("Run away");

        game.nextPostion1 = "talkGuard";
        game.nextPostion2 = "attackGuard";
        game.nextPostion3 = "crossRoad";

    }

    public void moveHero(){
        ui.mainTextArea.setText("You Attacked the town Guard\n do");
        ui.choice1.setText("North");
        ui.choice2.setText("South");
        ui.choice3.setText("East");
        ui.choice4.setText("West");

        game.nextPostion1 = "moveHero";
        game.nextPostion2 = "moveHero";
        game.nextPostion3 = "moveHero";
        game.nextPostion4 = "moveHero";

    }

    public void crossRoad(){
        ui.mainTextArea.setText("You are new in town\n do");
        ui.choice1.setText("   ");
        ui.choice2.setText(" ");
        ui.choice3.setText(" ");

        game.nextPostion1 = "talkGuard";
        game.nextPostion2 = "attackGuard";
        game.nextPostion3 = "crossRoad";
    }
}