package domain;

import presentation.TableroGUI;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    HashMap<Integer, Casilla> rojo = new HashMap<>();
    HashMap<Integer, Casilla> verde= new HashMap<>();
    HashMap<Integer, Casilla> amarillo = new HashMap<>();
    HashMap<Integer, Casilla> azul = new HashMap<>();

    Ganadores ganadores = new Ganadores();

    public Tablero(){
        prepareTablero();
    }
    private void prepareTablero(){
        for(int i = 0; i<24;i++) {
            rojo.put(i, new Casilla());
            verde.put(i, new Casilla());
            amarillo.put(i, new Casilla());
            azul.put(i, new Casilla());
        }



    }
    //public void cambiarCasilla(String color, int pos, String colorf){
//
    //    switch (color) {
    //        case "Amarillo" -> amarillo.get(pos).add(colorf);
    //        case "Azul" -> azul.get(pos).add(colorf);
    //        case "Rojo" -> rojo.get(pos).add(colorf);
    //        default -> verde.get(pos).add(colorf);
    //    }
    //}
    public ArrayList<Elemento> getCasilla(String color, int pos){
        return switch (color) {
            case "Amarillo" -> amarillo.get(pos).getElementos();
            case "Azul" -> azul.get(pos).getElementos();
            case "Rojo" -> rojo.get(pos).getElementos();
            default -> verde.get(pos).getElementos();
        };
    }

    public void cambiarCasilla(String rojo, int i, String rojo1) {
    }

    public void moverFicha(String color, Ficha ficha, int mover, int numCasilla){
        String ultimoColor = color;

        while (mover != 0 && !ultimoColor.equals("detenido")){
            ultimoColor = avanzarUno(color, ficha, numCasilla);
            if (mover == 1){

            }
            mover -= 1;
            numCasilla += 1;
        }
    }

    public String primeraMayuscula(String mensaje){
        return mensaje.toUpperCase().charAt(0) + mensaje.substring(1, mensaje.length()).toLowerCase();
    }

    public String avanzarUno(String colorCasa, Ficha ficha, int numCasilla){
        Casilla casilla;
        Casilla nuevaCasilla;
        String ultimoColor = colorCasa;
        String mayusculaCasa = primeraMayuscula(colorCasa);
        HashMap<Integer, Casilla> asociado;
        String siguiente;

        switch (colorCasa) {
            case "amarillo":
                casilla = amarillo.get(numCasilla);
                nuevaCasilla = azul.get(numCasilla + 1);
                asociado = amarillo;
                siguiente = "azul";
            case "azul":
                casilla = azul.get(numCasilla);
                nuevaCasilla = rojo.get(numCasilla + 1);
                asociado = azul;
                siguiente = "rojo";
            case "rojo":
                casilla = rojo.get(numCasilla);
                nuevaCasilla = verde.get(numCasilla + 1);
                asociado = rojo;
                siguiente = "verde";
            default:
                casilla = verde.get(numCasilla);
                nuevaCasilla = amarillo.get(numCasilla + 1);
                asociado = verde;
                siguiente = "amarillo";
        };


        //Subir para ganadores
        if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
            casilla.quitarElemento(ficha);
            ganadores.addColor(mayusculaCasa);
        }else if(!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17 && !asociado.get(0).isBloqueado()){
            casilla.quitarElemento(ficha);
            asociado.get(0).agregarUno(ficha);
        }else if(!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17 && asociado.get(0).isBloqueado()){
            ultimoColor = "detenido";
        }else if (numCasilla + 1 == 16 && !nuevaCasilla.isBloqueado()) {
            casilla.quitarElemento(ficha);
            nuevaCasilla.agregarUno(ficha);
            ultimoColor = siguiente;
        }else if (numCasilla + 1 == 16 && nuevaCasilla.isBloqueado()) {
            ultimoColor = "detenido";
        }else if (!asociado.get(numCasilla + 1).isBloqueado()){
            casilla.quitarElemento(ficha);
            asociado.get(numCasilla + 1).agregarUno(ficha);
        }else{
            ultimoColor = "detenido";
        }

        switch (colorCasa) {
            case "amarillo":
                amarillo = asociado;
            case "azul":
                azul = asociado;
            case "rojo":
                rojo = asociado;
            default:
                verde = asociado;
        };

        return ultimoColor;
    }


    public static void main(String arg[]){
        Tablero u = new Tablero();
        u.amarillo.get(10).addElemento(new Ficha("Verde"));
        Ficha f = (Ficha) u.amarillo.get(10).getElementos().get(0);
        u.moverFicha("amarillo", f, 3, 10);
        System.out.println(u.amarillo.get(10));
        System.out.println("_________");
        System.out.println(u.amarillo.get(11));
        System.out.println("_________");
        System.out.println(u.amarillo.get(12));
        System.out.println("_________");
        System.out.println(u.amarillo.get(13));
        System.out.println("_________");
        System.out.println(u.ganadores);


    }
}
