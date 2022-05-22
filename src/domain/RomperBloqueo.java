package domain;
/**
 * Clase que representa al comodín Romper bloqueo el cual tiene como poder hacer que el bloqueo más cercano sea destruido
 */
public class RomperBloqueo extends Comodin{

    private Parchis parchis;
    private  String color;
    private int pos;
    /**
     * Constructor de la clase RomperBloqueo
     * @param parchis Objeto tipo Parchis
     * @param color color de la casa donde se encuentra ubicado el comodín
     * @param pos posición de la casilla donde se encuentra ubicado el comodín
     */
    public RomperBloqueo (Parchis parchis, String color, int pos){
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
        String masCerca;
        if(parchis.getTablero().verificarBloqueoComodin(color, pos, parchis.obtenerTurno()) != null){
            masCerca = parchis.getTablero().verificarBloqueoComodin(color, pos, parchis.obtenerTurno());
            String [] colorPos = masCerca.split(" ");
            String colorC = colorPos[0];
            int pos = Integer.parseInt(colorPos[1]);
            parchis.setValor3(1);
            parchis.moverFicha(colorC,pos);
        }
    }
}
