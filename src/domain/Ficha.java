package domain;

public class Ficha extends Elemento{

    protected String color;

    public Ficha (String color){
        this.color = color;
    }

    public void usarPoder(Tablero tablero, String colorCasa ,int numCasilla, Parchis parchis){}

    public String getColor(){
        return color;
    }

    @Override
    public String toString(){
        String mensaje = "";
        mensaje += getClass() + " ";
        mensaje += color;
        return mensaje;
    }
}
