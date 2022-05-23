package domain;

import java.io.Serializable;

/**
 * Clase Fichas que representa una ficha del juego POOBChis, además hereda de Elemento y sirve de padre para todos los tipos
 * de fichas
 */
public class Ficha extends Elemento implements Serializable {

    protected String color;
    protected boolean inmortal = false;

    /**
     * Constructor de la clase Ficha que asigna su atributo color
     * @param color color de la ficha
     */
    public Ficha (String color){
        this.color = color;
    }

    /**
     * Método que hace uso de su poder dependiendo del tipo de ficha
     * @param tablero objeto tablero perteneciente a la clase Parchis
     * @param colorCasa Color de la casa donde se encuentra ubicada la ficha
     * @param numCasilla posición de la casilla dónde se encuentra la ficha
     * @param parchis Objeto Parchis
     */
    public void usarPoder(Tablero tablero, String colorCasa ,int numCasilla, Parchis parchis){}

    /**
     * Método que retorna el color de la ficha
     * @return color de la ficha
     */
    public String getColor(){
        return color;
    }

    /**
     * Método que retorna si la ficha es inmortal o nó
     * @return booleano del atributo inmortal que dice si la ficha es inmortal
     */
    public boolean isInmortal() {
        return inmortal;
    }

    /**
     * Métodoq que hace una ficha inmortal
     * @param inmortal booleano que reemplaza el atributo inmortal
     */
    public void setInmortal(boolean inmortal) {
        this.inmortal = inmortal;
    }
    @Override
    public String toString(){
        String mensaje = "";
        mensaje += getClass() + " ";
        mensaje += color;
        return mensaje;
    }
}
