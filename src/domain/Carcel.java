package domain;

import java.util.ArrayList;

public class Carcel {
    int rojo = 4;
    int amarillo = 4;
    int azul =4;
    int verde = 4;

    public Carcel(){

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
}
