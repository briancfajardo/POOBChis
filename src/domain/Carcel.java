package domain;

import java.util.ArrayList;

public class Carcel {
    ArrayList<String> Trojo;
    ArrayList<String> Tamarillo;
    ArrayList<String> Tazul;
    ArrayList<String> Tverde;

    ArrayList<Ficha> rojo = new ArrayList<>();
    ArrayList<Ficha> amarillo = new ArrayList<>();
    ArrayList<Ficha> azul = new ArrayList<>();
    ArrayList<Ficha> verde = new ArrayList<>();

    public Carcel(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul,
                  ArrayList<String> tipoVerde, ArrayList<String> tipoRojo){
        Trojo = tipoRojo;
        Tamarillo = tipoAmarillo;
        Tazul = tipoAzul;
        Tverde = tipoVerde;
        inicializarFichas();
    }
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
    public int getColor(String color) {
        return switch (color) {
            case "Amarillo" -> amarillo.size();
            case "Azul" -> azul.size();
            case "Rojo" -> rojo.size();
            default -> verde.size();
        };
    }

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
    public void meterCarcel(String color, Ficha ficha){
        switch (color) {
            case "Amarillo" -> amarillo.add(ficha);
            case "Azul" -> azul.add(ficha);
            case "Rojo" -> rojo.add(ficha);
            default -> verde.add(ficha);
        }
    }
}
