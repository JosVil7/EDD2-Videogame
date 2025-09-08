/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.model;

import java.util.Random;

/**
 *
 * @author Angie
 */
public class MapModel {

    private final int gridSize; //Map size
    private final int[][] map;
    private final int[][] playerMap; //playerMap accounts for explored spaces and player position
    private Random random = new Random();

    public MapModel() {
        this.gridSize = 5;
        this.map = new int[gridSize][gridSize];
        this.playerMap = new int[gridSize][gridSize];
        this.generateMap();
    }

    private void generateMap() {
        this.playerMap[3][2] = -1;
        this.map[3][2] = -1;
        generateEvent(1, 1); // 1/25 boss
        generateEvent(2, 2); // 2/25 portals
        generateEvent(5, 3); // 5/25 traps
        generateEvent(13, 4); // 13/25 gems
        generateEvent(2, 5); // 2/25 locked chests
        this.map[3][2] = 0; // 2 empty spaces
    }

    //Event generator, quantity and code of the event
    // 0 = Empty
    // 1 = Boss
    // 2 = Portals
    // 3 = Taps
    // 4 =  Gems
    // 5 =  LockedChests
    private void generateEvent(int c, int eventCode) {
        if (c == 0) {
            return;
        }
        int x = random.nextInt(gridSize);
        int y = random.nextInt(gridSize);
        if (map[x][y] == 0) {
            map[x][y] = eventCode;
            generateEvent(c - 1, eventCode);
        } else {
            generateEvent(c, eventCode);
        }
    }

    public int getPlayerPosition() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (playerMap[i][j] == -1) {
                    return i * 5 + j;
                }
            }
        }
        return -1;
    }

    public int getX() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (playerMap[i][j] == -1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int getY() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (playerMap[i][j] == -1) {
                    return j;
                }
            }
        }
        return -1;
    }

    public int exploreCell(int i, int j) {
        //If it has been explored before send a negative map code and change position
        if (playerMap[i][j] == 1) {
            playerMap[i][j] = -1;
            return -map[i][j];
        }
        playerMap[i][j] = -1;
        return map[i][j];
    }

    public void leaveCell(int i, int j) {
        playerMap[i][j] = 1;
    }
}
