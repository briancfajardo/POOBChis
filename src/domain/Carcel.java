package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase que representa la cárcel del juego POOBChis, la cual
 * puede contener objetos tipo ficha
 */
public class Carcel implements Serializable {
    ArrayList<String> Trojo;
    ArrayList<String> Tamarillo;
    ArrayList<String> Tazul;
    ArrayList<String> Tverde;

    ArrayList<Ficha> rojo = new ArrayList<>();
    ArrayList<Ficha> amarillo = new ArrayList<>();
    ArrayList<Ficha> azul = new ArrayList<>();
    ArrayList<Ficha> verde = new ArrayList<>();

    /**
     * contructor de la clase Carcel la cual se inicializa con la creación de las fichas de cada tipo correspondiente
     * @param tipoAmarillo arreglo de tipos de la cárcel amarilla
     * @param tipoAzul arreglo de tipos de la cárcel azul
     * @param tipoVerde arreglo de tipos de la cárcel verde
     * @param tipoRojo arreglo de tipos de la cárcel roja
     */
    public Carcel(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul,
                  ArrayList<String> tipoVerde, ArrayList<String> tipoRojo){
        Trojo = tipoRojo;
        Tamarillo = tipoAmarillo;
        Tazul = tipoAzul;
        Tverde = tipoVerde;
        inicializarFichas();
    }

    /**
     * método que crea las fichas de cada tipo correspondiente
     */
    private void inicializarFichas(){
        for (int i = 0; i < 4; i++){
            switch (Tamarillo.get(i)){
                case "Borde" -> amarillo.add(new Ficha("Amarillo"));
                case "Ingeniera" -> amarillo.add(new Ingeniera("Amarillo"));
                case "Cohete" -> amarillo.add(new Cohete("Amarillo"));
                case "Aspiradora" -> amarillo.add(new Aspiradora("Amarillo"));
                case "Saltarina" -> amarillo.add(new Saltarina("Amarillo"));
                case "Ventajosa" -> amarillo.add(new Ventajosa("Amarillo"));
            }

            switch (Tazul.get(i)){
                case "Borde" -> azul.add(new Ficha("Azul"));
                case "Ingeniera" -> azul.add(new Ingeniera("Azul"));
                case "Cohete" -> azul.add(new Cohete("Azul"));
                case "Aspiradora" -> azul.add(new Aspiradora("Azul"));
                case "Saltarina" -> azul.add(new Saltarina("Azul"));
                case "Ventajosa" -> azul.add(new Ventajosa("Azul"));
            }


            switch (Trojo.get(i)){
                case "Borde" -> rojo.add(new Ficha("Rojo"));
                case "Ingeniera" -> rojo.add(new Ingeniera("Rojo"));
                case "Cohete" -> rojo.add(new Cohete("Rojo"));
                case "Aspiradora" -> rojo.add(new Aspiradora("Rojo"));
                case "Saltarina" -> rojo.add(new Saltarina("Rojo"));
                case "Ventajosa" -> rojo.add(new Ventajosa("Rojo"));
            }

            switch (Tverde.get(i)){
                case "Borde" -> verde.add(new Ficha("Verde"));
                case "Ingeniera" -> verde.add(new Ingeniera("Verde"));
                case "Cohete" -> verde.add(new Cohete("Verde"));
                case "Aspiradora" -> verde.add(new Aspiradora("Verde"));
                case "Saltarina" -> verde.add(new Saltarina("Verde"));
                case "Ventajosa" -> verde.add(new Ventajosa("Verde"));
            }
        }
    }

    /**
     * Método que retorna la cantidad de elementos en una cárcel a partir de su color
     * @param color color de la cárcel que quiere ver su cantidad
     * @return cantidad de elementos en una cárcel a partir de su color
     */
    public int getColor(String color) {
        return switch (color) {
            case "Amarillo" -> amarillo.size();
            case "Azul" -> azul.size();
            case "Rojo" -> rojo.size();
            default -> verde.size();
        };
    }
    /**
     * Método que retorna un arreglo con todas las fichas que contiene cada cárcel
     * @param color color de la cárcel que quiere ver su cantidad
     * @return arreglo con todas las fichas que contiene cada cárcel
     */
    public ArrayList<Ficha> getFichas(String color){
        return switch (color) {
            case "Amarillo" -> amarillo;
            case "Azul" -> azul;
            case "Rojo" -> rojo;
            default -> verde;
        };
    }

    /**
     * Método que saca una ficha de la cárcel a partir de su color
     * @param color color de la cárcel de la cual quiere sacar una ficha
     * @return ficha que saldrá de la carcel
     */
    public Ficha sacarCarcel(String color){
        Ficha aux;
        switch (color) {
            case "Amarillo" -> {
                aux = amarillo.get(0);
                amarillo.remove(0);
            }
            case "Azul" -> {
                aux = azul.get(0);
                azul.remove(0);
            }
            case "Rojo" -> {
                aux = rojo.get(0);
                rojo.remove(0);
            }
            default -> {
                aux = verde.get(0);
                verde.remove(0);
            }
        }
        return aux;
    }

    /**
     * Método que retorna el arreglo que contiene las fichas rojas
     * @return Arreglo de las fichas rojas
     */

    public ArrayList<Ficha> getRojo() {
        return rojo;
    }

    /**
     * Método que retorna el arreglo que contiene las fichas amarillas
     * @return Arreglo de las fichas amarillas
     */
    public ArrayList<Ficha> getAmarillo() {
        return amarillo;
    }
    /**
     * Método que retorna el arreglo que contiene las fichas azules
     * @return Arreglo de las fichas azules
     */
    public ArrayList<Ficha> getAzul() {
        return azul;
    }
    /**
     * Método que retorna el arreglo que contiene las fichas verdes
     * @return Arreglo de las fichas verdes
     */
    public ArrayList<Ficha> getVerde() {
        return verde;
    }

    /**
     * Método que devuelve una ficha a la cercel a partir de su color
     * @param color color de la cárcel a la cual entrará
     * @param ficha objeto ficha que entrará a la cárcel
     */
    public void meterCarcel(String color, Ficha ficha){
        switch (color) {
            case "Amarillo" -> amarillo.add(ficha);
            case "Azul" -> azul.add(ficha);
            case "Rojo" -> rojo.add(ficha);
            default -> verde.add(ficha);
        }
    }
}
