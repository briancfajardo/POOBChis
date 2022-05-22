package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Casilla que representa una casilla del juego POOBChis
 */
public class Casilla implements Serializable {
    private ArrayList<Elemento> elementos;
    private boolean bloqueado = false;

    private boolean seguro = false;

    /**
     * Constructor de la clase Casilla el cual inicializa un arreglo de elementos vacío
     */
    public Casilla(){
        elementos = new ArrayList<Elemento>();
    }

    /**
     * Método que cambia el atributo de bloqueado a verdadero
     */
    public void setBloqueado(){
        bloqueado = true;
    }

    /**
     * Método que cambia el atributo de seguro a verdadero
     */
    public void setSeguro(){
        seguro = true;
    }

    /**
     * Método que cambia el atributo de bloqueado a falso
     */
    public void quitarBloqueo(){
        bloqueado = false;
    }

    /**
     * Método que retorna un arreglo con los elementos que contiene la casilla
     * @return arreglo de elementos
     */
    public ArrayList<Elemento> getElementos(){
        return elementos;
    }

    /**
     * Método que agrega un nuevo elemento al arreglo de elementos, puede ser una ficha o un comodín
     * @param nuevoElemento elemento a agregar al arreglo de elementos
     */
    public void agregarUno(Elemento nuevoElemento) {
        elementos.add(nuevoElemento);
    }

    /**
     * Método para hacer uso de un comodín cuando una ficha cáe sobre esta casilla
     * @param comodin elemento comodín que del cual se le usará el poder
     * @param ficha elemento ficha a la cual se le aplicará el poder del comodín
     */

    public void tomarComodin(Comodin comodin, Ficha ficha){
        comodin.mostrarPoder();
    }

    /**
     * Método que remueve un elemento de la casilla
     * @param elemento elemento que se desea eliminar
     */
    public void quitarElemento(Elemento elemento){
        elementos.remove(elemento);
    }

    /**
     * Método que dice si la casilla está bloqueada
     * @return booleano que dice si la casilla está bloqueada
     */
    public boolean isBloqueado(){
        return bloqueado;
    }

    /**
     * Método que dice si la casilla es segura
     * @return booleano que dice si la casilla es segura
     */
    public boolean isSeguro(){
        return seguro;
    }

    //@Override
    //public String toString(){
    //    String mensaje = "";
    //    mensaje += "clase: " + getClass() + "\n";
    //    mensaje += "elementos: " + getElementos().toString() + "\n";
    //    mensaje += "esSeguro: " + seguro + "\n";
    //    mensaje += "estaBloqueado: " + bloqueado + "\n";
    //    return mensaje;
    //}

}
