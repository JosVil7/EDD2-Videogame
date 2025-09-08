/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.controller;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.allaybotai.model.MapModel;
import com.mycompany.allaybotai.view.CreditsView;
import com.mycompany.allaybotai.view.MainGameView;
import com.mycompany.allaybotai.view.StartMenuView;
import java.io.IOException;
import javax.swing.UIManager;

/**
 *
 * @author Angie
 */
public class GameController {

    MainGameView mainGame;
    PlayerController playerController;
    MapModel map;

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

    //Initialize set view, dispose of the given frame
    public boolean goToStartMenu(javax.swing.JFrame frame) {
        try {
            StartMenuView menu = new StartMenuView(this);
            frame.dispose();
            menu.setVisible(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean goToCredits(javax.swing.JFrame frame) {
        try {
            CreditsView credits = new CreditsView(this);
            frame.dispose();
            credits.setVisible(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean goToMainGame(javax.swing.JFrame frame) {
        try {
            this.mainGame = new MainGameView(this);
            frame.dispose();
            this.beginGame(); //Game BEGUNNN
            mainGame.setVisible(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Map Logic
    private void beginGame() throws IOException {
        this.playerController = new PlayerController(this, this.mainGame);
        this.generateMap();
        this.mainGame.createButtons();
        if (this.map.getPlayerPosition() == -1) {
            System.out.println("Player not found, WORRY");
        }
        this.mainGame.setPlayerFront(this.map.getPlayerPosition());
    }

    private void generateMap() {
        this.map = new MapModel();
    }

    public void moveUp() throws IOException {
        if (this.map.getX() == 0) {
            //I can't move there panel
        } else {
            this.mainGame.setPlayerBack(this.map.getPlayerPosition() - 5);
            int x = this.map.getX();
            int y = this.map.getY();
            this.leaveCell(x, y);
            int eventCode = this.map.exploreCell((x - 1), y);
            int position = this.map.getPlayerPosition();

            if (eventCode < 0) {
                //We've already been here
            } else {
                this.showEvent(eventCode);
            }
        }
    }

    public void moveDown() throws IOException {
        if (this.map.getX() == 4) {
            //I can't move there panel
        } else {
            this.mainGame.setPlayerFront(this.map.getPlayerPosition() + 5);
            int x = this.map.getX();
            int y = this.map.getY();
            this.leaveCell(x, y);
            int eventCode = this.map.exploreCell((x + 1), y);
            int position = this.map.getPlayerPosition();

            if (eventCode < 0) {
                //We've already been here
            } else {
                this.showEvent(eventCode);
            }
        }
    }

    public void moveLeft() throws IOException {
        if (this.map.getY() == 0) {
            //I can't move there panel
        } else {
            this.mainGame.setPlayerLeft(this.map.getPlayerPosition() -1);
            int x = this.map.getX();
            int y = this.map.getY();
            this.leaveCell(x, y);
            int eventCode = this.map.exploreCell(x , y-1);
            int position = this.map.getPlayerPosition();

            if (eventCode < 0) {
                //We've already been here
            } else {
                this.showEvent(eventCode);
            }
        }
    }

    public void moveRight() throws IOException {
        if (this.map.getY() == 4) {
            //I can't move there panel
        } else {
            this.mainGame.setPlayerRight(this.map.getPlayerPosition() +1);
            int x = this.map.getX();
            int y = this.map.getY();
            this.leaveCell(x, y);
            int eventCode = this.map.exploreCell(x , y+1);
            int position = this.map.getPlayerPosition();

            if (eventCode < 0) {
                //We've already been here
            } else {
                this.showEvent(eventCode);
            }
        }
    }

    public void leaveCell(int i, int j) throws IOException {
        int eventCode = this.map.getEventCode(i, j);
        int position = this.map.getPlayerPosition();
        this.map.leaveCell(i, j);
        this.setTileInView(eventCode, position);
    }

    public void setTileInView(int eventCode, int position) throws IOException {
        switch (eventCode) {
            //Empty
            case 0:
                this.mainGame.setTileEmpty(position);
                break;
            //Boss
            case 1:
                this.mainGame.setTileBoss(position);
                break;

            //Portals
            case 2:
                this.mainGame.setTilePortal(position);
                break;

            //Traps
            case 3:
                 this.mainGame.setTileTrap(position);
                break;

            //Gem or chest
            case 4:
                 this.mainGame.setTileChest(position);
                break;

            //Locked chest
            case 5:
                 this.mainGame.setTileLocked(position);
                break;
        }
    }

    public void showEvent(int eventCode) {
        
    }
}
