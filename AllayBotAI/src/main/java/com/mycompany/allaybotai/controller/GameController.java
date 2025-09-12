/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.controller;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.allaybotai.model.GemModel;
import com.mycompany.allaybotai.model.MapModel;
import com.mycompany.allaybotai.view.CreditsView;
import com.mycompany.allaybotai.view.MainGameView;
import com.mycompany.allaybotai.view.StartMenuView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.UIManager;

/**
 *
 * @author Angie
 */
public class GameController {

    private MainGameView mainGame;
    private PlayerController playerController;
    private MapModel map;
    private GemModel gemManager;

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

            this.gemManager = new GemModel(this);//New gemModel
            this.beginGame(); //Begin the map logic

            mainGame.setVisible(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Map Logic
    private void beginGame() throws IOException {
        //New player controller
        this.playerController = new PlayerController(this, this.mainGame);
        //New map and tiles
        this.generateMap();
        this.mainGame.createTiles();
        //Set player sprite
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

            if (eventCode < 0) {
                this.mainGame.showEventTileAlreadyExplored("<html><p>&gt;We've already been here!</p></html>");
            } else {
                if (eventCode != 0) {
                    this.doEvent(eventCode, (x - 1), y);
                }
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
            if (eventCode < 0) {
                this.mainGame.showEventTileAlreadyExplored("<html><p>&gt;We've already been here!</p></html>");
            } else {
                if (eventCode != 0) {
                    this.doEvent(eventCode, (x + 1), y);
                }
            }
        }
    }

    public void moveLeft() throws IOException {
        if (this.map.getY() == 0) {
            //I can't move there panel
        } else {
            this.mainGame.setPlayerLeft(this.map.getPlayerPosition() - 1);
            int x = this.map.getX();
            int y = this.map.getY();
            this.leaveCell(x, y);
            int eventCode = this.map.exploreCell(x, y - 1);

            if (eventCode < 0) {
                this.mainGame.showEventTileAlreadyExplored("<html><p>&gt;We've already been here!</p></html>");
            } else {
                if (eventCode != 0) {
                    this.doEvent(eventCode, x, y - 1);
                }
            }
        }
    }

    public void moveRight() throws IOException {
        if (this.map.getY() == 4) {
            //I can't move there panel
        } else {
            this.mainGame.setPlayerRight(this.map.getPlayerPosition() + 1);
            int x = this.map.getX();
            int y = this.map.getY();
            this.leaveCell(x, y);
            int eventCode = this.map.exploreCell(x, y + 1);

            if (eventCode < 0) {
                this.mainGame.showEventTileAlreadyExplored("<html><p>&gt;We've already been here!</p></html>");
            } else {
                if (eventCode != 0) {
                    this.doEvent(eventCode, x, y + 1);
                }
            }
        }
    }

    public void leaveCell(int i, int j) throws IOException {
        int eventCode = this.map.getEventCode(i, j);
        int position = this.map.getPlayerPosition();
        this.map.leaveCell(i, j);
        this.setTileInView(eventCode, position, i, j);
    }

    //Handles showing what is within the tile on the view after leaving the cell, does NOT perform any action
    public void setTileInView(int eventCode, int position, int x, int y) throws IOException {
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

    public void doEvent(int eventCode, int x, int y) {
        String gemName, message;
        switch (eventCode) {
            //Empty
            case 0 -> {
            }

            //Boss
            case 1 -> {
                Random random = new Random();
                int value = random.nextInt(1, 151);
                gemName = this.gemManager.gemLostValue(value);
                if (gemName.equals("")) {
                    message = "<html><p>&gt; An ogre has appeared!</p><p>&gt; I don't even have gems...</p><p>&gt; It seems it took pity on me</p></html>";
                    this.mainGame.showEventTileAlreadyExplored(message);
                } else {
                    message = "<html><p>&gt; An ogre has appeared!</p><p>&gt; It wants a gem of value </p>" + value + "<p>&gt; I gave him the </p>" + gemName + "</html>";
                    this.mainGame.showEventBoss(message);

                }
            }

            //Portal
            case 2 -> {
                message = "<html><p>&gt; This magic portal is asking for something...</p> <p>&gt; Should I sacrifice my </p> <p>   highest  gem to go in it? </p></html>";
                this.mainGame.showEventPortal(message);
            }

            //Trap
            case 3 -> {
                if (this.gemManager.gemLost()) {
                    message = "<html><p>&gt; A wild rabbit has attacked me!</p><p>&gt; It seems I lost a random gem...</p></html>";
                } else {
                    message = "<html><p>&gt; A wild rabbit has attacked me!</p><p>&gt; I don't even have gems...</p></html>";
                }
                this.mainGame.showEventTrap(message);
            }

            //Gem/Chest
            case 4 -> {
                gemName = this.gemManager.newGemCollected(x, y);
                message = "<html><p>&gt; I've found a gem!</p> <p>&gt; " + gemName + " added to the inventory</p></html>";
                this.mainGame.showEventResponse(message);
            }

            //Locked chest
            case 5 -> {
                message = "<html><p>&gt; I found a locked chest!</p> <p>&gt; Should I sacrifice my </p> <p>   lowest gem to open it? </p></html>";
                this.mainGame.showEventLockedChest(message);
            }
        }
    }

    public void setMovementEnabled(boolean enabled) {
        playerController.setEnabled(enabled);
    }

    public void updateInventory(ArrayList<String> list) {
        this.mainGame.updateInventory(list);
    }

    public void openChest(boolean answer) {
        String gemName, message;
        if (answer) {
            if (this.gemManager.gemLostMinimum()) {
                gemName = this.gemManager.newGemCollected(this.map.getX(), this.map.getY());
                gemName = gemName + " and " + this.gemManager.newGemCollected(this.map.getX(), this.map.getY());
                message = "<html><p>&gt; I've got a gem!</p> <p>&gt; " + gemName + " added to the inventory</p><p>&gt; This was worth it</p></html>";
                this.mainGame.showEventResponse(message);
            } else {
                message = "<html><p>I don't have anything on me...</p></html>";
                this.mainGame.showEventNoChest(message);
            }
        } else {
            message = "<html><p>&gt; Guess I'll never know...</p></html>";
            this.mainGame.showEventNoChest(message);
        }
    }

    public void goPortal(boolean answer) throws IOException {
        String gemName, message;
        if (answer) {
            if (this.gemManager.gemLostMaximum()) {
                //Change position logic
                //Position of the other portal
                int x = this.map.getX();
                int y = this.map.getY();
                this.leaveCell(x, y);
                int xFinal = this.map.getOtherPortalX(x, y);
                int yFinal = this.map.getOtherPortalY(x, y);
                int positionView = this.map.getOtherPortalPosition(x, y);
                this.map.exploreCell(xFinal, yFinal);
                this.mainGame.setPlayerFront(positionView);
                message = "<html><p>&gt; I've moved to [</p>" + xFinal + ", " + yFinal + "]</html>";
                //Message
                this.mainGame.showEventResponse(message);
            } else {
                message = "<html><p>I don't have anything on me...</p></html>";
                this.mainGame.showEventNoChest(message);
            }
        } else {
            message = "<html><p>&gt; I didn't need it...</p></html>";
            this.mainGame.showEventNoChest(message);
        }
    }
}
