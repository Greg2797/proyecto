package Pokemon;

public class Pokedex {
    
    //ATRIBUTOS
    private NodoPokemon cabeza;
    private int tamano;
    
    //GETTERS
    public NodoPokemon getCabeza(){
        return cabeza;
    }
    public int getTamano(){
        return tamano;
    }
    
    //CONSTRUCTOR
    public Pokedex(){
        this.cabeza=null;
        this.tamano=0;
    }//fin metodo
    
    //METODO PARA OBTENER UN POKEMON
    public Pokemon obtenerP(int index){
        if (index<0||index>=tamano) {
            return null;
        }
        NodoPokemon actual=cabeza;
        for (int i = 0; i < index; i++) {
            actual=actual.getSiguiente();
        }
        return actual.getPokemon();
    }//fin metodo
    
    //METODO PARA AGREGAR UN POKEMON
    public void agregar(Pokemon pokemon){
        if (!comprobacion(pokemon)) {
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
        }
    }//fin metodo
    
    //METODO DE COMPROBACION
    public boolean comprobacion(Pokemon pokemon){
        NodoPokemon actual=cabeza;
        while(actual!=null){
            if (actual.getPokemon().equals(pokemon.getNombre())) {
                return true;
            }
            actual=actual.getSiguiente();
        }
        return false;
    }//fin metodo
    
    // MÉTODO PARA IMPRIMIR EL CONTENIDO DE LA POKEDEX
    public void imprimirPokedex() {
        System.out.println("Pokedex del Usuario: ");
        NodoPokemon actual = cabeza;
        int index = 0;
        while (actual != null) {
            Pokemon pokemon = actual.getPokemon();
            System.out.println("Pokémon " + (index + 1) + ": " + pokemon.getNombre());
            actual = actual.getSiguiente();
            index++;
        }
    } // fin método

}//fin clase
