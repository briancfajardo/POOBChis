package domain;

/**
 * Clase que representa al comodín Retroceder el cual tiene como poder hacer que la ficha que lo obtenga retroceda 5 casillas
 */
public class Retroceder extends Comodin{

    /**
     * Constructor de la clase Retroceder
     * @param parchis Objeto tipo Parchis
     * @param color color de la casa donde se encuentra ubicado el comodín
     * @param pos posición de la casilla donde se encuentra ubicado el comodín
     */
    public Retroceder(Parchis parchis, String color, int pos){
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
        parchis.setValor3(-5);
        parchis.moverFicha(color, pos);
    }
}
