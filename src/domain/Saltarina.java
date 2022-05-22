package domain;

import java.io.Serializable;
/**
 * Clase Ingeniera que representa una ficha de tipo saltarina del juego POOBChis
 */
public class Saltarina extends Ficha implements Serializable {
    /**
     * Constructor de la clase ingeniera la cual se crea con un color que representa a que casa corresponde,
     * además hace uso del constructor de su padre Ficha
     * @param color casa a la que corresponde la ficha Saltarina
     */
    public Saltarina(String color) {
        super(color);
    }
}
