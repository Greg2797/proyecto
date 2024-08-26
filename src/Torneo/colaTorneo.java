package Torneo;

import javax.swing.JFrame;

public class colaTorneo {

    private nodoTorneo frente;
    private nodoTorneo finalDeCola;

    public colaTorneo() {
        frente = null;
        finalDeCola = null;
    }

    public void encolar(JFrame dato) {
        nodoTorneo nuevoNodo = new nodoTorneo(dato);
        if (finalDeCola != null) {
            finalDeCola.siguiente = nuevoNodo;
        }
        finalDeCola = nuevoNodo;
        if (frente == null) {
            frente = nuevoNodo;
        }
    }

    public JFrame desencolar() {
        if (frente == null) {
            return null;
        }
        JFrame dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            finalDeCola = null;
        }
        return dato;
    }

    public boolean vacia() {
        return frente == null;
    }

    public int tamaño() {
        int tamaño = 0;
        nodoTorneo actual = frente;
        while (actual != null) {
            tamaño++;
            actual = actual.siguiente;
        }
        return tamaño;
    }
}

