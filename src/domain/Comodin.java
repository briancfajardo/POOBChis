package domain;

import java.io.Serializable;

/**
 * Clase abstracta que representa un comodín del juego POOBChis
 */
public abstract class Comodin extends Elemento implements Serializable {
    protected Parchis parchis;
    protected  String color;
    protected int pos;
    /**
     * Constructor de la clase comodín
     */
    public Comodin(){

    }

    /**
     * Método abstracto que muestra una breve descripción de la funcionalidad del comodín
     */
    public abstract void mostrarPoder();

    /**
     * Método que realiza el poder del comodín correspondiente
     */
    public abstract void usarPoder();

}
