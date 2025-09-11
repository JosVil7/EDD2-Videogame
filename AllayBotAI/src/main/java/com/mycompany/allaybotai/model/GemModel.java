/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.model;

import com.mycompany.allaybotai.controller.GameController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Angie
 */
public class GemModel {

// Vector 1: Adjectives and Nouns
    private final String[] adjectives = {
        "Shadow", "Sunken", "Whispering", "Prismatic", "Veridian",
        "Celestial", "Ember", "Runic", "Obsidian", "Glimmering",
        "Wailing", "Forgotten", "Grave", "Azure", "Sanguine",
        "Tempest", "Chrono", "Void", "Echoing", "Solar"
    };

// Vector 2: Gem Types and Materials
    private final String[] types = {
        "Shard", "Heart", "Lode", "Tear", "Spire",
        "Stone", "Geode", "Talisman", "Crystal", "Jewel"
    };

    ArrayList<Integer> numbers;
    ArrayList<Integer> numbersUsed;
    private final GameController gameController;
    private final ArbolBST arbol;
    private final Random random = new Random();

    public GemModel(GameController gameController) {
        this.gameController = gameController;
        this.arbol = new ArbolBST();
        this.numbersUsed = new ArrayList<>();
        this.numbers = new ArrayList<>();
        for (int i = 1; i <= 150; i++) {
            this.numbers.add(i);
        }
        Collections.shuffle(numbers);
    }

    public String newGemCollected(int x, int y) {
        //Random Gem name combination
        String gemName = this.adjectives[random.nextInt(adjectives.length)] + " " + this.types[random.nextInt(types.length)];
        //Random gem value
        int powerValue = numbers.removeFirst();
        this.numbersUsed.add(powerValue);
        //Create Node within the tree class
        arbol.addNodo(gemName, powerValue, x, y);
        gameController.updateInventory(arbol.inOrden());
        gemName = gemName + " of value " + powerValue;
        return gemName;
    }

    public boolean gemLost() {
        //Delete a random node of a random power used 
        if (!numbersUsed.isEmpty()) {
            this.arbol.eliminar(this.numbersUsed.get(random.nextInt(numbersUsed.size())));
            gameController.updateInventory(arbol.inOrden());
            return true;
        } else {
            return false;
        }
    }

    public boolean gemLostMinimum() {
        if (!numbersUsed.isEmpty()) {
            this.arbol.eliminarNodo(arbol.root, arbol.minimo().poder);
            gameController.updateInventory(arbol.inOrden());
            return true;
        } else {
            return false;
        }
    }

    public String gemLostValue(int value) {
        String gemDeleted = "";
        Nodo deleted = this.arbol.eliminarCercano(value);
        if (deleted != null) {
            gemDeleted = deleted.nombre + " of value " + deleted.poder;
        }
        gameController.updateInventory(arbol.inOrden());
        return gemDeleted;
    }

    public boolean gemLostMaximum() {
        if (!numbersUsed.isEmpty()) {
            this.arbol.eliminarNodo(arbol.root, arbol.maximo().poder);
            gameController.updateInventory(arbol.inOrden());
            return true;
        } else {
            return false;
        }
    }
}
