package Batalla;

import Cpu.pokedexCPU;
import Pokemon.*;
import Torneo.Torneo;
import Vista.vistaBatalla;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Batalla {

    // ATRIBUTOS VISUALES
    private JLabel jLUsuario;
    private JLabel jLSalud;
    private JLabel lblPokemonUsuario;
    private JLabel lblPokemonCPU;
    private JLabel jLGanador;
    private JPanel jPanel1;
    private vistaBatalla vistaBatalla;

    // ATRIBUTOS
    private Movimientos movimientos;
    private Pokedex pokedex;
    private pokedexCPU cpu;
    private Pokemon pokemonUsuario;
    private Pokemon pokemonCPU;
    private JButton nuevoBoton;
    private int contadorCambios = 0;
    private Torneo torneo;

    // CONSTRUCTOR
    public Batalla(Pokedex pokedex, pokedexCPU cpu, JLabel jLUsuario, JLabel jLSalud, JLabel lblPokemonUsuario, JLabel lblPokemonCPU, JLabel jLGanador, JPanel jPanel1, vistaBatalla vistaBatalla) {
        this.pokedex = pokedex;
        this.cpu = cpu;
        this.movimientos = new Movimientos(pokedex, cpu);
        this.jLUsuario = jLUsuario;
        this.jLSalud = jLSalud;
        this.lblPokemonUsuario = lblPokemonUsuario;
        this.lblPokemonCPU = lblPokemonCPU;
        this.jLGanador = jLGanador;
        this.jPanel1 = jPanel1;
        this.vistaBatalla = vistaBatalla;
        reiniciarEstado();
    }

    // SETTER
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    // METODO PARA AGREGAR BOTON
    public void agregarNuevoBoton() {
        if (nuevoBoton == null) {
            nuevoBoton = new JButton("Siguiente Ronda");
            nuevoBoton.setBounds(jLGanador.getX() + jLGanador.getWidth() + 5, jLGanador.getY(), 170, 30);
            nuevoBoton.addActionListener(e -> {
                if (torneo != null) {
                    torneo.avanzar();
                } else {
                    System.out.println("Torneo es null");
                }
            });
            jPanel1.add(nuevoBoton);
            jPanel1.revalidate();
            jPanel1.repaint();
        }
    }

    // Método actualizar salud
    public void actualizarSalud() {
        if (pokemonUsuario != null) {
            jLUsuario.setText(pokemonUsuario.getNombre() + " (HP: " + pokemonUsuario.getHp() + ")");
            lblPokemonUsuario.setText(pokemonUsuario.getNombre());
            lblPokemonUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + pokemonUsuario.getNombre().toLowerCase() + "Usu" + ".gif")));
        } else {
            jLUsuario.setText("Salud Usuario: N/A");
        }
        if (pokemonCPU != null) {
            jLSalud.setText(pokemonCPU.getNombre() + " (HP: " + pokemonCPU.getHp() + ")");
            lblPokemonCPU.setText(pokemonCPU.getNombre());
            lblPokemonCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + pokemonCPU.getNombre().toLowerCase() + ".gif")));
        } else {
            jLSalud.setText("Salud CPU: N/A");
        }
    }

    // Método comprobación vida CPU
    public void comprobacionVidaCPU() {
        boolean derrotados = true;
        for (int i = 0; i < 4; i++) {
            Pokemon pokemon = cpu.obtenerP(i);
            if (pokemon != null && pokemon.getHp() > 0) {
                pokemonCPU = pokemon;
                lblPokemonCPU.setText(pokemonCPU.getNombre());
                movimientos.atacar(0, i);
                actualizarSalud();
                derrotados = false;
                break;
            }
        }
        if (derrotados) {
            jLSalud.setText("");
            lblPokemonCPU.setIcon(null);
            jLGanador.setText("FELICIDADES, HAS GANADO, HAS PASADO A LA SIGUIENTE RONDA");
            if (vistaBatalla != null) {
                agregarNuevoBoton();
            } else {
                System.out.println("VistaBatalla es null");
            }
        }
    }

    // Método vida CPU
    public void vidaCPU() {
        boolean hayVida = false;
        for (int i = 0; i < 4; i++) {
            Pokemon pokemon = cpu.obtenerP(i);
            if (pokemon != null && pokemon.getHp() > 0) {
                hayVida = true;
                break;
            }
        }
        if (hayVida) {
            comprobacionVidaCPU();
        }
    }

    // Método cambiar Pokémon
    public void cambiarPokemon() {
        if (contadorCambios < 3) {
            Pokemon nuevoPokemon = pokedex.obtenerP(++contadorCambios % pokedex.getTamano());
            if (nuevoPokemon != null) {
                this.pokemonUsuario = nuevoPokemon;
                lblPokemonUsuario.setText(pokemonUsuario.getNombre());
                actualizarSalud();
            } else {
                System.out.println("El Pokémon que seleccionaste no está disponible");
            }
        } else {
            System.out.println("Has alcanzado el límite de cambios de Pokémon");
        }
    }

    // Método reiniciar estado
    public void reiniciarEstado() {
        if (pokedex.getTamano() > 0) {
            this.pokemonUsuario = pokedex.obtenerP(0);
        } else {
            System.out.println("Error: La pokedex no tiene Pokémon");
            this.pokemonUsuario = null;
        }

        if (cpu.getTamano() > 0) {
            this.pokemonCPU = cpu.obtenerP(0);
        } else {
            System.out.println("Error: La CPU no tiene Pokémon");
            this.pokemonCPU = null;
        }

        if (pokemonUsuario != null && pokemonCPU != null) {
            lblPokemonUsuario.setText(pokemonUsuario.getNombre());
            lblPokemonCPU.setText(pokemonCPU.getNombre());
        } else {
            System.out.println("Error: Uno de los Pokémon es null");
        }
        actualizarSalud();
    }
}
