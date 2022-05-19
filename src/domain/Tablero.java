package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    private HashMap<Integer, Casilla> rojo = new HashMap<>();
    private HashMap<Integer, Casilla> verde= new HashMap<>();
    private HashMap<Integer, Casilla> amarillo = new HashMap<>();
    private HashMap<Integer, Casilla> azul = new HashMap<>();
    private HashMap<String, ArrayList<Integer>> bloqueadasAmarillas = new HashMap<>();
    private HashMap<String, ArrayList<Integer>> bloqueadasAzules = new HashMap<>();
    private HashMap<String, ArrayList<Integer>> bloqueadasRojas = new HashMap<>();
    private HashMap<String, ArrayList<Integer>> bloqueadasVerdes = new HashMap<>();

    private ArrayList<String> tipoAmarillo = new ArrayList<>();
    private ArrayList<String> tipoAzul = new ArrayList<>();
    private ArrayList<String> tipoVerde = new ArrayList<>();
    private ArrayList<String> tipoRojo = new ArrayList<>();

    private Ganadores ganadores = new Ganadores();
    private Carcel carcel;
    int movi1, movi2;

    private boolean mataFicha = false;
    private boolean sacaFicha = false;

    public Tablero(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul, ArrayList<String> tipoVerde, ArrayList<String> tipoRojo){
        this.tipoAmarillo = tipoAmarillo;
        this.tipoAzul = tipoAzul;
        this.tipoVerde = tipoVerde;
        this.tipoRojo = tipoRojo;
        prepareTablero();
        carcel = new Carcel();
        prepareBloqueos();
    }
    private void prepareBloqueos(){
        bloqueadasAmarillas.put("Amarillo",new ArrayList<>());
        bloqueadasAmarillas.put("Azul",new ArrayList<>());
        bloqueadasAmarillas.put("Rojo",new ArrayList<>());
        bloqueadasAmarillas.put("Verde",new ArrayList<>());

        bloqueadasAzules.put("Amarillo",new ArrayList<>());
        bloqueadasAzules.put("Azul",new ArrayList<>());
        bloqueadasAzules.put("Rojo",new ArrayList<>());
        bloqueadasAzules.put("Verde",new ArrayList<>());

        bloqueadasRojas.put("Amarillo",new ArrayList<>());
        bloqueadasRojas.put("Azul",new ArrayList<>());
        bloqueadasRojas.put("Rojo",new ArrayList<>());
        bloqueadasRojas.put("Verde",new ArrayList<>());

        bloqueadasVerdes.put("Amarillo",new ArrayList<>());
        bloqueadasVerdes.put("Azul",new ArrayList<>());
        bloqueadasVerdes.put("Rojo",new ArrayList<>());
        bloqueadasVerdes.put("Verde",new ArrayList<>());

        for (String color : bloqueadasVerdes.keySet()){
            if(color.equals("Amarillo")){
                bloqueadasAmarillas.get(color).add(1);
                bloqueadasAzules.get(color).add(2);
                bloqueadasRojas.get(color).add(3);
                bloqueadasVerdes.get(color).add(4);
            }else if(color.equals("Azul")){
                bloqueadasAmarillas.get(color).add(1);
                bloqueadasAzules.get(color).add(2);
                bloqueadasRojas.get(color).add(3);
                bloqueadasVerdes.get(color).add(4);
            }else if(color.equals("Rojo")){
                bloqueadasAmarillas.get(color).add(1);
                bloqueadasAzules.get(color).add(2);
                bloqueadasRojas.get(color).add(3);
                bloqueadasVerdes.get(color).add(4);
            }else if(color.equals("Verde")){
                bloqueadasAmarillas.get(color).add(1);
                bloqueadasAzules.get(color).add(2);
                bloqueadasRojas.get(color).add(3);
                bloqueadasVerdes.get(color).add(4);
            }
        }
    }

    private void prepareTablero(){
        for(int i = 0; i<24;i++) {
            rojo.put(i, new Casilla());
            verde.put(i, new Casilla());
            amarillo.put(i, new Casilla());
            azul.put(i, new Casilla());
        }

        //rojo.get(7).agregarUno(new Ficha("Verde"));
        rojo.get(7).agregarUno(new Ingeniera("Rojo"));
        //rojo.get(7).setBloqueado();
        rojo.get(4).setSeguro();
        rojo.get(11).setSeguro();
        rojo.get(16).setSeguro();

        //verde.get(0).agregarUno(new Ficha("Amarillo"));
        //verde.get(0).agregarUno(new Ficha("Amarillo"));
        //verde.get(0).setBloqueado();
        verde.get(4).setSeguro();
        verde.get(4).setSeguro();
        verde.get(11).setSeguro();
        verde.get(16).setSeguro();

        //amarillo.get(4).agregarUno(new Ficha("Verde"));
        //amarillo.get(4).agregarUno(new Ficha("Rojo"));
        //amarillo.get(0).agregarUno(new Ficha("Rojo"));
        //amarillo.get(0).agregarUno(new Ficha("Rojo"));
        //amarillo.get(0).setBloqueado();
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
            }
            case "Rojo"->{
                rojo.get(numCasilla).setSeguro();
                break;
            }
            case "Amarillo"->{
                amarillo.get(numCasilla).setSeguro();
            }
            default -> {
                verde.get(numCasilla).setSeguro();
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
    public boolean isSeguro(String color, int pos){
        return switch (color) {
            case "Amarillo" -> amarillo.get(pos).isSeguro();
            case "Azul" -> azul.get(pos).isSeguro();
            case "Rojo" -> rojo.get(pos).isSeguro();
            default -> verde.get(pos).isSeguro();
        };
    }

    public void nuevaFicha(String color, int pos, String colorf){
        switch (color) {
            case "Amarillo" -> {
                amarillo.get(pos).agregarUno(new Ficha(colorf));
                if(amarillo.get(pos).getElementos().size() == 2){amarillo.get(pos).setBloqueado();
                    agregarBloqueada(colorf, color, pos);
                    agregarBloqueada(colorf, color, pos);
                }
            }
            case "Azul" -> {
                azul.get(pos).agregarUno(new Ficha(colorf));
                if(azul.get(pos).getElementos().size() == 2){azul.get(pos).setBloqueado();
                    agregarBloqueada(colorf, color, pos);
                    agregarBloqueada(colorf, color, pos);
                }
            }
            case "Rojo" -> {
                rojo.get(pos).agregarUno(new Ficha(colorf));
                if(rojo.get(pos).getElementos().size() == 2){rojo.get(pos).setBloqueado();
                    agregarBloqueada(colorf, color, pos);
                    agregarBloqueada(colorf, color, pos);
                }
            }
            default -> {
                verde.get(pos).agregarUno(new Ficha(colorf));
                if(verde.get(pos).getElementos().size() == 2){verde.get(pos).setBloqueado();
                    agregarBloqueada(colorf, color, pos);
                    agregarBloqueada(colorf, color, pos);
                }
            }
        }
    }

    //private int indiceBloqueos(ArrayList<Integer> arrayList){
    //    for (int i = 1 ; i < arrayList.size(); i ++){
    //        arrayList
    //    }
    //}

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

    public void verificacion(String colorCasa, int posFicha, int mover, String colorTurno){
        switch (colorCasa) {
            case "Amarillo" -> {
                if (amarillo.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) amarillo.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (amarillo.get(posFicha).getElementos().size() > 1){
                    if (((Ficha) amarillo.get(posFicha).getElementos().get(1)).getColor().equals(colorTurno)){
                        moverFicha(colorCasa, ((Ficha) amarillo.get(posFicha).getElementos().get(1)), posFicha, mover);
                    }else {
                        moverFicha(colorCasa, ((Ficha) amarillo.get(posFicha).getElementos().get(0)), posFicha, mover);
                    }

                }
            }
            case "Azul" -> {
                if (azul.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) azul.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (azul.get(posFicha).getElementos().size() > 1){
                    if (((Ficha) azul.get(posFicha).getElementos().get(1)).getColor().equals(colorTurno)){
                        moverFicha(colorCasa, ((Ficha) azul.get(posFicha).getElementos().get(1)), posFicha, mover);
                    }else {
                        moverFicha(colorCasa, ((Ficha) azul.get(posFicha).getElementos().get(0)), posFicha, mover);
                    }
                }
            }
            case "Rojo" -> {
                if (rojo.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) rojo.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (rojo.get(posFicha).getElementos().size() > 1){
                    if (((Ficha) rojo.get(posFicha).getElementos().get(1)).getColor().equals(colorTurno)){
                        moverFicha(colorCasa, ((Ficha) rojo.get(posFicha).getElementos().get(1)), posFicha, mover);
                    }else {
                        moverFicha(colorCasa, ((Ficha) rojo.get(posFicha).getElementos().get(0)), posFicha, mover);
                    }
                }
            }
            default -> {
                if (verde.get(posFicha).getElementos().size() == 1) {
                    moverFicha(colorCasa, ((Ficha) verde.get(posFicha).getElementos().get(0)), posFicha, mover);
                }else if (verde.get(posFicha).getElementos().size() > 1){
                    if (((Ficha) verde.get(posFicha).getElementos().get(1)).getColor().equals(colorTurno)){
                        moverFicha(colorCasa, ((Ficha) verde.get(posFicha).getElementos().get(1)), posFicha, mover);
                    }else {
                        moverFicha(colorCasa, ((Ficha) verde.get(posFicha).getElementos().get(0)), posFicha, mover);
                    }
                }
            }
        }
    }

    public int contarBloqueos(String colorFicha){
        int cont = 0;
        cont += bloqueadasAmarillas.get(colorFicha).size()-1;
        cont += bloqueadasAzules.get(colorFicha).size()-1;
        cont += bloqueadasRojas.get(colorFicha).size()-1;
        cont += bloqueadasVerdes.get(colorFicha).size()-1;

        //System.out.println(bloqueadasAmarillas.get(colorFicha));
        //System.out.println(bloqueadasAzules.get(colorFicha));
        //System.out.println(bloqueadasRojas.get(colorFicha));
        //System.out.println(bloqueadasVerdes.get(colorFicha));
        return cont;
    }
    public ArrayList<ArrayList<Integer>> posBloqueos(String colorFicha){
        ArrayList<ArrayList<Integer>> posiciones = new ArrayList<>();
        if(bloqueadasAmarillas.get(colorFicha).size() > 1){
            posiciones.add(bloqueadasAmarillas.get(colorFicha));
        }
        if(bloqueadasAzules.get(colorFicha).size() > 1){
            posiciones.add(bloqueadasAzules.get(colorFicha));
        }
        if(bloqueadasRojas.get(colorFicha).size() > 1){
            posiciones.add(bloqueadasRojas.get(colorFicha));
        }
        if(bloqueadasVerdes.get(colorFicha).size() > 1){
            posiciones.add(bloqueadasVerdes.get(colorFicha));
        }
        return posiciones;
    }

    public void agregarBloqueada(String colorFicha, String colorCasa, int pos){
        switch (colorCasa){
            case "Amarillo"->{
                bloqueadasAmarillas.get(colorFicha).add(pos);
            }case "Azul"->{
                bloqueadasAzules.get(colorFicha).add(pos);
            }case "Rojo"->{
                bloqueadasRojas.get(colorFicha).add(pos);
            }default -> {
                bloqueadasVerdes.get(colorFicha).add(pos);
            }
        }
    }
    public void eliminarBloqueada(String colorFicha, String colorCasa, int pos){
        switch (colorCasa){
            case "Amarillo"->{
                bloqueadasAmarillas.get(colorFicha).remove(new Integer(pos));
            }case "Azul"->{
                bloqueadasAzules.get(colorFicha).remove(new Integer(pos));
            }case "Rojo"->{
                bloqueadasRojas.get(colorFicha).remove(new Integer(pos));
            }default -> {
                bloqueadasVerdes.get(colorFicha).remove(new Integer(pos));
            }
        }
    }

    public void usarPoder(Ficha ficha, String colorCasa, int numCasilla){
        if (ficha instanceof Ingeniera){
            ponerSeguro(numCasilla, colorCasa);
        }
    }
    public void moverFicha(String colorCasa, Ficha ficha, int numCasilla, int mover){
        if (!verificarBloqueo(colorCasa, numCasilla, mover, ficha.getColor())){
            this.movi1 = mover;
            switch (colorCasa) {
                case "Amarillo" -> {
                    if(amarillo.get(numCasilla).isBloqueado()){
                        eliminarBloqueada(((Ficha)amarillo.get(numCasilla).getElementos().get(1)).getColor() ,colorCasa, numCasilla);
                        eliminarBloqueada(((Ficha)amarillo.get(numCasilla).getElementos().get(0)).getColor() ,colorCasa, numCasilla);
                        amarillo.get(numCasilla).quitarBloqueo();
                    }
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);
                        sacaFicha = true;

                    } else if (numCasilla + mover == 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        azul.get(16).agregarUno(ficha);
                        ponerBloqueoComodin(azul.get(16), "Azul", 16);
                        usarPoder(ficha,  "Azul",16);
                    //Caso 20
                    } else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        if(mover == 20 && !ficha.getColor().equals("Azul")){
                            azul.get(2).agregarUno(ficha);
                            ponerBloqueoComodin(azul.get(2), "Azul", 2);
                            usarPoder(ficha,  "Azul",2);
                        }else if (mover == 20 && ficha.getColor().equals("Azul")) {
                            azul.get(19).agregarUno(ficha);
                            ponerBloqueoComodin(azul.get(19), "Azul", 19);
                            usarPoder(ficha,  "Azul",19);
                        }else {
                            amarillo.get(mover-1).agregarUno(ficha);
                            ponerBloqueoComodin(amarillo.get(mover-1), "Amarillo", mover-1);
                            usarPoder(ficha,  "Amarillo", mover-1);
                        }
                    } else if (ficha.getColor().equals("Azul") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        azul.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(azul.get(numCasilla + mover), "Azul", numCasilla + mover);
                        usarPoder(ficha,  "Azul", numCasilla + mover);

                    }else if (ficha.getColor().equals("Azul") && numCasilla + mover == 24) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Azul");
                        sacaFicha = true;
                    //Caso 20
                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        if (mover == 20 && numCasilla >= 13){
                            if(numCasilla == 13){
                                rojo.get(16).agregarUno(ficha);
                                ponerBloqueoComodin(rojo.get(16), "Rojo", 16);
                                usarPoder(ficha,  "Rojo", 16);
                            } else if (ficha.getColor().equals("Rojo")) {
                                rojo.get(numCasilla + 3).agregarUno(ficha);
                                ponerBloqueoComodin(rojo.get(numCasilla + 3), "Rojo", numCasilla + 3);
                                usarPoder(ficha,  "Rojo", numCasilla + 3);
                            } else {
                                rojo.get(6-(20-numCasilla)).agregarUno(ficha);
                                ponerBloqueoComodin(rojo.get(6-(20-numCasilla)), "Rojo", 6-(20-numCasilla));
                                usarPoder(ficha,  "Rojo", 6-(20-numCasilla));
                            }
                        }else {
                            azul.get((numCasilla + mover) - 17).agregarUno(ficha);
                            ponerBloqueoComodin(azul.get((numCasilla + mover) - 17), "Azul", (numCasilla + mover) - 17 );
                            usarPoder(ficha,  "Azul", (numCasilla + mover) - 17 );
                        }

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(amarillo.get(numCasilla + mover), "Amarillo", numCasilla + mover);
                        usarPoder(ficha,  "Amarillo", numCasilla + mover);

                    }else if(numCasilla + mover < 16) {
                        amarillo.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(amarillo.get(numCasilla + mover), "Amarillo", numCasilla + mover);
                        usarPoder(ficha,  "Amarillo", numCasilla + mover);
                    }
                }
                case "Azul" -> {
                    if(azul.get(numCasilla).isBloqueado()){
                        eliminarBloqueada(((Ficha)azul.get(numCasilla).getElementos().get(1)).getColor() ,colorCasa, numCasilla);
                        eliminarBloqueada(((Ficha)azul.get(numCasilla).getElementos().get(0)).getColor() ,colorCasa, numCasilla);
                    }
                    azul.get(numCasilla).quitarBloqueo();
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);
                        sacaFicha = true;

                    } else if (numCasilla + mover == 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        rojo.get(16).agregarUno(ficha);
                        ponerBloqueoComodin(rojo.get(16), "Rojo", 16);
                        usarPoder(ficha,  "Rojo", 16);

                    }else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        if(mover == 20 && !ficha.getColor().equals("Rojo")){
                            rojo.get(2).agregarUno(ficha);
                            ponerBloqueoComodin(rojo.get(2), "Rojo", 2);
                            usarPoder(ficha,  "Rojo", 2);
                        } else if (mover == 20 && ficha.getColor().equals("Rojo")) {
                            rojo.get(19).agregarUno(ficha);
                            ponerBloqueoComodin(rojo.get(19), "Rojo", 19);
                            usarPoder(ficha,  "Rojo", 19);
                        } else {
                            azul.get(mover-1).agregarUno(ficha);
                            ponerBloqueoComodin(azul.get(mover-1), "Azul",mover-1);
                            usarPoder(ficha,  "Azul",mover-1);
                        }

                    }else if (ficha.getColor().equals("Rojo") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        rojo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(rojo.get(numCasilla + mover), "Rojo", numCasilla + mover);
                        usarPoder(ficha,  "Rojo", numCasilla + mover);

                    }else if (ficha.getColor().equals("Rojo") && numCasilla + mover == 24) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Rojo");
                        sacaFicha = true;

                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        if (mover == 20 && numCasilla >= 13){
                            if(numCasilla == 13){
                                verde.get(16).agregarUno(ficha);
                                ponerBloqueoComodin(verde.get(16), "Verde", 16);
                                usarPoder(ficha,  "Verde", 16);
                            }else if (ficha.getColor().equals("Verde")) {
                                verde.get(numCasilla + 3).agregarUno(ficha);
                                ponerBloqueoComodin(verde.get(numCasilla + 3), "Verde", numCasilla + 3);
                                usarPoder(ficha,  "Verde", numCasilla + 3);
                            }else {
                                verde.get(6-(20-numCasilla)).agregarUno(ficha);
                                ponerBloqueoComodin(verde.get(6-(20-numCasilla)), "Verde", 6-(20-numCasilla));
                                usarPoder(ficha,  "Verde", 6-(20-numCasilla));
                            }
                        }else {
                            rojo.get(numCasilla + mover - 17).agregarUno(ficha);
                            ponerBloqueoComodin(rojo.get(numCasilla + mover - 17), "Rojo", (numCasilla + mover) - 17);
                            usarPoder(ficha,  "Rojo", (numCasilla + mover) - 17);
                        }

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        azul.get(numCasilla).quitarElemento(ficha);
                        azul.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(azul.get(numCasilla + mover), "Azul", numCasilla + mover);
                        usarPoder(ficha,  "Azul", numCasilla + mover);

                    }else if(numCasilla + mover < 16){
                        azul.get(numCasilla).quitarElemento(ficha);
                        azul.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(azul.get(numCasilla + mover), "Azul", numCasilla + mover);
                        usarPoder(ficha,  "Azul", numCasilla + mover);
                    }
                }
                case "Rojo" -> {
                    if(rojo.get(numCasilla).isBloqueado()){
                        eliminarBloqueada(((Ficha)rojo.get(numCasilla).getElementos().get(1)).getColor() ,colorCasa, numCasilla);
                        eliminarBloqueada(((Ficha)rojo.get(numCasilla).getElementos().get(0)).getColor() ,colorCasa, numCasilla);
                    }
                    rojo.get(numCasilla).quitarBloqueo();
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);
                        sacaFicha = true;

                    } else if (numCasilla + mover == 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        verde.get(16).agregarUno(ficha);
                        ponerBloqueoComodin(verde.get(16), "Verde", 16);
                        usarPoder(ficha,  "Verde", 16);

                    }else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        if(mover == 20 && !ficha.getColor().equals("Verde")){
                            verde.get(2).agregarUno(ficha);
                            ponerBloqueoComodin(verde.get(2), "Verde", 2);
                            usarPoder(ficha,  "Verde", 2);
                        }else if (mover == 20 && ficha.getColor().equals("Verde")) {
                            verde.get(19).agregarUno(ficha);
                            ponerBloqueoComodin(verde.get(19), "Verde", 19);
                            usarPoder(ficha,  "Verde", 19);
                        }else {
                            rojo.get(mover-1).agregarUno(ficha);
                            ponerBloqueoComodin(rojo.get(mover-1), "Rojo",mover-1);
                            usarPoder(ficha,  "Rojo",mover-1);
                        }

                    }else if (ficha.getColor().equals("Verde") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        verde.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(verde.get(numCasilla + mover), "Verde", numCasilla + mover);
                        usarPoder(ficha,  "Verde", numCasilla + mover);

                    }else if (ficha.getColor().equals("Verde") && numCasilla + mover == 24) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Verde");
                        sacaFicha = true;

                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        if (mover == 20 && numCasilla >= 13){
                            if(numCasilla == 13){
                                amarillo.get(16).agregarUno(ficha);
                                ponerBloqueoComodin(amarillo.get(16), "Amarillo", 16);
                                usarPoder(ficha,  "Amarillo", 16);
                            }else if (ficha.getColor().equals("Amarillo")) {
                                amarillo.get(numCasilla + 3).agregarUno(ficha);
                                ponerBloqueoComodin(amarillo.get(numCasilla + 3), "Amarillo", numCasilla + 3);
                                usarPoder(ficha,  "Amarillo", numCasilla + 3);
                            }else {
                                amarillo.get(6-(20-numCasilla)).agregarUno(ficha);
                                ponerBloqueoComodin(amarillo.get(6-(20-numCasilla)), "Amarillo", 6-(20-numCasilla));
                                usarPoder(ficha,  "Amarillo", 6-(20-numCasilla));
                            }
                        }else {
                            verde.get(numCasilla + mover - 17).agregarUno(ficha);
                            ponerBloqueoComodin(verde.get(numCasilla + mover - 17), "Verde", (numCasilla + mover) - 17);
                            usarPoder(ficha,  "Verde", (numCasilla + mover) - 17);
                        }

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        rojo.get(numCasilla).quitarElemento(ficha);
                        rojo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(rojo.get(numCasilla + mover), "Rojo", numCasilla + mover);
                        usarPoder(ficha,  "Rojo", numCasilla + mover);

                    }else if(numCasilla + mover < 16){
                        rojo.get(numCasilla).quitarElemento(ficha);
                        rojo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(rojo.get(numCasilla + mover), "Rojo", numCasilla + mover);
                        usarPoder(ficha,  "Rojo", numCasilla + mover);
                    }
                }
                default -> {
                    if(verde.get(numCasilla).isBloqueado()){
                        eliminarBloqueada(((Ficha)verde.get(numCasilla).getElementos().get(1)).getColor() ,colorCasa, numCasilla);
                        eliminarBloqueada(((Ficha)verde.get(numCasilla).getElementos().get(0)).getColor() ,colorCasa, numCasilla);
                    }
                    verde.get(numCasilla).quitarBloqueo();
                    if (ficha.getColor().equals(colorCasa) && numCasilla + mover == 24 && numCasilla >= 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor(colorCasa);
                        sacaFicha = true;

                    } else if (numCasilla + mover == 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(16).agregarUno(ficha);
                        ponerBloqueoComodin(amarillo.get(16), "Amarillo", 16);
                        usarPoder(ficha,  "Amarillo", 16);

                    }else if (!ficha.getColor().equals(colorCasa) && numCasilla == 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        if(mover == 20 && !ficha.getColor().equals("Amarillo")){
                            amarillo.get(2).agregarUno(ficha);
                            ponerBloqueoComodin(amarillo.get(2), "Amarillo", 2);
                            usarPoder(ficha,  "Amarillo", 2);
                        }else if (mover == 20 && ficha.getColor().equals("Amarillo")) {
                            amarillo.get(19).agregarUno(ficha);
                            ponerBloqueoComodin(amarillo.get(19), "Amarillo", 19);
                            usarPoder(ficha,  "Amarillo", 19);
                        }else {
                            verde.get(mover-1).agregarUno(ficha);
                            ponerBloqueoComodin(verde.get(mover-1), "Verde",mover-1);
                            usarPoder(ficha,  "Verde",mover-1);
                        }

                    }else if (ficha.getColor().equals("Amarillo") && numCasilla + mover > 16 && numCasilla + mover < 24) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        amarillo.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(amarillo.get(numCasilla + mover), "Amarillo", numCasilla + mover);
                        usarPoder(ficha,  "Amarillo", numCasilla + mover);

                    }else if (ficha.getColor().equals("Amarillo") && numCasilla + mover == 24) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        ganadores.addColor("Amarillo");
                        sacaFicha = true;

                    }else if (numCasilla < 16 && numCasilla + mover > 16) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        if (mover == 20 && numCasilla >= 13){
                            if(numCasilla == 13){
                                azul.get(16).agregarUno(ficha);
                                ponerBloqueoComodin(azul.get(16), "Azul", 16);
                                usarPoder(ficha,  "Azul", 16);
                            }else if (ficha.getColor().equals("Azul")) {
                                azul.get(numCasilla + 3).agregarUno(ficha);
                                ponerBloqueoComodin(azul.get(numCasilla + 3), "Azul", numCasilla + 3);
                                usarPoder(ficha,  "Azul", numCasilla + 3);
                            }else {
                                azul.get(6-(20-numCasilla)).agregarUno(ficha);
                                ponerBloqueoComodin(azul.get(6-(20-numCasilla)), "Azul", 6-(20-numCasilla));
                                usarPoder(ficha,  "Azul", 6-(20-numCasilla));
                            }
                        }else {
                            amarillo.get(numCasilla + mover - 17).agregarUno(ficha);
                            ponerBloqueoComodin(amarillo.get(numCasilla + mover - 17), "Amarillo", (numCasilla + mover) - 17);
                            usarPoder(ficha,  "Amarillo", (numCasilla + mover) - 17);
                        }

                    }else if (ficha.getColor().equals(colorCasa) && numCasilla >= 16 && numCasilla + mover < 24) {
                        verde.get(numCasilla).quitarElemento(ficha);
                        verde.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(verde.get(numCasilla + mover), "Verde", numCasilla + mover);
                        usarPoder(ficha,  "Verde", numCasilla + mover);

                    }else if(numCasilla + mover < 16){
                        verde.get(numCasilla).quitarElemento(ficha);
                        verde.get(numCasilla + mover).agregarUno(ficha);
                        ponerBloqueoComodin(verde.get(numCasilla + mover), "Verde", numCasilla + mover);
                        usarPoder(ficha,  "Verde", numCasilla + mover);
                    }
                }
            }
        }
    }
    public void ponerBloqueoComodin(Casilla ultCasilla, String color, int num) {
        if (ultCasilla.getElementos().size() == 2) {
            //System.out.println(ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha && ((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor()));
            //System.out.println(ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    //&& !((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())
                    //&& !ultCasilla.isSeguro());
            //System.out.println(ultCasilla.getElementos().get(0) instanceof Comodin && ultCasilla.getElementos().get(1) instanceof Ficha);
            if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && ((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())) {
                ultCasilla.setBloqueado();
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(0)).getColor(), color, num);
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(1)).getColor(), color, num);

            } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && !((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())
                    && !ultCasilla.isSeguro()) {
                volverCarcel(((Ficha) ultCasilla.getElementos().get(0)).getColor());
                ultCasilla.getElementos().remove(0);

            } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha && ultCasilla.isSeguro()) {
                ultCasilla.setBloqueado();
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(0)).getColor(), color, num);
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(1)).getColor(), color, num);

            } else if (ultCasilla.getElementos().get(0) instanceof Comodin && ultCasilla.getElementos().get(1) instanceof Ficha) {
                ultCasilla.tomarComodin((Comodin) ultCasilla.getElementos().get(0), (Ficha) ultCasilla.getElementos().get(1));
            }

        }
    }

    public void volverCarcel(String color){
        carcel.setColormas(color);
        mataFicha = true;
    }
    public void salirCarcel(String color){
        carcel.setColor(color);
        movi1 = 5;
    }
    public int getValorCarcel(String color){
        return carcel.getColor(color);
    }

    public boolean isMataFicha(){return mataFicha;}

    public boolean isSacaFicha() {return sacaFicha;}

    public void setMataFicha(boolean nuevo){mataFicha = nuevo;}

    public void setSacaFicha(boolean nuevo){sacaFicha = nuevo;}
    public boolean verificarBloqueo(String color, int inicio, int mover, String fichaColor){
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



    //public static void main(String arg[]){
    //    Tablero u = new Tablero();
    //    u.verde.get(13).agregarUno(new Ficha("Amarillo"));
    //    u.verde.get(15).agregarUno(new Ficha("Azul"));
    //    u.verde.get(14).agregarUno(new Ficha("Azul"));
//
    //    Ficha f2 = (Ficha) u.verde.get(14).getElementos().get(0);
    //    u.moverFicha("Verde", f2, 14, 1);
    //    Ficha f = (Ficha) u.verde.get(13).getElementos().get(0);
    //    u.moverFicha("Verde", f, 13, 2);

        //System.out.println(u.verde.get(13));
        //System.out.println("_________");
        //System.out.println(u.verde.get(14));
        //System.out.println("_________");
        //System.out.println(u.verde.get(15));
        //System.out.println("_________");
        //System.out.println(u.azul.get(11));
        //System.out.println("_________");
        //System.out.println(u.ganadores);



}
