package com.wethinkcode.co.za.swingy.views.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game{

    ChoiceHandler cHandler = new ChoiceHandler();
    Ui ui = new Ui();
    VisibilityManager vm = new VisibilityManager(ui);
    gui_map map = new gui_map();
    Story story = new Story(this,ui,vm,map); //this = the current actual class

    String nextPostion1, nextPostion2, nextPostion3, nextPostion4;
    String lol;

     public static void main(String[] args)
     {
         new Game();
     }

     public Game(){
         ui.createUI(cHandler);
         vm.showTitleScreen();
     }

      public class ChoiceHandler implements ActionListener{
         public void actionPerformed(ActionEvent event)
         {
             String yourChoice = event.getActionCommand();//receive action choice

             switch(yourChoice){
                 case "start":vm.PlayerShow();story.townGate(lol);break;
                 case "C1":story.selectpostion(nextPostion1);break;
                 case "C2":story.selectpostion(nextPostion2);break;
                 case "C3":story.selectpostion(nextPostion3);break;
                 case "C4":story.selectpostion(nextPostion4);  break;
             }
             if(yourChoice.equals("submit"))
                {
                    ui.inputLabel.setText(ui.textField.getText());;
                    lol =  ui.textField.getText().toString();
                    System.out.println(lol);
                    ui.textField.setText(" ");
                    vm.titleToTown();
                    story.townGate(lol);

                }
         }
     }
    //  public class text extends JFrame implements ActionListener{

    //  }
}