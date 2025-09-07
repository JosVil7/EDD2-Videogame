/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.controller;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.allaybotai.view.CreditsView;
import com.mycompany.allaybotai.view.MainGameView;
import com.mycompany.allaybotai.view.StartMenuView;
import javax.swing.UIManager;

/**
 *
 * @author Angie
 */
public class GameController {

    //Main method
    public GameController() {

        //UI
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Begin with the Start menu
        StartMenuView menu = new StartMenuView(this);
            menu.setVisible(true);
        
    }

    //Initialize StartMenu, dispose of the given frame
    public boolean goToStartMenu(javax.swing.JFrame frame) {
        try {
            StartMenuView menu = new StartMenuView(this);
            menu.setVisible(true);
            frame.dispose();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean goToCredits(javax.swing.JFrame frame) {
        try {
            CreditsView credits = new CreditsView(this);
            credits.setVisible(true);
            frame.dispose();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean goToMainGame(javax.swing.JFrame frame) {
        try {
            MainGameView mainGame = new MainGameView(this);
            mainGame.setVisible(true);
            frame.dispose();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
