package domain;

import java.io.Serializable;
/**
 * Clase Ventajosa que representa una ficha de tipo saltarina del juego POOBChis
 */
public class Ventajosa extends Ficha implements Serializable {
    private int turnoJugador;
    private Parchis parchis;

    private Tablero tablero;
    /**
     * Constructor de la clase Ventajosa la cual se crea con un color que representa a que casa corresponde,
     * además hace uso del constructor de su padre Ficha
     * @param color casa a la que corresponde la ficha Ventajosa
     */
    public Ventajosa(String color) {
        super(color);
    }

    @Override
    public void usarPoder(Tablero tablero, String colorCasa, int numCasilla, Parchis parchis) {
        this.parchis = parchis;
        this.tablero = tablero;

        if (parchis.obtenerTurno().equals(this.color)){
            turnoJugador += 1;
        }

        if (turnoJugador == 2){
            parchis.setValor3(3);
            parchis.moverFicha(colorCasa, numCasilla);
            turnoJugador = 0;
        }else if (parchis.getValor1() == 3 || parchis.getValor2() == 3){
            parchis.setValor3(3);
            parchis.moverFicha(colorCasa, numCasilla);
        }
    }
}
