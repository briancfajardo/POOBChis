package domain;

public class Ganadores {
    int rojo;
    int amarillo;
    int azul;
    int verde;

    public Ganadores(){

    }

    public int getColor(String color) {
        return switch (color) {
            case "Amarillo" -> amarillo;
            case "Azul" -> azul;
            case "Rojo" -> rojo;
            default -> verde;
        };
    }
    public void addColor(String color){
        switch (color) {
            case "Amarillo" -> amarillo += 1;
            case "Azul" -> azul += 1;
            case "Rojo" -> rojo += 1;
            default -> verde += 1;
        }
    }

    @Override
    public String toString(){
        String mensaje = "";
        mensaje += "Rojo :" + rojo + " ";
        mensaje += "Azul :" + azul + " ";
        mensaje += "Verde :" + verde + " ";
        mensaje += "Amarillo :" + amarillo + " ";
        return mensaje;
    }
}
