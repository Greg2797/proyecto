package Torneo;

import Cpu.pokedexCPU;
import Pokemon.*;
import Vista.*;
import javax.swing.JFrame;


public class Torneo {
    
    private colaTorneo fases;
    private Pokedex pokedex;
    private pokedexCPU pCPU;
    
    
    public Torneo(Pokedex pokedex,pokedexCPU pCPU){
        this.pokedex=pokedex;
        this.pCPU=pCPU;
        fases=new colaTorneo();
        fases.encolar(new cuartosFinal(pokedex, pCPU));
    }
    
    private void faseActual(){
        JFrame faseActual=fases.desencolar();
        if (faseActual!=null) {
            faseActual.setVisible(true);
        }else{
            System.out.println("EL TORNEO HA TERMINADO");
        }
    }//fin metodo
    
    public void avanzar(){
        faseActual();
    }
}
