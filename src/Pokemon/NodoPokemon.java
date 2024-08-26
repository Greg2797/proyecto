package Pokemon;

public class NodoPokemon {
    
    //ATRIBUTOS
    private Pokemon pokemon;
    private NodoPokemon siguiente;
    
    //CONSTRUCTOR
    public NodoPokemon(Pokemon pokemon){
        this.pokemon=pokemon;
        this.siguiente=siguiente;
    }//fin metodo
    
    //GETTERS AND SETTERS
    public Pokemon getPokemon(){
        return pokemon;
    }
    public NodoPokemon getSiguiente(){
        return siguiente;
    }
    public void setSiguiente (NodoPokemon siguiente){
        this.siguiente=siguiente;
    }
}
