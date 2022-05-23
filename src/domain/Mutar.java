package domain;
/**
 * Clase Mutar la cual representa un tipo de comodín que hace que una ficha cambie de tipo transformandose en
 * una seleccionada aleatoriamente entre las que no tenga el jugador en turno.
 */
public class Mutar extends Comodin{

    /**
     * Constructor de la clase Mutar que inicializa el comodín con el objeto Parchis, un color y una posición
     * correspondientes a su ubicación en el tablero del juego
     * @param parchis
     * @param color
     * @param pos
     */
    public Mutar(Parchis parchis, String color, int pos){
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

    }
}
