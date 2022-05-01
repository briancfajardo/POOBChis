package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    HashMap<Integer, ArrayList<String>> rojo = new HashMap<>();
    HashMap<Integer, ArrayList<String>> verde= new HashMap<>();
    HashMap<Integer, ArrayList<String>> amarillo = new HashMap<>();
    HashMap<Integer, ArrayList<String>> azul = new HashMap<>();
    public Tablero(){
        prepareTablero();
    }
    private void prepareTablero(){
        for(int i = 0; i<24;i++){
            rojo.put(i,new ArrayList<>());
            verde.put(i,new ArrayList<>());
            amarillo.put(i,new ArrayList<>());
            azul.put(i,new ArrayList<>());
        }
    }
    public void cambiarCasilla(String color, int pos, String colorf){

        switch (color) {
            case "Amarillo" -> amarillo.get(pos).add(colorf);
            case "Azul" -> azul.get(pos).add(colorf);
            case "Rojo" -> rojo.get(pos).add(colorf);
            default -> verde.get(pos).add(colorf);
        }
    }
    public ArrayList<String> getCasilla(String color, int pos){
        return switch (color) {
            case "Amarillo" -> amarillo.get(pos);
            case "Azul" -> azul.get(pos);
            case "Rojo" -> rojo.get(pos);
            default -> verde.get(pos);
        };
    }
}
