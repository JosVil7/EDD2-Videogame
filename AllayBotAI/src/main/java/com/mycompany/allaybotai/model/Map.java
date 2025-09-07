/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.model;

/**
 *
 * @author Angie
 */
public class Map {

    private final int gridSize; //Map size
    private final int[][] mapa;

    public Map() {
        this.gridSize = 5;
        this.mapa = new int[gridSize][gridSize];
    }

}
