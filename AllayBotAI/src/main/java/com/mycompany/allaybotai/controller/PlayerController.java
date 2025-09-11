/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.controller;

import com.mycompany.allaybotai.view.MainGameView;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Angie
 */
public class PlayerController {

    private boolean enabled;
    private final GameController gameController;
    private final MainGameView mainGame;

    public PlayerController(GameController gameController, MainGameView mainGame) {
        this.gameController = gameController;
        this.mainGame = mainGame;
        this.enabled = true;
        this.setupKeyBindings();
    }

    private void setupKeyBindings() {
        // Get the InputMap and ActionMap for the mainGame
        InputMap inputMap = mainGame.getMapa().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = mainGame.getMapa().getActionMap();

        // Bind the keys to string names
        inputMap.put(KeyStroke.getKeyStroke("W"), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke("UP"), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke("S"), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke("A"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke("D"), "moveRight");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");

        // Bind the names to the actual actions
        actionMap.put("moveUp", createMoveAction("up"));
        actionMap.put("moveDown", createMoveAction("down"));
        actionMap.put("moveLeft", createMoveAction("left"));
        actionMap.put("moveRight", createMoveAction("right"));
    }

    private Action createMoveAction(String direction) {
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (this.enabled) {
                    try {
                        switch (direction) {
                            case "up" -> gameController.moveUp();
                            case "down" -> gameController.moveDown();
                            case "left" -> gameController.moveLeft();
                            case "right" -> gameController.moveRight();
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }

    public void setEnabled(boolean enabled) {
        mainGame.getMapa().getActionMap().get("moveUp").setEnabled(enabled);
        mainGame.getMapa().getActionMap().get("moveDown").setEnabled(enabled);
        mainGame.getMapa().getActionMap().get("moveLeft").setEnabled(enabled);
        mainGame.getMapa().getActionMap().get("moveRight").setEnabled(enabled);
    }
}
