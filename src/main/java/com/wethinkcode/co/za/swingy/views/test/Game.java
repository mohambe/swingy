package com.wethinkcode.co.za.swingy.views.test;

import com.wethinkcode.co.za.swingy.views.test.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wethinkcode.co.za.swingy.views.test.Ui;

public class Game{

    ChoiceHandler cHandler = new ChoiceHandler();
    Ui ui = new Ui();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this,ui,vm); //this = the current actual class

    String nextPostion1, nextPostion2, nextPostion3, nextPostion4;
     public static void main(String[] args)
     {

         new Game();
     }

     public Game(){
         ui.createUI(cHandler);
         story.defaultSetup();
         vm.showTitleScreen(); 
     }

      public class ChoiceHandler implements ActionListener{
         public void actionPerformed(ActionEvent event)
         {
             String yourChoice = event.getActionCommand();//receive action choice

             switch(yourChoice){
                 case "start":vm.PlayerShow();story.townGate();break;
                 case "C1":story.selectpostion(nextPostion1);break;
                 case "C2":story.selectpostion(nextPostion2);break;
                 case "C3":story.selectpostion(nextPostion3);break; 
                 case "C4":story.selectpostion(nextPostion4);  break;
                //  case "submit": System.out.println("Scream"); break;
                
             }
             if(yourChoice.equals("submit"))
                {
                    ui.inputLabel.setText(ui.textField.getText());;
                    System.out.println("it works");
                    String lol =  ui.textField.getText().toString();
                    System.out.println(lol);
                    ui.textField.setText(" ");
                //set character name here NBBB
                vm.titleToTown();
                }
               
              
         }
     }

    //  public class text extends JFrame implements ActionListener{

    //  }
}