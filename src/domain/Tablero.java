package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    private HashMap<Integer, Casilla> rojo = new HashMap<>();
    private HashMap<Integer, Casilla> verde= new HashMap<>();
    private HashMap<Integer, Casilla> amarillo = new HashMap<>();
    private HashMap<Integer, Casilla> azul = new HashMap<>();

    private Ganadores ganadores = new Ganadores();
    private Carcel carcel;
    int movi1, movi2;


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
        switch (nombreCasa){
            case "Azul"->{
                azul.get(numCasilla).setSeguro();
                break;
            }
            case "Rojo"->{
                rojo.get(numCasilla).setSeguro();
                break;
            }
            case "Amarillo"->{
                amarillo.get(numCasilla).setSeguro();
                break;
            }
            default -> {
                verde.get(numCasilla).setSeguro();
                break;
            }
        }
    }
    public boolean isBloqueado(String color, int pos){
        return switch (color) {
            case "Amarillo" -> amarillo.get(pos).isBloqueado();
            case "Azul" -> azul.get(pos).isBloqueado();
            case "Rojo" -> rojo.get(pos).isBloqueado();
            default -> verde.get(pos).isBloqueado();
        };
    }

    public void nuevaFicha(String color, int pos, String colorf){
        switch (color) {
            case "Amarillo" -> {
                amarillo.get(pos).agregarUno(new Ficha(colorf));
                if(amarillo.get(pos).getElementos().size() == 2){amarillo.get(pos).setBloqueado();}
            }
            case "Azul" -> {
                azul.get(pos).agregarUno(new Ficha(colorf));
                if(azul.get(pos).getElementos().size() == 2){azul.get(pos).setBloqueado();}
            }
            case "Rojo" -> {
                rojo.get(pos).agregarUno(new Ficha(colorf));
                if(rojo.get(pos).getElementos().size() == 2){rojo.get(pos).setBloqueado();}
            }
            default -> {
                verde.get(pos).agregarUno(new Ficha(colorf));
                if(verde.get(pos).getElementos().size() == 2){verde.get(pos).setBloqueado();}
            }
        }
    }
    public ArrayList<Elemento> getElementosCasilla(String color, int pos){
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

    public int getMovi1() {
        return movi1;
    }
    public void setMovi1(int movi1) {
        this.movi1 = movi1;
    }
    public int getMovi2() {
        return movi2;
    }
    public void setMovi2(int movi2) {
        this.movi2 = movi2;
    }

    public void verificacion(String colorCasa, int posFicha, int mover){
        switch (colorCasa) {
            case "Amarillo" -> {
                if (amarillo.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) amarillo.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (amarillo.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) amarillo.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
            case "Azul" -> {
                if (azul.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) azul.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (azul.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) azul.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
            case "Rojo" -> {
                if (rojo.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) rojo.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (rojo.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) rojo.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
            default -> {
                if (verde.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) verde.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (verde.get(posFicha).getElementos().size() > 1){
                    moverFicha(colorCasa, ((Ficha) verde.get(posFicha).getElementos().get(1)), posFicha, mover);
                }
            }
        }
    }
    public void moverFicha(String colorCasa, Ficha ficha, int numCasilla, int mover){
        if (!verficarBloqueo(colorCasa, numCasilla, mover, ficha.getColor())){
            this.movi1 = mover;
            switch (colorCasa) {
                case "Amarillo" -> {
                    amarillo.get(numCasilla).quitarBloqueo();
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);

                    } else if (numCasilla + mover == 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        azul.get(16).agregarUno(ficha);
                        ponerBlooqueoComodin(azul.get(16));

                    } else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(mover-1).agregarUno(ficha);
                        ponerBlooqueoComodin(amarillo.get(mover-1));

                    } else if (ficha.getColor().equals("Azul") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        azul.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(azul.get(numCasilla + mover));

                    }else if (ficha.getColor().equals("Azul") && numCasilla + mover == 24) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Azul");

                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        azul.get((numCasilla + mover) - 17).agregarUno(ficha);
                        ponerBlooqueoComodin(azul.get((numCasilla + mover) - 17));

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(amarillo.get(numCasilla + mover));

                    }else if(numCasilla + mover < 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(amarillo.get(numCasilla + mover));
                    }
                }
                case "Azul" -> {
                    azul.get(numCasilla).quitarBloqueo();
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);

                    } else if (numCasilla + mover == 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        rojo.get(16).agregarUno(ficha);
                        ponerBlooqueoComodin(rojo.get(16));

                    }else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        azul.get(mover-1).agregarUno(ficha);
                        ponerBlooqueoComodin(azul.get(mover-1));

                    }else if (ficha.getColor().equals("Rojo") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        rojo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(rojo.get(numCasilla + mover));

                    }else if (ficha.getColor().equals("Rojo") && numCasilla + mover == 24) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Rojo");

                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        rojo.get(numCasilla + mover - 17).agregarUno(ficha);
                        ponerBlooqueoComodin(rojo.get(numCasilla + mover - 17));

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        azul.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(azul.get(numCasilla + mover));

                    }else if(numCasilla + mover < 16){
                        azul.get(numCasilla).quitarElemento(ficha);
                        azul.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(azul.get(numCasilla + mover));
                    }
                }
                case "Rojo" -> {
                    rojo.get(numCasilla).quitarBloqueo();
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);

                    } else if (numCasilla + mover == 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        verde.get(16).agregarUno(ficha);
                        ponerBlooqueoComodin(verde.get(16));

                    }else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        rojo.get(mover-1).agregarUno(ficha);
                        ponerBlooqueoComodin(rojo.get(mover-1));

                    }else if (ficha.getColor().equals("Verde") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        verde.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(verde.get(numCasilla + mover));

                    }else if (ficha.getColor().equals("Verde") && numCasilla + mover == 24) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Rojo");

                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        verde.get(numCasilla + mover - 17).agregarUno(ficha);
                        ponerBlooqueoComodin(verde.get(numCasilla + mover - 17));

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        rojo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(rojo.get(numCasilla + mover));

                    }else if(numCasilla + mover < 16){
                        rojo.get(numCasilla).quitarElemento(ficha);
                        rojo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(rojo.get(numCasilla + mover));
                    }
                }
                default -> {
                    verde.get(numCasilla).quitarBloqueo();
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);

                    } else if (numCasilla + mover == 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(16).agregarUno(ficha);
                        ponerBlooqueoComodin(amarillo.get(16));

                    }else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        verde.get(mover-1).agregarUno(ficha);
                        ponerBlooqueoComodin(verde.get(mover-1));

                    }else if (ficha.getColor().equals("Amarillo") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(amarillo.get(numCasilla + mover));

                    }else if (ficha.getColor().equals("Amarillo") && numCasilla + mover == 24) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Amarillo");

                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(numCasilla + mover - 17).agregarUno(ficha);
                        ponerBlooqueoComodin(amarillo.get(numCasilla + mover - 17));

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        verde.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(verde.get(numCasilla + mover));

                    }else if(numCasilla + mover < 16){
                        verde.get(numCasilla).quitarElemento(ficha);
                        verde.get(numCasilla + mover).agregarUno(ficha);
                        ponerBlooqueoComodin(verde.get(numCasilla + mover));
                    }
                }
            }
        }
    }
    public void ponerBlooqueoComodin(Casilla ultCasilla) {
        if (ultCasilla.getElementos().size() == 2) {
            //System.out.println(ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha && ((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor()));
            //System.out.println(ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    //&& !((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())
                    //&& !ultCasilla.isSeguro());
            //System.out.println(ultCasilla.getElementos().get(0) instanceof Comodin && ultCasilla.getElementos().get(1) instanceof Ficha);
            if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && ((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())) {
                ultCasilla.setBloqueado();

            } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && !((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())
                    && !ultCasilla.isSeguro()) {
                volverCarcel(((Ficha) ultCasilla.getElementos().get(0)).getColor());
                ultCasilla.getElementos().remove(0);

            } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha && ultCasilla.isSeguro()) {
                ultCasilla.setBloqueado();

            } else if (ultCasilla.getElementos().get(0) instanceof Comodin && ultCasilla.getElementos().get(1) instanceof Ficha) {
                ultCasilla.tomarComodin((Comodin) ultCasilla.getElementos().get(0), (Ficha) ultCasilla.getElementos().get(1));

            }

        }
    }

    public void volverCarcel(String color){
        carcel.setColormas(color);
    }
    public void salirCarcel(String color){
        carcel.setColor(color);
        movi1 = 5;
    }
    public int getValorCarcel(String color){
        return carcel.getColor(color);
    }
    public boolean verficarBloqueo(String color, int inicio, int mover, String fichaColor){
        boolean cambio = false;
        for (int i = 0; i < mover; i++){
            if (inicio == 23){return false;}
            switch (color) {
                case "Amarillo" -> {

                    if (amarillo.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        i -=1;
                        color = "Azul";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        i -= 1;
                        cambio = false;
                    }
                    inicio += 1;
                }
                case "Azul" -> {
                    if (azul.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        i -=1;
                        color = "Rojo";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        i -= 1;
                        cambio = false;
                    }
                    inicio += 1;
                }
                case "Rojo" -> {
                    if (rojo.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        i -=1;
                        color = "Verde";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        i -= 1;
                        cambio = false;
                    }
                    inicio += 1;
                }
                default -> {
                    if (verde.get(inicio + 1).isBloqueado()) {
                        return true;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        i -=1;
                        color = "Amarillo";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        i -= 1;
                        cambio = false;
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
    public int cantElementosSalida(String color){
        return switch (color){
            case "Amarillo" -> amarillo.get(4).getElementos().size();
            case "Rojo" -> rojo.get(4).getElementos().size();
            case "Azul" -> azul.get(4).getElementos().size();
            default -> verde.get(4).getElementos().size();
        };
    }
    public int getGanadores(String color){
        return ganadores.getColor(color);
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
