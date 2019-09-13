package com.wethinkcode.co.za.swingy.views.test;

import com.wethinkcode.co.za.swingy.views.test.*;

public class VisibilityManager {
    public Ui ui;

    public VisibilityManager(Ui userInterface) {
        ui = userInterface;
    }

    public void showTitleScreen() {

        // show title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // hibe the game screen
        ui.mainTextPanel.setVisible(false);
        ui.characterPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.inputPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void showTextBox() {

    }

    public void titleToTown() {
        // show title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // hibe the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        
        
        ui.inputPanel.setVisible(false);
        ui.characterListPanel.setVisible(false); // don't really need yah
        ui.characterTextArea.setText("");
    }

    public void PlayerShow() {
        // show title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // hibe the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false); // player status bar
        
        //Player section zone
        ui.characterListPanel.setVisible(true);
        ui.inputPanel.setVisible(true);

        ui.characterTextArea.setText("HELLOOOOOOO\nsdskdksakds\nsdsdsda'n");

    }
}