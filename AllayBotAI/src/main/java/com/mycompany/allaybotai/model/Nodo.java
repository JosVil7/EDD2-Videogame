package com.mycompany.allaybotai.model;

public class Nodo {
    String nombre;
    int poder;
    int coordenadaX, coordenadaY;
    Nodo izq, der;

    public Nodo(String nombre, int poder, int coordenadaX, int coordenadaY) {
        this.nombre = nombre;
        this.poder = poder;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.izq = null;
        this.der = null;
    }

    @Override
    public String toString() {
        return "Gema{" + "nombre='" + nombre + '\'' +
               ", poder=" + poder +
               ", x=" + coordenadaX +
               ", y=" + coordenadaY + '}';
    }
}

