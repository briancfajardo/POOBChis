package domain;

import java.io.Serializable;

/**
 * Clase Ganadores que contiene las fichas que ya recorrieron todo el tablero
 */
public class Ganadores implements Serializable {
    int rojo;
    int amarillo;
    int azul;
    int verde;

    /**
     * Constructor de la clase Ganadores que se inicializa vacía para cada color
     */
    public Ganadores(){
        rojo = 0;
        amarillo = 0;
        azul = 0;
        verde = 0;
    }

    /**
     * Método que retorna la cantidad de fichas que ya "ganaron" a partir de su color
     * @param color color de las fichas que se quiere saber si ya ganaron
     * @return cantidad de fichas que ya ganaron
     */
    public int getColor(String color) {
        return switch (color) {
            case "Amarillo" -> amarillo;
            case "Azul" -> azul;
            case "Rojo" -> rojo;
            default -> verde;
        };
    }

    /**
     * Método que añade una ficha al arreglo de ganadores
     * @param color color de la ficha a la que pertenece la ficha
     * //@param ficha ficha que entrará al arreglo de ganadores a partir de su color
     */
    public void addColor(String color){
        switch (color) {
            case "Amarillo" -> amarillo += 1;
            case "Azul" -> azul += 1;
            case "Rojo" -> rojo += 1;
            default -> verde += 1;
        }
    }

    //@Override
    //public String toString(){
    //    String mensaje = "";
    //    mensaje += "Rojo :" + rojo + " ";
    //    mensaje += "Azul :" + azul + " ";
    //    mensaje += "Verde :" + verde + " ";
    //    mensaje += "Amarillo :" + amarillo + " ";
    //    return mensaje;
    //}
}
