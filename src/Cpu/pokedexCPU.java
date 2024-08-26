package Cpu;

import Pokemon.*;
import java.util.Random;


public class pokedexCPU {
    // ATRIBUTOS
    private NodoPokemon cabeza;
    private NodoPokemon seleccionados;
    private int tamano;
    private int seleccionadosTamano;

    // CONSTRUCTOR
    public pokedexCPU() {
        this.cabeza = null;
        this.tamano = 0;
        this.seleccionados=null;
        this.seleccionadosTamano=0;
        inicializarPokemones();
        seleccionarPokemonesAleatorios();
    }
    
    public int getTamano(){
        return tamano;
    }

    // INICIALIZAR TODOS LOS POKEMONES
    private void inicializarPokemones() {
        agregarAListaPrincipal(new Pokemon("Evee", "Normal", 150, 50, 35, 70, 60));
        agregarAListaPrincipal(new Pokemon("Snorlax", "Normal", 150, 50, 35, 70, 60));
        agregarAListaPrincipal(new Pokemon("JigglyPuff", "Normal", 150, 50, 35, 70, 60));
        agregarAListaPrincipal(new Pokemon("Charmander", "Fuego", 115, 70, 45, 80, 60));
        agregarAListaPrincipal(new Pokemon("Vulpix", "Fuego", 115, 70, 45, 80, 60));
        agregarAListaPrincipal(new Pokemon("Growlithe", "Fuego", 115, 70, 45, 80, 60));
        agregarAListaPrincipal(new Pokemon("Squirtle", "Agua", 190, 55, 45, 75, 65));
        agregarAListaPrincipal(new Pokemon("Psyduck", "Agua", 190, 55, 45, 75, 65));
        agregarAListaPrincipal(new Pokemon("Poliwag", "Agua", 190, 55, 45, 75, 65));
    }//fin metodo

    
    
    private void agregarAListaPrincipal(Pokemon pokemon){
        NodoPokemon nuevoNodo=new NodoPokemon(pokemon);
        if (cabeza==null) {
            cabeza=nuevoNodo;
        }else{
            NodoPokemon actual=cabeza;
            while(actual.getSiguiente()!=null){
                actual=actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamano++;
    }//fin metodo
    
    
    
    // METODO PARA OBTENER UN POKEMON
    public Pokemon obtenerP(int index) {
        if (index < 0 || index >= seleccionadosTamano) {
            return null;
        }
        NodoPokemon actual = seleccionados;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getPokemon();
    }//fin metodo

    
    
    // METODO PARA AGREGAR UN POKEMON A LA LISTA DE SELECCIONADOS
    private void agregarAListaSeleccionados(Pokemon pokemon) {
        NodoPokemon nuevoNodo=new NodoPokemon(pokemon);
        nuevoNodo.setSiguiente(seleccionados);
        seleccionados=nuevoNodo;
        seleccionadosTamano++;
    }//fin metodo
    
    
    
    //METODO PARA SELECCIONAR 4 POKEMONES ALEATORIOS
    private void seleccionarPokemonesAleatorios(){
        if (tamano<4) {
            System.out.println("No hay suficientes pokemones para seleccionar 4");
            return;
        }
        Random random=new Random();
        for (int i = 0; i < 4;) {
            int index=random.nextInt(tamano);
            NodoPokemon temp=cabeza;
            for (int j = 0; j < index; j++) {
                temp=temp.getSiguiente();
            }
            if (!contiene(seleccionados, temp.getPokemon())) {
                agregarAListaSeleccionados(temp.getPokemon());
                i++;
            }
        }
        NodoPokemon actual=seleccionados;
        while(actual!=null){
            System.out.println(actual.getPokemon());
            actual=actual.getSiguiente();
        }
    }//fin metodo
    
    
    
    private boolean contiene(NodoPokemon lista,Pokemon pokemon){
        NodoPokemon actual=lista;
        while(actual!=null){
            if (actual.getPokemon().getNombre().equals(pokemon.getNombre())) {
                return true;
            }
            actual=actual.getSiguiente();
        }
        return false;
    }//fin metodo
    
    public void imprimirListaSeleccionados() {
        if (seleccionadosTamano == 0) {
            System.out.println("La lista de pokemones seleccionados está vacía.");
        } else {
            NodoPokemon actual = seleccionados;
            while (actual != null) {
                actual = actual.getSiguiente();
            }
        }
    }//fin metodo


}//fin metodo


