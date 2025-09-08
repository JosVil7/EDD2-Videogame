package com.mycompany.Tree;

import javax.swing.JOptionPane;

public class ArbolBST {

    Nodo root;

    public ArbolBST() {
        this.root = null;
    }

    public void crearArbol(String valor, int power) {
        root = crearArbolR(root, valor, power);
    }

    Nodo crearArbolR(Nodo A, String valor, int poder) {
        if (A == null) {
            return new Nodo(valor, poder);
        }

        if (poder < A.poder) {
            A.izq = crearArbolR(A.izq, valor, poder);
        } else if (poder > A.poder) {
            A.der = crearArbolR(A.der, valor, poder);
        } else {
            JOptionPane.showMessageDialog(null, "La gema de valor:" + poder + " ya esta en el inventario, no se aceptan duplicados");
        }

        return A;
    }

    public Nodo Encontrar(int poder) {
        return EncontrarR(root, poder);
    }

    public Nodo EncontrarR(Nodo nodo, int poder) {
        if (nodo == null) {
            return null;
        } else if (poder == nodo.poder) {
            return nodo;
        } else if (poder < nodo.poder) {
            return EncontrarR(nodo.izq, poder);
        } else {
            return EncontrarR(nodo.der, poder);
        }
    }

    public void inOrden() {
        inOrdenRec(root);
    }

    public void inOrdenRec(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        inOrdenRec(nodo.izq);
        System.out.println(nodo);
        inOrdenRec(nodo.der);
    }

    public void preOrden() {
        preOrdenRec(root);
    }

    public void preOrdenRec(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println(nodo);
        preOrdenRec(nodo.izq);
        preOrdenRec(nodo.der);
    }

    public void postOrden() {
        postOrdenRec(root);
    }

    public void postOrdenRec(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        postOrdenRec(nodo.izq);
        postOrdenRec(nodo.der);
        System.out.println(nodo);
    }
    
    public Nodo minimo() {
        return minimoR(root);
    }

    private Nodo minimoR(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    public Nodo maximo() {
        return maximoR(root);
    }

    private Nodo maximoR(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        while (nodo.der != null) {
            nodo = nodo.der;
        }
        return nodo;
    }

}
