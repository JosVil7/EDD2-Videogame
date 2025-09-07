/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.allaybotai.model;

/**
 *
 * @author Angie
 */
public class TileItem {

    private TileItem tileItem;
    private int x;
    private int y;
    private int value;

    private TileItem() {
        this.x = 3;
        this.y = 0;
        this.value = 0;
    }

    public TileItem getPosition() {
        if (this.tileItem == null) {
            this.tileItem = new TileItem();
        }
        return tileItem;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
