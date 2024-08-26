package Torneo;

import javax.swing.JFrame;

public class nodoTorneo {
    
    JFrame dato;
    nodoTorneo siguiente;
     
    
    public nodoTorneo(JFrame dato){
        this.dato=dato;
        this.siguiente=null;
    }
}
