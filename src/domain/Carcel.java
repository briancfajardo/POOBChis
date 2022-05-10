package domain;

public class Carcel {
    int rojo;
    int amarillo;
    int azul;
    int verde;

    public Carcel(){
        rojo = 4;
        amarillo = 4;
        azul = 4;
        verde = 4;
    }

    public int getColor(String color) {
        return switch (color) {
            case "Amarillo" -> amarillo;
            case "Azul" -> azul;
            case "Rojo" -> rojo;
            default -> verde;
        };
    }
    public void setColor(String color){
        switch (color) {
            case "Amarillo" -> amarillo -= 1;
            case "Azul" -> azul -= 1;
            case "Rojo" -> rojo -= 1;
            default -> verde -= 1;
        }
    }
    public void setColormas(String color){
        switch (color) {
            case "Amarillo" -> amarillo -= 1;
            case "Azul" -> azul += 1;
            case "Rojo" -> rojo += 1;
            default -> verde += 1;
        }
    }
}
