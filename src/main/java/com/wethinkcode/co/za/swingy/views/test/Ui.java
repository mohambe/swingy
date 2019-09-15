package com.wethinkcode.co.za.swingy.views.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
;
import com.wethinkcode.co.za.swingy.Database.*;
import  com.wethinkcode.co.za.swingy.views.test.*;


import com.wethinkcode.co.za.swingy.views.test.Game.ChoiceHandler;


public class Ui{

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, inputPanel, characterPanel , characterListPanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, inputLabel;
    JButton startButton, choice1, choice2, choice3, choice4, submitButton;
    JTextArea mainTextArea , characterTextArea;
    JTextField textField;
    JList list ;
    String listing [] = new String[20];
    Font titleFont = new Font("Time New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Time New Roman", Font.PLAIN, 28);
    Font normalheader = new Font("Time New Roman", Font.PLAIN, 15);
    DatabaseMethod fetch = new DatabaseMethod();


    public Ui() {}



    public void createUI(ChoiceHandler cHandler){

//    listing = fetch
        listing = fetch.fetch_into_list();
        //WINDOW
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);

        //Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,500);
        titleNamePanel.setBackground(Color.blue);
        titleNameLabel = new JLabel("SWINGY");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel); //adding the title name label elements to the titlename Panel 


        //TextInput box
        inputPanel =  new JPanel();
        textField = new JTextField("enter hero's name", 18);
        submitButton = new JButton("Submit");
        inputLabel = new JLabel("Nothing entered");
        submitButton.setFont(normalFont);
        submitButton.addActionListener(cHandler);
        submitButton.setActionCommand("submit");
        inputPanel.add(textField);
        inputPanel.add(submitButton);
        inputPanel.add(inputLabel);
        inputPanel.setBounds(300,500,500,100);
        inputPanel.setBackground(Color.red);
      

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.red);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);  //handler
        startButton.setActionCommand("start"); // action command to let us know which button was pressed
        startButtonPanel.add(startButton);
        // System.out.println("hello");

        window.add(titleNamePanel);
        window.add(startButtonPanel);
        window.add(inputPanel);

        //Game screen
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea); //linking mainAreaText to the main Text panel

        characterPanel = new JPanel();
        characterPanel.setBounds(100,100,600,250);
        characterPanel.setBackground(Color.red);
        window.add(characterPanel);

        characterListPanel = new JPanel();//list of heroes
        characterListPanel.setBounds(100,100,600,250);
        list =  new JList(listing);
        characterListPanel.add(list);
        characterListPanel.setBackground(Color.red);
        window.add(characterListPanel);



        characterTextArea= new JTextArea(); //where we want to show the list of avaible heroes
        characterTextArea.setBounds(100,100,600,250);
        characterTextArea.setBackground(Color.RED);
        characterTextArea.setForeground(Color.white);
        characterTextArea.setFont(normalFont);
        characterTextArea.setLineWrap(true);
        characterTextArea.setWrapStyleWord(true);
        characterTextArea.setEditable(false);

        
        
        characterListPanel.add(characterTextArea);
        window.add(characterListPanel);


        choiceButtonPanel = new JPanel();//for button area
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("Choice1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);  //handler
        choice1.setActionCommand("C1"); 
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);  //handler
        choice2.setActionCommand("C2"); 
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.black);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);  //handler
        choice3.setActionCommand("C3"); 
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.black);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);  //handler
        choice4.setActionCommand("C4"); 
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();  //player status bar on top
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        // playerPanel.setForeground(Color.white);
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);

        hpLabel = new JLabel("Status:");
        hpLabel.setFont(normalheader);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel); // adding hp Label to player panel
        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(Color.white);
        hpNumberLabel.setFont(normalheader);
        playerPanel.add(hpNumberLabel);

        weaponLabel = new JLabel(" ");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalheader);
        playerPanel.add(weaponLabel);
        weaponNameLabel = new JLabel();
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setFont(normalheader);
        playerPanel.add(weaponNameLabel); 
        window.setVisible(true);

    }
}