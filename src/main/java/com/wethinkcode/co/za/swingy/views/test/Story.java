package com.wethinkcode.co.za.swingy.views.test;

import com.wethinkcode.co.za.swingy.Database.DatabaseMethod;
import com.wethinkcode.co.za.swingy.model.HeroBuilder.Hero;
import com.wethinkcode.co.za.swingy.model.HeroBuilder.HeroEngineer;
import com.wethinkcode.co.za.swingy.views.test2.*;


public class Story{

    Game game;
    Ui ui;
    VisibilityManager vm;
    Player player = new Player();
    superMonster monster;
    private String hero;
    DatabaseMethod data = new DatabaseMethod();
    HeroEngineer heroEngineer;
    gui_map map_1;
    int _health ;
    int _attackDamage;
    String _name;
    boolean encounter = false;
    boolean inbound = true;




    public Story(Game g, Ui userInterface, VisibilityManager vManager ,gui_map maps){

        game = g;
        ui = userInterface;
        vm = vManager;
        map_1 = maps;
        map_1.map(9);

    }

    public void defaultSetup(){// set default value to character info


        player.hp = get_health();
        player.name =getHeroName();
        player.Dp=get_attackDamage();
        ui.hpNumberLabel.setText("Hero :"+ player.name + "  Hp: " + player.hp);
        ui.weaponNameLabel.setText("Dp: "+ player.Dp);
    }

    public void selectpostion(String nextPostion)
    {
        switch (nextPostion) {
            case "attackGuard":attackGuard();break;
            case "townGate" : townGate(this.hero);break;
            case "north1" : map_1.moveNorth("test");north1(); System.out.println("\nYou moved north\n\n"); break;// need to keep the previous north to differeniate
            case "south1" : map_1.moveSouth("test");south1();System.out.println("\nYou moved south\n\n"); break;
            case "east1" :map_1.moveEast("test"); east();System.out.println("\nYou moved east\n\n"); break;
            case "west1" : map_1.moveWest("test");west_1();System.out.println("\nYou moved west\n\n"); break;
            case "fight" :fight();break;
            case "playerAttack" :playerAttack();break;
            case "monsterAttack" :monsterAttack();break;
            case "win" : win();break;
            case "lost" : lose();break;
            case "toTitle" : toTitle();break;
            case "map":crossMap();break;

        }
    }

    public void townGate(String Hero_name){
        //retrieve hero's stats

        System.out.println(Hero_name);
        this.hero = Hero_name;
        heroEngineer = data.fetchHeroEngine(Hero_name);
        heroEngineer.makeHero();
        Hero firstHero = heroEngineer.getHero();
        int health = firstHero.getHeroHp();
        int attackDamage = firstHero.getHeroDp();
        setHeroName(firstHero.getHeroName());
        setAttack(attackDamage);
        setHealth(health);

        defaultSetup();

        ui.mainTextArea.setText("You are about to enter the maze");
        ui.choice1.setText("Enter Maze");
        ui.choice2.setText("Quit");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPostion1 = "map";
        game.nextPostion2 = "lost";
        game.nextPostion3 = "";

    }

    public void crossMap(){ //journey around the map
        ui.mainTextArea.setText("you are in the maze.");


        ui.choice1.setText("North_1");
        ui.choice2.setText("South_1");
        ui.choice3.setText("East_1");
        ui.choice4.setText("West_1");

        game.nextPostion1 = "north1";
        game.nextPostion2 = "south1";
        game.nextPostion3 = "east1";
        game.nextPostion4 = "west1";
    }

    public void west_1(){
        encounter = map_1.get_interaction();
        inbound = map_1.get_getbound();
        if(inbound== false)
        {
            ui.mainTextArea.setText("You have reach end of map");

            ui.choice1.setText("To the title screen");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "toTitle";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }
        if((encounter == true ) && (inbound == true))
        {
            monster = new Monster_goblin();
            ui.mainTextArea.setText("You encountered a " + monster.name);
            ui.choice1.setText("fight");
            ui.choice2.setText("run");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "fight";
            game.nextPostion2 = "crossMap";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
            encounter = false;
        }
        else if ((encounter == false) && (inbound == true)){
            ui.mainTextArea.setText("you moved west");
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
    }

    public void north1(){

        encounter = map_1.get_interaction();
        inbound = map_1.get_getbound();
        if(inbound== false)
        {
            ui.mainTextArea.setText("You have reach end of map");

            ui.choice1.setText("To the title screen");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "toTitle";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }
        if((encounter == true ) && (inbound == true))
        {
            monster = new Monster_goblin();    ui.mainTextArea.setText("You encountered a " + monster.name);

            ui.choice1.setText("fight");
            ui.choice2.setText("crossMap");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "fight";
            game.nextPostion2 = "run";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
            encounter = false;
        }
        else if ((encounter == false) && (inbound == true)){
            ui.mainTextArea.setText("you moved north");
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
    }

    public void south1(){
        encounter = map_1.get_interaction();
        inbound = map_1.get_getbound();
        if(inbound== false)
        {
            ui.mainTextArea.setText("You have reach end of map");

            ui.choice1.setText("To the title screen");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "toTitle";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }
        if((encounter == true ) && (inbound == true))
        {

            monster = new Monster_goblin();
            ui.mainTextArea.setText("You encountered a " + monster.name);
            ui.choice1.setText("fight");
            ui.choice2.setText("crossMap");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "fight";
            game.nextPostion2 = "run";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
            encounter = false;
        }
        else if ((encounter == false) && (inbound == true)){
            ui.mainTextArea.setText("you moved south");
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
    }


    public void east(){
        encounter = map_1.get_interaction();
        inbound = map_1.get_getbound();
        if(inbound== false)
        {
            ui.mainTextArea.setText("You have reach end of map");
            ui.choice1.setText("To the title screen");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "toTitle";
            game.nextPostion2 = "";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
        }
        if((encounter == true ) && (inbound == true))
        {

            monster = new Monster_goblin();
            ui.mainTextArea.setText("You encountered a " + monster.name);
            ui.choice1.setText("fight");
            ui.choice2.setText("crossMap");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPostion1 = "fight";
            game.nextPostion2 = "run";
            game.nextPostion3 = "";
            game.nextPostion4 = "";
            encounter = false;
        }
        else if ((encounter == false) && (inbound == true)){
            ui.mainTextArea.setText("you moved east");
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

    }

    public void attackGuard(){
        ui.mainTextArea.setText("You Attacked the town Guard\n  and received retailation damage of 3 hits ");
        player.hp = player.hp-3;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText("attack again ");
        ui.choice3.setText("run");

        game.nextPostion1 = "townGate";
        game.nextPostion2 = "attackGuard";
        game.nextPostion3 = "crossRoad";

    }

    public void fight(){

        ui.mainTextArea.setText(monster.name +": " + monster.hp);

        ui.choice1.setText("attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPostion1 = "playerAttack";
        game.nextPostion2 = "crossMap";
        game.nextPostion3 = "";
        game.nextPostion4 = "";
    }

    public void playerAttack(){
        int playerDamge = 0;
        playerDamge = new java.util.Random().nextInt(12);

        ui.mainTextArea.setText("You attacked the "+ monster.name + " for " + playerDamge + " damage.");

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
        ui.choice2.setText(" ");
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
        ui.mainTextArea.setText("You have beaten the " + monster.name);

        ui.choice1.setText("Back to maze");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPostion1 = "map";
        game.nextPostion2 = "";
        game.nextPostion3 = "";
        game.nextPostion4 = "";
    }

    public void lose(){
        ui.mainTextArea.setText("You Weak" );

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

    public void setHeroName(String Name)
    {
        _name =Name;
    }

    public void setHealth(int Health)
    {
        _health = Health;
    }

    public void setAttack(int Attack)
    {
        _attackDamage = Attack;
    }

    public String getHeroName()
    {
        return _name;
    }
    public int get_health()
    {
        return  _health;
    }
    public int get_attackDamage()
    {
        return _attackDamage;
    }


}