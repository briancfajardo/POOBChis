package domain;

import java.io.Serializable;

/**
 * Clase Ingeniera que representa una ficha de tipo ingeniera del juego POOBChis
 */
public class Ingeniera extends Ficha implements Serializable {
    Tablero tablero;

    /**
     * Constructor de la clase ingeniera la cual se crea un color que representa a que casa corresponde,
     * además hace uso del constructor de su padre Ficha
     * @param color casa a la que corresponde la ficha ingeniera
     */
    public Ingeniera(String color) {
        super(color);
    }
    @Override
    public void usarPoder(Tablero tablero, String colorCasa ,int numCasilla, Parchis parchis){
        this.tablero = tablero;
        tablero.getCasilla(colorCasa, numCasilla).setSeguro();
    }
}
