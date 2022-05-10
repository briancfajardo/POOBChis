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
        rojo.get(4).setSeguro();
        rojo.get(11).setSeguro();
        rojo.get(16).setSeguro();

        verde.get(4).setSeguro();
        verde.get(11).setSeguro();
        verde.get(16).setSeguro();

        amarillo.get(4).setSeguro();
        amarillo.get(11).setSeguro();
        amarillo.get(16).setSeguro();

        azul.get(4).setSeguro();
        azul.get(11).setSeguro();
        azul.get(16).setSeguro();
    }

    private void ponerSeguros(int numCasilla, String nombreCasa){
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
        boolean ultimo = false;

        if (!verficarBloqueo(color, numCasilla, mover, ficha.getColor())){
            for (int i = 0; i < mover; i++){
                if (i == mover -1 ){ultimo = true;}
                ultimoColor = avanzarUno(color, ficha, numCasilla, ultimo);
            }
        }
    }

    public boolean verficarBloqueo(String color, int inicio, int mover, String fichaColor){
        for (int i = 0; i < mover; i++){
            if (inicio == 23){return false;}
            switch (color) {
                case "amarillo":
                    if (amarillo.get(inicio + 1).isBloqueado()){
                        return true;
                    } else if(inicio + 1 == 16){
                        inicio = 15;
                        color = "azul";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;

                case "azul":
                    if (azul.get(inicio + 1).isBloqueado()){
                        return true;
                    } else if(inicio + 1 == 16){
                        inicio = 15;
                        color = "rojo";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;

                case "rojo":
                    if (rojo.get(inicio + 1).isBloqueado()){
                        return true;
                    } else if(inicio + 1 == 16){
                        inicio = 15;
                        color = "verde";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;

                default:
                    if (verde.get(inicio + 1).isBloqueado()){
                        return true;
                    } else if(inicio + 1 == 16){
                        inicio = 15;
                        color = "amarillo";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;

            };
        }
        return false;
    }

    public String primeraMayuscula(String mensaje){
        return mensaje.toUpperCase().charAt(0) + mensaje.substring(1, mensaje.length()).toLowerCase();
    }

    public String avanzarUno(String colorCasa, Ficha ficha, int numCasilla, boolean ultimo) {
        Casilla casilla;
        Casilla ultCasilla;
        String ultimoColor = colorCasa;
        String mayusculaCasa = primeraMayuscula(colorCasa);

        switch (colorCasa) {
            case "amarillo":
                casilla = amarillo.get(numCasilla);

                if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                    casilla.quitarElemento(ficha);
                    ganadores.addColor(mayusculaCasa);
                    return ultimoColor;

                } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                    casilla.quitarElemento(ficha);
                    amarillo.get(0).agregarUno(ficha);
                    ultCasilla = amarillo.get(0);

                } else if (numCasilla + 1 == 16) {
                    casilla.quitarElemento(ficha);
                    azul.get(numCasilla + 1).agregarUno(ficha);
                    ultimoColor = "azul";
                    ultCasilla = azul.get(numCasilla + 1);
                } else {
                    casilla.quitarElemento(ficha);
                    amarillo.get(numCasilla + 1).agregarUno(ficha);
                    ultCasilla = amarillo.get(numCasilla + 1);
                }
                break;
            //nuevaCasilla = azul.get(numCasilla + 1);
            case "azul":
                casilla = azul.get(numCasilla);
                if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                    casilla.quitarElemento(ficha);
                    ganadores.addColor(mayusculaCasa);
                    return ultimoColor;

                } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                    casilla.quitarElemento(ficha);
                    azul.get(0).agregarUno(ficha);
                    ultCasilla = azul.get(0);

                } else if (numCasilla + 1 == 16) {
                    casilla.quitarElemento(ficha);
                    rojo.get(numCasilla + 1).agregarUno(ficha);
                    ultimoColor = "rojo";
                    ultCasilla = rojo.get(numCasilla + 1);

                } else {
                    casilla.quitarElemento(ficha);
                    azul.get(numCasilla + 1).agregarUno(ficha);
                    ultCasilla = azul.get(numCasilla + 1);
                }
                break;
            //nuevaCasilla = rojo.get(numCasilla + 1);
            //siguiente = "rojo";

            case "rojo":
                casilla = rojo.get(numCasilla);
                if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                    casilla.quitarElemento(ficha);
                    ganadores.addColor(mayusculaCasa);
                    return ultimoColor;

                } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                    casilla.quitarElemento(ficha);
                    rojo.get(0).agregarUno(ficha);
                    ultCasilla = rojo.get(0);

                } else if (numCasilla + 1 == 16) {
                    casilla.quitarElemento(ficha);
                    verde.get(numCasilla + 1).agregarUno(ficha);
                    ultimoColor = "verde";
                    ultCasilla = verde.get(numCasilla + 1);

                } else {
                    casilla.quitarElemento(ficha);
                    rojo.get(numCasilla + 1).agregarUno(ficha);
                    ultCasilla = rojo.get(numCasilla + 1);
                }
                break;
            //nuevaCasilla = verde.get(numCasilla + 1);
            //siguiente = "verde";
            default:
                casilla = verde.get(numCasilla);
                if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                    casilla.quitarElemento(ficha);
                    ganadores.addColor(mayusculaCasa);
                    return ultimoColor;

                } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                    casilla.quitarElemento(ficha);
                    verde.get(0).agregarUno(ficha);
                    ultCasilla = verde.get(0);

                } else if (numCasilla + 1 == 16) {
                    casilla.quitarElemento(ficha);
                    amarillo.get(numCasilla + 1).agregarUno(ficha);
                    ultimoColor = "amarillo";
                    ultCasilla = amarillo.get(numCasilla + 1);
                } else {
                    casilla.quitarElemento(ficha);
                    verde.get(numCasilla + 1).agregarUno(ficha);
                    ultCasilla = verde.get(numCasilla + 1);
                }
                break;
        };

        if (ultimo && ultCasilla.getElementos().size() == 2) {

            if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && ((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())) {
                casilla.setBloqueado();

            } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && !((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())
                    && !ultCasilla.isSeguro()) {
                casilla.getElementos().remove(0);

            } else if (ultCasilla.getElementos().get(0) instanceof Comodin && ultCasilla.getElementos().get(1) instanceof Ficha) {
                ultCasilla.tomarComodin((Comodin) ultCasilla.getElementos().get(0), (Ficha) ultCasilla.getElementos().get(1));

            }

        }
        return ultimoColor;
    }


    public static void main(String arg[]){
        Tablero u = new Tablero();
        u.amarillo.get(23).agregarUno(new Ficha("Amarillo"));
        Ficha f = (Ficha) u.amarillo.get(23).getElementos().get(0);
        u.avanzarUno("amarillo", f, 23, false);
        System.out.println(u.amarillo.get(23));
        System.out.println("_________");
        System.out.println(u.amarillo.get(24));
        System.out.println("_________");
        System.out.println(u.amarillo.get(0));
        System.out.println("_________");
        System.out.println(u.azul.get(16));
        System.out.println("_________");
        System.out.println(u.ganadores);


    }
}
