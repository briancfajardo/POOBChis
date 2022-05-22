package domain;
/**
 * Clase JugarDoble la cual representa un tipo de comodín que hace que un jugador puedo tirar una vez más el dado.
 */
public class JugarDoble extends Comodin{
    private Parchis parchis;
    private  String color;
    private int pos;
    /**
     * Constructor de la clase JugarDoble que inicializa el comodín con el objeto Parchis, un color y una posición
     * correspondientes a su ubicación en el tablero del juego
     * @param parchis
     * @param color
     * @param pos
     */
    public JugarDoble(Parchis parchis, String color, int pos){
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
