package domain;
/**
 * Clase SacarCarcel que representa al comodín Sacar de la cárcel el cual tiene como poder sacar una ficha de la cárcel si es posible
 */
public class SacarCarcel extends Comodin{

    /**
     * Constructor de la clase SacarCarcel
     * @param parchis Objeto tipo Parchis
     * @param color color de la casa donde se encuentra ubicado el comodín
     * @param pos posición de la casilla donde se encuentra ubicado el comodín
     */
    public SacarCarcel(Parchis parchis, String color, int pos){
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
        String turno = parchis.obtenerTurno();
        if(parchis.getTablero().cantElementosSalida(turno) < 2){
            Ficha f = parchis.getTablero().salirCarcel(turno);
            parchis.getTablero().nuevaFicha(turno,4,f);
        }
    }
}
