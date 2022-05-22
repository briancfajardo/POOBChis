package domain;

import java.io.Serializable;

/**
 * Clase Cohete que representa una ficha tipo cohete en POOBChis
 */
public class Cohete extends Ficha implements Serializable {
    /**
     * Constructor de la clase tipo cohete la cual hace uso del constructor de su padre, ficha, enviándole su color correspondiente
     * @param color color de la casa a la que pertenece
     */
    public Cohete(String color) {
        super(color);
    }


}
