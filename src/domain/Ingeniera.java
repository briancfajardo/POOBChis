package domain;

public class Ingeniera extends Ficha{
    Tablero tablero;
    public Ingeniera(String color) {
        super(color);
    }
    @Override
    public void usarPoder(Tablero tablero, String colorCasa ,int numCasilla, Parchis parchis){
        this.tablero = tablero;
        tablero.getCasilla(colorCasa, numCasilla).setSeguro();
    }
}
