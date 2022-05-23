package domain;

/**
 * Clase QuitarFicha que es la representación del comodín que tiene el poder de quitar la ficha más avanzada del oponente
 */
public class QuitarFicha extends Comodin{

    /**
     * Constructor de la clase QuitarFicha
     * @param parchis Objeto tipo Parchis que es la clase controladora del juego en la parte de dominio
     * @param color Color de la casa donde se encuentra el comodín
     * @param pos posición del comodín dentro del arreglo de casillas
     */
    public QuitarFicha (Parchis parchis, String color, int pos){
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
        String masLejos;
        String colorOpuesto;
        Ficha f;
        if(turno.equals("Rojo")){
            colorOpuesto = "Amarillo";
            masLejos = parchis.getMasLejos(colorOpuesto);
        }else {
            colorOpuesto = "Rojo";
            masLejos = parchis.getMasLejos(colorOpuesto);
        }
        String [] colorPos = masLejos.split(" ");
        String colorC = colorPos[0];
        int pos = Integer.parseInt(colorPos[1]);
        if(colorOpuesto.equals(((Ficha) parchis.getTablero().getElementosCasilla(colorC,pos).get(0)).getColor())){
            f = ((Ficha) parchis.getTablero().getElementosCasilla(colorC,pos).get(0));
        } else {
            f = ((Ficha) parchis.getTablero().getElementosCasilla(colorC,pos).get(1));
        }
        parchis.getTablero().volverCarcel(f.getColor(),f);
        parchis.getTablero().getCasilla(colorC, pos).getElementos().remove(f);
    }
}
