package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    HashMap<Integer, Casilla> rojo = new HashMap<>();
    HashMap<Integer, Casilla> verde= new HashMap<>();
    HashMap<Integer, Casilla> amarillo = new HashMap<>();
    HashMap<Integer, Casilla> azul = new HashMap<>();

    Ganadores ganadores = new Ganadores();
    Carcel carcel;
    public Tablero(){
        prepareTablero();
        carcel = new Carcel();
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

    private void ponerSeguro(int numCasilla, String nombreCasa){

    }

    public void nuevaFicha(String color, int pos, String colorf){
        switch (color) {
            case "Amarillo" -> amarillo.get(pos).agregarUno(new Ficha(colorf));
            case "Azul" -> azul.get(pos).agregarUno(new Ficha(colorf));
            case "Rojo" -> rojo.get(pos).agregarUno(new Ficha(colorf));
            default -> verde.get(pos).agregarUno(new Ficha(colorf));
        }
    }
    public ArrayList<Elemento> getCasilla(String color, int pos){
        return switch (color) {
            case "Amarillo" -> amarillo.get(pos).getElementos();
            case "Azul" -> azul.get(pos).getElementos();
            case "Rojo" -> rojo.get(pos).getElementos();
            default -> verde.get(pos).getElementos();
        };
    }

    //public void cambiarCasilla(String rojo, int i, String rojo1) {
    //}

    //public void moverFicha(String color, Ficha ficha, int mover, int numCasilla){
    //    String ultimoColor = color;
    //    boolean ultimo = false;
//
    //    if (!verficarBloqueo(color, numCasilla, mover, ficha.getColor())){
    //        for (int i = 0; i < mover; i++){
    //            if (i == mover-1) {ultimo = true;}
    //            ultimoColor = avanzarUno(ultimoColor, ficha, numCasilla, ultimo);
    //        }
    //    }
    //}
    public void verificacion(String colorCasa, int posFicha, int mover){
        //System.out.println(colorCasa);
        switch (colorCasa) {
            case "Amarillo" -> {
                if (amarillo.get(posFicha).getElementos().size() > 0) {
                    moverFicha(colorCasa, ((Ficha) amarillo.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (amarillo.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) amarillo.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
            case "Azul" -> {
                if (azul.get(posFicha).getElementos().size() > 0) {
                    moverFicha(colorCasa, ((Ficha) azul.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (azul.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) azul.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
            case "Rojo" -> {
                if (rojo.get(posFicha).getElementos().size() > 0) {
                    moverFicha(colorCasa, ((Ficha) rojo.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (rojo.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) rojo.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
            default -> {
                if (verde.get(posFicha).getElementos().size() > 0) {
                    moverFicha(colorCasa, ((Ficha) verde.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (verde.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) verde.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
        }
    }

    public void moverFicha(String colorCasa, Ficha ficha, int numCasilla, int mover) {
        Casilla casilla;
        Casilla ultCasilla = null;
        String ultimoColor = colorCasa;
        boolean ultimo = false;

        if (!verficarBloqueo(colorCasa, numCasilla, mover, ficha.getColor())){
            for (int i = 0; i < mover; i++){
                if (i == mover-1) {ultimo = true;}
                //try {
                //    Thread.sleep(500);
                //    System.out.println("nono");
                //}catch (Exception e){
                //    System.out.println("Sisisis");
                //}

                String mayusculaCasa = primeraMayuscula(ultimoColor);

                switch (ultimoColor) {
                    case "Amarillo" -> {
                        casilla = amarillo.get(numCasilla);
                        if (i == 0){
                            amarillo.get(numCasilla).quitarBloqueo();
                        }
                        if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                            casilla.quitarElemento(ficha);
                            ganadores.addColor(mayusculaCasa);
                            numCasilla = 24;

                        } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                            casilla.quitarElemento(ficha);
                            amarillo.get(0).agregarUno(ficha);
                            ultCasilla = amarillo.get(0);
                            numCasilla = 0;

                        } else if (numCasilla + 1 == 16) {
                            casilla.quitarElemento(ficha);
                            azul.get(numCasilla + 1).agregarUno(ficha);
                            ultimoColor = "Azul";
                            ultCasilla = azul.get(numCasilla + 1);
                            numCasilla += 1;
                        } else {
                            casilla.quitarElemento(ficha);
                            amarillo.get(numCasilla + 1).agregarUno(ficha);
                            ultCasilla = amarillo.get(numCasilla + 1);
                            numCasilla += 1;
                        }
                    }
                    case "Azul" -> {
                        casilla = azul.get(numCasilla);
                        if (i == 0){
                            azul.get(numCasilla).quitarBloqueo();
                        }
                        if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                            casilla.quitarElemento(ficha);
                            ganadores.addColor(mayusculaCasa);
                            numCasilla += 1;

                        } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                            casilla.quitarElemento(ficha);
                            azul.get(0).agregarUno(ficha);
                            ultCasilla = azul.get(0);
                            numCasilla = 0;

                        } else if (numCasilla + 1 == 16) {
                            casilla.quitarElemento(ficha);
                            rojo.get(numCasilla + 1).agregarUno(ficha);
                            ultimoColor = "Rojo";
                            ultCasilla = rojo.get(numCasilla + 1);
                            numCasilla += 1;

                        } else {
                            casilla.quitarElemento(ficha);
                            azul.get(numCasilla + 1).agregarUno(ficha);
                            ultCasilla = azul.get(numCasilla + 1);
                            numCasilla += 1;
                        }
                    }
                    case "Rojo" -> {
                        casilla = rojo.get(numCasilla);
                        if (i == 0){
                            rojo.get(numCasilla).quitarBloqueo();
                        }
                        if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                            casilla.quitarElemento(ficha);
                            ganadores.addColor(mayusculaCasa);
                            numCasilla += 1;

                        } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                            casilla.quitarElemento(ficha);
                            rojo.get(0).agregarUno(ficha);
                            ultCasilla = rojo.get(0);
                            numCasilla = 0;

                        } else if (numCasilla + 1 == 16) {
                            casilla.quitarElemento(ficha);
                            verde.get(numCasilla + 1).agregarUno(ficha);
                            ultimoColor = "Verde";
                            ultCasilla = verde.get(numCasilla + 1);
                            numCasilla += 1;

                        } else {
                            casilla.quitarElemento(ficha);
                            rojo.get(numCasilla + 1).agregarUno(ficha);
                            ultCasilla = rojo.get(numCasilla + 1);
                            numCasilla += 1;
                        }
                    }
                    default -> {
                        casilla = verde.get(numCasilla);
                        if (i == 0){
                            verde.get(numCasilla).quitarBloqueo();
                        }
                        if (ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 24) {
                            casilla.quitarElemento(ficha);
                            ganadores.addColor(mayusculaCasa);
                            numCasilla += 1;

                        } else if (!ficha.getColor().equals(mayusculaCasa) && numCasilla + 1 == 17) {
                            casilla.quitarElemento(ficha);
                            verde.get(0).agregarUno(ficha);
                            ultCasilla = verde.get(0);
                            numCasilla = 0;

                        } else if (numCasilla + 1 == 16) {
                            casilla.quitarElemento(ficha);
                            amarillo.get(numCasilla + 1).agregarUno(ficha);
                            ultimoColor = "Amarillo";
                            ultCasilla = amarillo.get(numCasilla + 1);
                            numCasilla += 1;

                        } else {
                            casilla.quitarElemento(ficha);
                            verde.get(numCasilla + 1).agregarUno(ficha);
                            ultCasilla = verde.get(numCasilla + 1);
                            numCasilla += 1;
                        }
                    }
                }
                ;

                if (ultimo && ultCasilla.getElementos().size() == 2) {

                    if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                            && ((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())) {
                        ultCasilla.setBloqueado();

                    } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                            && !((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())
                            && !ultCasilla.isSeguro()) {
                        volverCarcel(((Ficha) ultCasilla.getElementos().get(0)).getColor());
                        ultCasilla.getElementos().remove(0);

                    } else if (ultCasilla.getElementos().get(0) instanceof Comodin && ultCasilla.getElementos().get(1) instanceof Ficha) {
                        ultCasilla.tomarComodin((Comodin) ultCasilla.getElementos().get(0), (Ficha) ultCasilla.getElementos().get(1));

                    }

                }
            }
        }

    }
    public void volverCarcel(String color){
        carcel.setColormas(color);
    }
    public void salirCarcel(String color){
        carcel.setColor(color);
    }
    public int getValorCarcel(String color){
        return carcel.getColor(color);
    }
    public boolean verficarBloqueo(String color, int inicio, int mover, String fichaColor){
        for (int i = 0; i < mover; i++){
            if (inicio == 23){return false;}
            switch (color) {
                case "Amarillo" -> {
                    if (amarillo.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16) {
                        inicio = 15;
                        color = "Azul";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;
                }
                case "Azul" -> {
                    if (azul.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16) {
                        inicio = 15;
                        color = "Rojo";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;
                }
                case "Rojo" -> {
                    if (rojo.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16) {
                        inicio = 15;
                        color = "Verde";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;
                }
                default -> {
                    if (verde.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16) {
                        inicio = 15;
                        color = "Amarillo";
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -1;
                    }
                    inicio += 1;
                }
            }
            ;
        }
        return false;
    }

    public String primeraMayuscula(String mensaje){
        return mensaje.toUpperCase().charAt(0) + mensaje.substring(1, mensaje.length()).toLowerCase();
    }


    public Ganadores getGanadores(){
        return ganadores;
    }


    public static void main(String arg[]){
        Tablero u = new Tablero();
        u.verde.get(13).agregarUno(new Ficha("Amarillo"));
        u.verde.get(15).agregarUno(new Ficha("Azul"));
        u.verde.get(14).agregarUno(new Ficha("Azul"));

        Ficha f2 = (Ficha) u.verde.get(14).getElementos().get(0);
        u.moverFicha("Verde", f2, 14, 1);
        Ficha f = (Ficha) u.verde.get(13).getElementos().get(0);
        u.moverFicha("Verde", f, 13, 2);

        System.out.println(u.verde.get(13));
        System.out.println("_________");
        System.out.println(u.verde.get(14));
        System.out.println("_________");
        System.out.println(u.verde.get(15));
        System.out.println("_________");
        System.out.println(u.azul.get(11));
        System.out.println("_________");
        System.out.println(u.ganadores);


    }
}
