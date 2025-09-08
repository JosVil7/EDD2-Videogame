package com.mycompany.Tree;

public class Nodo {
    String valor;
    int poder;
    Nodo izq;
    Nodo der;

    public Nodo(String valor, int poder) {
        this.valor = valor;
        this.poder = poder;
        this.izq = null;
        this.der = null;
    }
    
    
}
