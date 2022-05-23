package domain;

import java.io.Serializable;
/**
 * Clase Avanzar la cual representa un tipo de comodín que hace que una ficha avance 5 casillas automáticamente.
 */
public class Avanzar extends Comodin implements Serializable {
    /**
     * Constructor de la clase Avanzar que inicializa el comodín con el objeto Parchis, un color y una posición
     * correspondientes a su ubicación en el tablero del juego
     * @param parchis
     * @param color
     * @param pos
     */
    public Avanzar(Parchis parchis, String color, int pos){
        super();
        this.parchis = parchis;
        this.color = color;
        this.pos = pos;
    }

    @Override
    public void mostrarPoder() {

    }

    @Override
    public void usarPoder() {
        parchis.setValor3(5);
        parchis.moverFicha(color, pos);
    }
}
