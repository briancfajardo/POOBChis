package domain;

import java.io.Serializable;

public class Ficha extends Elemento implements Serializable {

    protected String color;
    protected boolean inmortal = false;

    public Ficha (String color){
        this.color = color;
    }

    public void usarPoder(Tablero tablero, String colorCasa ,int numCasilla, Parchis parchis){}

    public String getColor(){
        return color;
    }

    public boolean isInmortal() {
        return inmortal;
    }

    public void setInmortal(boolean inmortal) {
        this.inmortal = inmortal;
    }
    //@Override
    //public String toString(){
    //    String mensaje = "";
    //    mensaje += getClass() + " ";
    //    mensaje += color;
    //    return mensaje;
    //}
}
