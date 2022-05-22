package domain;

import java.io.Serializable;

/**
 * Clase Aspiradora que representa una ficha tipo aspiradora en POOBChis
 */
public class Aspiradora extends Ficha implements Serializable {
    /**
     * Constructor de la clase tipo Aspiradora la cual hace uso del constructor de su padre, ficha, enviándole su color correspondiente
     * @param color color de la casa a la que pertenece
     */
    public Aspiradora(String color) {
        super(color);
    }
}
