package com.mycompany.allaybotai.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArbolBST {

    Nodo root;

    public ArbolBST() {
        this.root = null;
    }

    public void addNodo(String nombre, int poder, int x, int y) {
        root = crearArbolR(root, nombre, poder, x, y);
    }

    private Nodo crearArbolR(Nodo A, String nombre, int poder, int x, int y) {
        if (A == null) {
            return new Nodo(nombre, poder, x, y);
        }

        if (poder < A.poder) {
            A.izq = crearArbolR(A.izq, nombre, poder, x, y);
        } else if (poder > A.poder) {
            A.der = crearArbolR(A.der, nombre, poder, x, y);
        } else {
            JOptionPane.showMessageDialog(null,
                    "La gema de poder: " + poder + " ya está en el inventario, no se aceptan duplicados");
        }

        return A;
    }

    public Nodo Encontrar(int poder) {
        return EncontrarR(root, poder);
    }

    private Nodo EncontrarR(Nodo nodo, int poder) {
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

    public ArrayList<String> inOrden() {
        return inOrdenRec(root, new ArrayList<>());
    }

    private ArrayList<String> inOrdenRec(Nodo nodo, ArrayList<String> list) {
        if (nodo == null) {
            return list;
        }
        inOrdenRec(nodo.izq, list);
        list.add(nodo.nombre + " [" + nodo.poder + "]");
        inOrdenRec(nodo.der, list);
        return list;

    }

    public void preOrden() {
        preOrdenRec(root);
    }

    private void preOrdenRec(Nodo nodo) {
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

    private void postOrdenRec(Nodo nodo) {
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

    public Nodo sucesor(Nodo nodo) {
        if (nodo == null) {
            return null;
        }

        if (nodo.der != null) {
            return minimoR(nodo.der);
        }

        Nodo sucesor = null;
        Nodo actual = root;
        while (actual != null) {
            if (nodo.poder < actual.poder) {
                sucesor = actual;
                actual = actual.izq;
            } else if (nodo.poder > actual.poder) {
                actual = actual.der;
            } else {
                break;
            }
        }
        return sucesor;
    }

    public Nodo predecesor(Nodo nodo) {
        if (nodo == null) {
            return null;
        }

        if (nodo.izq != null) {
            return maximoR(nodo.izq);
        }

        Nodo predecesor = null;
        Nodo actual = root;
        while (actual != null) {
            if (nodo.poder > actual.poder) {
                predecesor = actual;
                actual = actual.der;
            } else if (nodo.poder < actual.poder) {
                actual = actual.izq;
            } else {
                break;
            }
        }
        return predecesor;
    }

    public void eliminar(int A) {
        root = eliminarNodo(root, A);
    }

    public Nodo eliminarNodo(Nodo nodo, int poder) {
        if (nodo == null) {
            return null;
        }

        if (poder < nodo.poder) {
            nodo.izq = eliminarNodo(nodo.izq, poder);
        } else if (poder > nodo.poder) {
            nodo.der = eliminarNodo(nodo.der, poder);
        } else {
            //Nodo sin hijos o con un solo hijo
            if (nodo.izq == null) {
                return nodo.der;
            } else if (nodo.der == null) {
                return nodo.izq;
            }

            //Nodo con dos hijos
            Nodo sucesorNodo = minimoR(nodo.der);
            nodo.poder = sucesorNodo.poder;
            nodo.nombre = sucesorNodo.nombre;
            nodo.coordenadaX = sucesorNodo.coordenadaX;
            nodo.coordenadaY = sucesorNodo.coordenadaY;

            nodo.der = eliminarNodo(nodo.der, sucesorNodo.poder);
        }
        return nodo;
    }

public Nodo eliminarCercano(int poder) {
    Nodo nodoExistente = this.Encontrar(poder);

    if (nodoExistente != null) {
        this.eliminar(poder);
        return nodoExistente;
    }

    Nodo predecesorNodo = this.predecesor(new Nodo("temp", poder, 0, 0));
    Nodo sucesorNodo = this.sucesor(new Nodo("temp", poder, 0, 0));

    if (predecesorNodo == null && sucesorNodo == null) {
        return null; 
    }

    if (predecesorNodo != null && sucesorNodo != null) {
        int diffPredecesor = Math.abs(poder - predecesorNodo.poder);
        int diffSucesor = Math.abs(poder - sucesorNodo.poder);

        if (diffPredecesor <= diffSucesor) {
            this.eliminar(predecesorNodo.poder);
            return predecesorNodo;
        } else {
            this.eliminar(sucesorNodo.poder);
            return sucesorNodo;
        }
    } else if (predecesorNodo != null) {

        this.eliminar(predecesorNodo.poder);
        return predecesorNodo;
    } else { 
        this.eliminar(sucesorNodo.poder);
        return sucesorNodo;
    }
}

}
