package Batalla;

import Cpu.pokedexCPU;
import Pokemon.*;

public class Movimientos {

    // ATRIBUTOS
    private Pokedex pokedex;
    private pokedexCPU cpu;
    
    // CONSTRUCTOR
    public Movimientos(Pokedex pokedex, pokedexCPU cpu) {
        if (pokedex == null || cpu == null) {
            throw new IllegalArgumentException("Pokedex or cpu cannot be null");
        }
        this.pokedex = pokedex;
        this.cpu = cpu;
    }
    
    // Método para obtener el Pokémon del usuario
     private Pokemon pokemonPokedex(int index){
        return (index >= 0 && index < pokedex.getTamano()) ? pokedex.obtenerP(index) : null;
    }
    
    // Método para obtener el Pokémon del CPU
    private Pokemon pokemonCPU(int index){
        return (index >= 0 && index < cpu.getTamano()) ? cpu.obtenerP(index) : null;
    }
    
    // Método para comprobar tipo y ajustar stats
    public void comprobarTipo(Pokemon atacante, Pokemon defensor) {
        String tipoUsuario = atacante.getTipo();
        String tipoCpu = defensor.getTipo();
        
        if (tipoUsuario.equals("Normal") && tipoCpu.equals("Agua")) {
            atacante.setAtaqueEspecial(atacante.getAtaqueEspecial() + 5);
            atacante.setDefensaEspecial(atacante.getDefensaEspecial() + 5);
        } else if (tipoUsuario.equals("Fuego") && tipoCpu.equals("Normal")) {
            atacante.setAtaqueEspecial(atacante.getAtaqueEspecial() + 5);
            atacante.setDefensaEspecial(atacante.getDefensaEspecial() + 5);
        } else if (tipoUsuario.equals("Agua") && tipoCpu.equals("Fuego")) {
            atacante.setAtaqueEspecial(atacante.getAtaqueEspecial() + 10);
            atacante.setDefensaEspecial(atacante.getDefensaEspecial() + 10);
        }
    }
    
    // Método para atacar
    public void atacar(int indexAtacante, int indexDefensor) {
        Pokemon atacante = pokemonPokedex(indexAtacante);
        Pokemon defensor = pokemonCPU(indexDefensor);

        if (atacante == null || defensor == null) {
            System.out.println("Uno de los pokemones no está disponible");
            return;
        }

        int danio = atacante.getAtaque() - defensor.getDefensa();
        defensor.setHp(defensor.getHp() - danio);
    }
    
    // Método para ataque especial
    public void atacarEspecial(int indexAtacante, int indexDefensor) {
        Pokemon atacante = pokemonPokedex(indexAtacante);
        Pokemon defensor = pokemonCPU(indexDefensor);

        if (atacante == null || defensor == null) {
            System.out.println("Uno de los pokemones no está disponible");
            return;
        }

        int danio = Math.max(0, atacante.getAtaqueEspecial() - defensor.getDefensaEspecial());
        defensor.setHp(defensor.getHp() - danio);
        System.out.println(atacante.getNombre() + " ha realizado un ataque especial a " + defensor.getNombre() + " causando " + danio + " de daño.");
    }
    
    // Método para defensa
    public void defender(int indexAtacante) {
        Pokemon atacante = pokemonPokedex(indexAtacante);
        
        if (atacante == null) {
            System.out.println("Uno de los pokemones no está disponible");
            return;
        }
        // Implement actual defense logic if needed
    }
    
    // Método para defensa especial
    public void defensaEspecial(int indexAtacante) {
        Pokemon atacante = pokemonPokedex(indexAtacante);
        
        if (atacante == null) {
            System.out.println("Uno de los pokemones no está disponible");
            return;
        }
        // Implement actual special defense logic if needed
    }
    
    // Método para cambiar Pokémon
    public void cambiarPokemon(int indexActual){
        Pokemon nuevo = pokemonPokedex(indexActual);
        if (nuevo == null) {
            System.out.println("El pokemon que seleccionaste no está disponible");
            return;
        }
        System.out.println("El Pokémon activo ha sido cambiado a " + nuevo.getNombre() + ".");
    }
}
