package domain;

public class Ficha extends Elemento{

    private String color;

    public Ficha (String color){
        this.color = color;
    }

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
