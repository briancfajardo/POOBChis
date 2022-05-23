package domain;
/**
 * Clase IrseCarcel la cual representa un tipo de comodín que hace que una ficha retroceda 5 casillas automáticamente.
 */
public class IrseCarcel extends Comodin{
    /**
     * Constructor de la clase IrseCarcel que inicializa el comodín con el objeto Parchis, un color y una posición
     * correspondientes a su ubicación en el tablero del juego
     * @param parchis
     * @param color
     * @param pos
     */
    public IrseCarcel(Parchis parchis, String color, int pos){
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
        Ficha f = ((Ficha) parchis.getTablero().getElementosCasilla(color,pos).get(0));
        parchis.getTablero().volverCarcel(color,f);
        parchis.getTablero().getCasilla(color, pos).getElementos().remove(0);
    }
}
