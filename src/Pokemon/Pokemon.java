package Pokemon;

public class Pokemon {
    
    
    //ATRIBUTOS
    private String nombre;
    private String tipo;
    private int hp;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    
    
    //CONSTRUCTOR
    public Pokemon(String nombre,String tipo, int hp, int ataque,int defensa,int ataqueEspecial,int defensaEspecial){
        this.nombre=nombre;
        this.tipo=tipo;
        this.hp=hp;
        this.ataque=ataque;
        this.defensa=defensa;
        this.ataqueEspecial=ataqueEspecial;
        this.defensaEspecial=defensaEspecial;
    }//fin metodo

    
    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }
    public int getDefensaEspecial() {
        return defensaEspecial;
    }
    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", tipo=" + tipo + ", hp=" + hp + ", ataque=" + ataque + ", defensa=" + defensa + ", ataqueEspecial=" + ataqueEspecial + ", defensaEspecial=" + defensaEspecial + '}';
    }

}
