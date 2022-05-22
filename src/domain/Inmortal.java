package domain;

/**
 * Clase Inmortal la cual representa un tipo de comodín que vuelve a una ficha inmortal
 */
public class Inmortal extends Comodin{
    private Parchis parchis;
    private  String color;
    private int pos;

    /**
     * Constructor de la clase Inmortal que inicializa el comodín con el objeto Parchis, un color y una posición
     * correspondientes a su ubicación en el tablero del juego
     * @param parchis
     * @param color
     * @param pos
     */
    public Inmortal (Parchis parchis, String color, int pos){
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
        ((Ficha)parchis.getTablero().getElementosCasilla(color,pos).get(parchis.getTablero().getElementosCasilla(color,pos).size()-1)).setInmortal(true);

    }
}
