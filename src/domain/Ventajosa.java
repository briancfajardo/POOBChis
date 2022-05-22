package domain;

import java.io.Serializable;

public class Ventajosa extends Ficha implements Serializable {
    private int turnoJugador;
    private Parchis parchis;

    private Tablero tablero;

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
