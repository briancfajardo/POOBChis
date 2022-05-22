package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Tablero que contiene todas las casillas del juego POOBChis
 */
public class Tablero implements Serializable {
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

    /**
     * Constructor de la clase Tablero que inicializa las fichas con los tipos correspondientes que le llegan por parámetro
     * @param tipoAmarillo tipo de fichas Amarillas
     * @param tipoAzul tipo de fichas Azules
     * @param tipoVerde tipo de fichas Verdes
     * @param tipoRojo tipo de fichas Rojas
     */
    public Tablero(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul, ArrayList<String> tipoVerde, ArrayList<String> tipoRojo){
        this.tipoAmarillo = tipoAmarillo;
        this.tipoAzul = tipoAzul;
        this.tipoVerde = tipoVerde;
        this.tipoRojo = tipoRojo;
        prepareTablero();
        carcel = new Carcel(tipoAmarillo, tipoAzul, tipoVerde, tipoRojo);
        prepareBloqueos();
    }

    /**
     * Método que inicializa arreglos correspondientes a los bloqueos de cada color de fichas
     */
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

    /**
     * Método que pone las casillas iniciales y adicionalmente pone los seguros correspondientes
     */
    private void prepareTablero(){
        for(int i = 0; i<24;i++) {
            rojo.put(i, new Casilla());
            verde.put(i, new Casilla());
            amarillo.put(i, new Casilla());
            azul.put(i, new Casilla());
        }

        //rojo.get(7).agregarUno(new Ficha("Verde"));
        //rojo.get(7).agregarUno(new Ingeniera("Rojo"));
        //rojo.get(7).setBloqueado();
        rojo.get(4).setSeguro();
        rojo.get(11).setSeguro();
        rojo.get(16).setSeguro();

        //verde.get(0).agregarUno(new Ficha("Amarillo"));
        //verde.get(0).agregarUno(new Ficha("Amarillo"));
        //verde.get(0).setBloqueado();
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

    /**
     * Método que retorna el objeto cárcel
     * @return retorna el objeto tipo Cárcel
     */
    public Carcel getCarcel(){
        return carcel;
    }

    /**
     * Método que retorna el HashMap de casillas Amarillas
     * @return HashMap de casillas amarillas
     */
    public HashMap<Integer, Casilla> getAmarillo() {
        return amarillo;
    }
    /**
     * Método que retorna el HashMap de casillas Azules
     * @return HashMap de casillas Azules
     */
    public HashMap<Integer, Casilla> getAzul() {
        return azul;
    }
    /**
     * Método que retorna el HashMap de casillas Rojas
     * @return HashMap de casillas Rojas
     */
    public HashMap<Integer, Casilla> getRojo() {
        return rojo;
    }
    /**
     * Método que retorna el HashMap de casillas Verdes
     * @return HashMap de casillas Verdes
     */
    public HashMap<Integer, Casilla> getVerde() {
        return verde;
    }

    /**
     * Método para poner un seguro a partir del color y posición de la casilla
     * @param numCasilla posición de la casilla a la que se le quiere asignar el atributo de seguro
     * @param nombreCasa color de la casa donde se encuentra a casilla que se le quiere adicionar el atributo seguro
     */
    private void ponerSeguro(int numCasilla, String nombreCasa){
        switch (nombreCasa){
            case "Azul"->{
                azul.get(numCasilla).setSeguro();
            }
            case "Rojo"->{
                rojo.get(numCasilla).setSeguro();
            }
            case "Amarillo"->{
                amarillo.get(numCasilla).setSeguro();
            }
            default -> {
                verde.get(numCasilla).setSeguro();
            }
        }
    }

    /**
     * Método que retorna si una casilla está bloqueada o no
     * @param color color de la casa donde se encuentra a casilla que se le quiere conocer
     * @param pos posición de la casilla que se quiere averiguar si está bloqueada
     * @return booleano que dice si una casilla está bloqueada o no
     */
    public boolean isBloqueado(String color, int pos){
        return switch (color) {
            case "Amarillo" -> amarillo.get(pos).isBloqueado();
            case "Azul" -> azul.get(pos).isBloqueado();
            case "Rojo" -> rojo.get(pos).isBloqueado();
            default -> verde.get(pos).isBloqueado();
        };
    }
    /**
     * Método que retorna si una casilla es segura o no
     * @param color color de la casa donde se encuentra a casilla que se le quiere conocer
     * @param pos posición de la casilla que se quiere averiguar si es segura
     * @return booleano que dice si una casilla es segura o no
     */
    public boolean isSeguro(String color, int pos){
        return switch (color) {
            case "Amarillo" -> amarillo.get(pos).isSeguro();
            case "Azul" -> azul.get(pos).isSeguro();
            case "Rojo" -> rojo.get(pos).isSeguro();
            default -> verde.get(pos).isSeguro();
        };
    }

    /**
     * Método que agrega una ficha en una posición específica y crea bloqueos si es necesario
     * @param color color de la casa donde se quiere agregar la ficha
     * @param pos casilla donde se quiere agregar la ficha
     * @param ficha Objeto ficha que se agregará a la casilla
     */
    public void nuevaFicha(String color, int pos, Ficha ficha){
        switch (color) {
            case "Amarillo" -> {
                agregarFicha(amarillo.get(pos), ficha);
                //tipoAmarillo.remove(0);
                if(amarillo.get(pos).getElementos().size() == 2){amarillo.get(pos).setBloqueado();
                    agregarBloqueada(color, color, pos);
                    agregarBloqueada(color, color, pos);
                }
            }
            case "Azul" -> {
                agregarFicha(azul.get(pos),ficha);
                //tipoAzul.remove(0);
                if(azul.get(pos).getElementos().size() == 2){azul.get(pos).setBloqueado();
                    agregarBloqueada(color, color, pos);
                    agregarBloqueada(color, color, pos);
                }
            }
            case "Rojo" -> {
                agregarFicha(rojo.get(pos),ficha);
                //tipoRojo.remove(0);
                if(rojo.get(pos).getElementos().size() == 2){rojo.get(pos).setBloqueado();
                    agregarBloqueada(color, color, pos);
                    agregarBloqueada(color, color, pos);
                }
            }
            default -> {
                agregarFicha(verde.get(pos), ficha);
                //tipoVerde.remove(0);
                if(verde.get(pos).getElementos().size() == 2){verde.get(pos).setBloqueado();
                    agregarBloqueada(color, color, pos);
                    agregarBloqueada(color, color, pos);
                }
            }
        }
    }

    /**
     * Método que agrega una ficha en una casilla específica
     * @param casilla casilla donde se quiere agregar la ficha
     * @param ficha ficha que quieres ser agregada
     */
    private void agregarFicha(Casilla casilla, Ficha ficha){
        casilla.agregarUno(ficha);
    }
    //private int indiceBloqueos(ArrayList<Integer> arrayList){
    //    for (int i = 1 ; i < arrayList.size(); i ++){
    //        arrayList
    //    }
    //}

    /**
     * Método que retorna un arreglo de elementos con los objetos contenidos en una casilla especificada a través de su color y posición
     * @param color color de la casilla a inspeccionar
     * @param pos posición de la casilla a inspeccionar
     * @return arreglo de elementos que contiene la casilla
     */
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

    /**
     * Método que verifica si se puede mover una ficha a una casilla específica
     * @param colorCasa color de la casilla donde se encuentra la ficha
     * @param posFicha posición de la casilla donde se encuentra la ficha
     * @param mover cantidad de casillas que se desea mover
     * @param colorTurno color del turno en el momento de intentar mover la ficha
     */

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

    /**
     * Método que retorna un arreglo de fichas que están en la cárcel de un color específico
     * @param color color de la cárcel de donde se desean conocer sus fichas
     * @return Arreglo de fichas que están en la cárcel de un color específico
     */
    public ArrayList<Ficha> getCarcel(String color){
        return switch (color){
            case "Amarillo" -> carcel.getAmarillo();
            case "Azul"-> carcel.getAzul();
            case "Rojo"-> carcel.getRojo();
            default -> carcel.getVerde();
        };
    }

    /**
     * Método que cuenta los bloqueos existentes en el tablero
     * @param colorFicha color de las fichas de las cuales se quieren saber sus bloqueos
     * @return suma de bloqueos de un color de ficha específica
     */
    public int contarBloqueos(String colorFicha){
        int cont = 0;
        cont += bloqueadasAmarillas.get(colorFicha).size()-1;
        cont += bloqueadasAzules.get(colorFicha).size()-1;
        cont += bloqueadasRojas.get(colorFicha).size()-1;
        cont += bloqueadasVerdes.get(colorFicha).size()-1;

        return cont;
    }

    /**
     * Método que retorna un arreglo bidimensional las posiciones de los bloqueos existentes
     * @param colorFicha color de las fichas de las cuales se desean conocer los bloqueos
     * @return Arreglo bidimensional de enteros
     */
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

    /**
     * Método que agrega el color de una ficha a los arreglos de bloqueados a partir de su color y posición
     * @param colorFicha color de la ficha
     * @param colorCasa color de la casa donde se encuentra
     * @param pos posición de la casilla donde sea desea agregar el color del bloqueado
     */
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

    /**
     * Método que elimina un color de los arreglos de bloqueados
     * @param colorFicha color de la ficha a eliminar
     * @param colorCasa color de la casa de donde se desea eliminar
     * @param pos posición de la casilla donde se encuentra el color de la ficha a eliminar
     */
    public void eliminarBloqueada(String colorFicha, String colorCasa, int pos){
        switch (colorCasa){
            case "Amarillo"->{
                bloqueadasAmarillas.get(colorFicha).remove(Integer.valueOf(pos));
            }case "Azul"->{
                bloqueadasAzules.get(colorFicha).remove(Integer.valueOf(pos));
            }case "Rojo"->{
                bloqueadasRojas.get(colorFicha).remove(Integer.valueOf(pos));
            }default -> {
                bloqueadasVerdes.get(colorFicha).remove(Integer.valueOf(pos));
            }
        }
    }

    /**
     * Método que usa el poder de una ficha
     * @param ficha ficha la cual usará su poder
     * @param colorCasa color de la casa donde se encuentra la ficha
     * @param numCasilla numero de la casilla donde está la ficha
     */
    public void usarPoder(Ficha ficha, String colorCasa, int numCasilla){
        ficha.usarPoder(this, colorCasa, numCasilla, null);
    }

    /**
     * Método que mueve una ficha un número determinado de posiciones
     * @param colorCasa color de la casa donde se encuentra
     * @param ficha ficha que se desea mover
     * @param numCasilla número de la casilla donde se encuentra la ficha
     * @param mover cantidad de casillas que se desea mover
     */
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

    /**
     * Método que verifica si se debe poner un bloqueo o si se hace uso de un comodín
     * @param ultCasilla casilla donde cayó la ficha
     * @param color color de la casilla
     * @param num número de la casilla
     */
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
                    && !ultCasilla.isSeguro() && !((Ficha) ultCasilla.getElementos().get(0)).isInmortal()) {
                volverCarcel(((Ficha) ultCasilla.getElementos().get(0)).getColor(), (Ficha) ultCasilla.getElementos().get(0));
                ultCasilla.getElementos().remove(0);

            } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && !((Ficha) ultCasilla.getElementos().get(0)).getColor().equals(((Ficha) ultCasilla.getElementos().get(1)).getColor())
                    && !ultCasilla.isSeguro() && ((Ficha) ultCasilla.getElementos().get(0)).isInmortal()) {
                ultCasilla.setBloqueado();
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(0)).getColor(), color, num);
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(1)).getColor(), color, num);

            } else if (ultCasilla.getElementos().get(0) instanceof Ficha && ultCasilla.getElementos().get(1) instanceof Ficha
                    && ultCasilla.isSeguro()) {
                ultCasilla.setBloqueado();
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(0)).getColor(), color, num);
                agregarBloqueada(((Ficha) ultCasilla.getElementos().get(1)).getColor(), color, num);

            } else if (ultCasilla.getElementos().get(0) instanceof Comodin && ultCasilla.getElementos().get(1) instanceof Ficha) {
                ultCasilla.tomarComodin((Comodin) ultCasilla.getElementos().get(0), (Ficha) ultCasilla.getElementos().get(1));
            }

        }
    }

    /**
     * Método para devolver una ficha a la cárcel
     * @param color color de la ficha
     * @param ficha objeto ficha que se llevará a la cárcel
     */
    public void volverCarcel(String color, Ficha ficha){
        carcel.meterCarcel(color, ficha);
        mataFicha = true;
    }

    /**
     * Método para salir de la cárcel a partir de su color
     * @param color color de la ficha que se desea sacar
     * @return ficha sacada de la carcel
     */
    public Ficha salirCarcel(String color){
        movi1 = 5;
        return carcel.sacarCarcel(color);
    }

    /**
     * Método que retorna la cantidad de fichas que contiene la cárcel de un color específico
     * @param color color de la cárcel de la que se desea saber la cantidad de fichas que contiene
     * @return cantidad de fichas que contiene
     */
    public int getValorCarcel(String color){
        return carcel.getColor(color);
    }

    /**
     * Método que retorna si una ficha acaba de matar a otra
     * @return booleano que dice si una ficha acaba de matar a otra
     */
    public boolean isMataFicha(){return mataFicha;}

    /**
     * Método que retorna si un jugador acaba de coronar una ficha
     * @return booleano que dice si un jugador acaba de coronar una ficha
     */
    public boolean isSacaFicha() {return sacaFicha;}

    /**
     * Método que le pone un nuevo valor al atributo mataFicha
     * @param nuevo nuevo valor booleano
     */
    public void setMataFicha(boolean nuevo){mataFicha = nuevo;}
    /**
     * Método que le pone un nuevo valor al atributo sacaFicha
     * @param nuevo nuevo valor booleano
     */
    public void setSacaFicha(boolean nuevo){sacaFicha = nuevo;}

    /**
     * Método que verifica si existe un bloqueo en una cantidad de casillas adelante
     * @param color color de la casa donde se encuentra la ficha
     * @param inicio posición de la ficha donde está la ficha
     * @param mover cantidad de casillas a validar
     * @param fichaColor color de la ficha
     * @return booleano que representa si existe un bloqueo o no
     */
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

    /**
     * Método que valida donde se encuentra el bloqueo más cercano para ser usado por un comodín
     * @param color color de la casa desde donde parte la validación
     * @param inicio posición de inicio de la validación
     * @param fichaColor color de la ficha que obtuvo el comodín
     * @return Concatenación del color de la casa más la posición de donde se encuentra el bloqueo
     */
    public String verificarBloqueoComodin(String color, int inicio, String fichaColor){
        boolean cambio = false;
        int mover = 0;
        boolean entcontro = false;
        while (!entcontro){
            if (inicio == 23){entcontro = true;}
            switch (color) {
                case "Amarillo" -> {

                    if (amarillo.get(inicio + 1).isBloqueado()) {
                        entcontro = true;
                        inicio +=1;
                        return "Amarillo "+inicio;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        color = "Azul";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        cambio = false;
                    }
                    inicio += 1;
                }
                case "Azul" -> {
                    if (azul.get(inicio + 1).isBloqueado()) {
                        inicio += 1;
                        return "Azul "+inicio;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        color = "Rojo";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        cambio = false;
                    }
                    inicio += 1;
                }
                case "Rojo" -> {
                    if (rojo.get(inicio + 1).isBloqueado()) {
                        inicio += 1;
                        return "Rojo "+inicio;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        color = "Verde";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        cambio = false;
                    }
                    inicio += 1;
                }
                default -> {
                    if (verde.get(inicio + 1).isBloqueado()) {
                        inicio += 1;
                        return "Verde "+inicio;
                    } else if (inicio + 1 == 16 && !cambio) {
                        inicio = 14;
                        color = "Amarillo";
                        cambio = true;
                    } else if (inicio + 1 == 17 && !fichaColor.equals(color)) {
                        inicio = -2;
                        cambio = false;
                    }
                    inicio += 1;
                }
            }
        }
        return null;
    }

    /**
     * Retorna la casilla a partir del color de la casa y el número de la casilla
     * @param colorCasa color de la casa donde se encuentra la casilla que se desea
     * @param numCasilla número de la casilla donde se encuentra la casilla
     * @return Casilla
     */
    public Casilla getCasilla(String colorCasa, int numCasilla){
        return switch (colorCasa){
            case "Amarillo"-> amarillo.get(numCasilla);
            case "Azul"-> azul.get(numCasilla);
            case "Rojo"-> rojo.get(numCasilla);
            default -> verde.get(numCasilla);
        };
    }

    /**
     * Método que retorna la ficha más lejos que tiene un jugador a partir de su color
     * @param color color del cual se hará la verificación
     * @return Color más la posición de la ficha encontrada
     */
    public String getMaslejos(String color){
        HashMap <String, ArrayList<Integer>> posiciones = getPosFichas(color);
        if(color.equals("Amarillo")){
            if(posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-1) > 15){
                return "Amarillo "+ posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-1);
            }
            if(posiciones.get("Verde").size() > 0 && posiciones.get("Verde").get(posiciones.get("Verde").size()-1) < 16){
                return "Verde "+ posiciones.get("Verde").get(posiciones.get("Verde").size()-1);
            } else if (posiciones.get("Verde").size() > 1 && posiciones.get("Verde").get(posiciones.get("Verde").size()-2) < 16) {
                return "Verde "+ posiciones.get("Verde").get(posiciones.get("Verde").size()-2);
            } else if (posiciones.get("Verde").size() > 0 && posiciones.get("Verde").get(posiciones.get("Verde").size()-1) == 16) {
                return "Verde "+ posiciones.get("Verde").get(posiciones.get("Verde").size()-1);
            }

            if(posiciones.get("Rojo").size() > 0 && posiciones.get("Rojo").get(posiciones.get("Rojo").size()-1) < 16){
                return "Rojo "+ posiciones.get("Rojo").get(posiciones.get("Rojo").size()-1);
            } else if (posiciones.get("Rojo").size() > 1 && posiciones.get("Rojo").get(posiciones.get("Rojo").size()-2) < 16) {
                return "Rojo "+ posiciones.get("Rojo").get(posiciones.get("Rojo").size()-2);
            } else if (posiciones.get("Rojo").size() > 0 && posiciones.get("Rojo").get(posiciones.get("Rojo").size()-1) == 16) {
                return "Rojo "+ posiciones.get("Rojo").get(posiciones.get("Rojo").size()-1);
            }

            if(posiciones.get("Azul").size() > 0 && posiciones.get("Azul").get(posiciones.get("Azul").size()-1) < 16){
                return "Azul "+ posiciones.get("Azul").get(posiciones.get("Azul").size()-1);
            } else if (posiciones.get("Azul").size() > 1 && posiciones.get("Azul").get(posiciones.get("Azul").size()-2) < 16) {
                return "Azul "+ posiciones.get("Azul").get(posiciones.get("Azul").size()-2);
            } else if (posiciones.get("Azul").size() > 0 && posiciones.get("Azul").get(posiciones.get("Azul").size()-1) == 16) {
                return "Azul "+ posiciones.get("Azul").get(posiciones.get("Azul").size()-1);
            }

            if(posiciones.get("Amarillo").size() > 0){
                return "Amarillo "+ posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-1);
            }
        } else if (color.equals("Rojo")) {
            if(posiciones.get("Rojo").get(posiciones.get("Rojo").size()-1) > 15){
                return "Rojo "+ posiciones.get("Rojo").get(posiciones.get("Rojo").size()-1);
            }

            if(posiciones.get("Azul").size() > 0 && posiciones.get("Azul").get(posiciones.get("Azul").size()-1) < 16){
                return "Azul "+ posiciones.get("Azul").get(posiciones.get("Azul").size()-1);
            } else if (posiciones.get("Azul").size() > 1 && posiciones.get("Azul").get(posiciones.get("Azul").size()-2) < 16) {
                return "Azul "+ posiciones.get("Azul").get(posiciones.get("Azul").size()-2);
            } else if (posiciones.get("Azul").size() > 0 && posiciones.get("Azul").get(posiciones.get("Azul").size()-1) == 16) {
                return "Azul "+ posiciones.get("Azul").get(posiciones.get("Azul").size()-1);
            }


            if(posiciones.get("Amarillo").size() > 0 && posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-1) < 16){
                return "Amarillo "+ posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-1);
            } else if (posiciones.get("Amarillo").size() > 1 && posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-2) < 16) {
                return "Amarillo "+ posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-2);
            } else if (posiciones.get("Amarillo").size() > 0 && posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-1) == 16) {
                return "Amarillo "+ posiciones.get("Amarillo").get(posiciones.get("Amarillo").size()-1);
            }
            if(posiciones.get("Verde").size() > 0 && posiciones.get("Verde").get(posiciones.get("Verde").size()-1) < 16){
                return "Verde "+ posiciones.get("Verde").get(posiciones.get("Verde").size()-1);
            } else if (posiciones.get("Verde").size() > 1 && posiciones.get("Verde").get(posiciones.get("Verde").size()-2) < 16) {
                return "Verde "+ posiciones.get("Verde").get(posiciones.get("Verde").size()-2);
            } else if (posiciones.get("Verde").size() > 0 && posiciones.get("Verde").get(posiciones.get("Verde").size()-1) == 16) {
                return "Verde "+ posiciones.get("Verde").get(posiciones.get("Verde").size()-1);
            }
            if(posiciones.get("Rojo").size() > 0) {
                return "Rojo " + posiciones.get("Rojo").get(posiciones.get("Rojo").size() - 1);
            }
        }
        return null;
    }

    /**
     * Método que retorna un HashMap con las posiciones de las fichas de un color correspondiente
     * @param color color de las fichas que se desea averiguar sus posiciones
     * @return HashMap con las posiciones de las fichas de un color correspondiente
     */
    private HashMap<String, ArrayList<Integer>> getPosFichas(String color){
        HashMap <String, ArrayList<Integer>> posiciones = new HashMap<>();
        posiciones.put("Amarillo", new ArrayList<>());
        posiciones.put("Azul", new ArrayList<>());
        posiciones.put("Rojo", new ArrayList<>());
        posiciones.put("Verde", new ArrayList<>());
        for(int c : amarillo.keySet()){
            if(color.equals("Amarillo")){
                if(amarillo.get(c).getElementos().size() > 0 && amarillo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)amarillo.get(c).getElementos().get(0)).getColor().equals("Amarillo")){
                    posiciones.get("Amarillo").add(c);
                } else if (amarillo.get(c).getElementos().size() > 1 && amarillo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)amarillo.get(c).getElementos().get(1)).getColor().equals("Amarillo")) {
                    posiciones.get("Amarillo").add(c);
                }
                if(azul.get(c).getElementos().size() > 0 && azul.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)azul.get(c).getElementos().get(0)).getColor().equals("Amarillo")){
                    posiciones.get("Azul").add(c);
                }else if (azul.get(c).getElementos().size() > 1 && azul.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)azul.get(c).getElementos().get(1)).getColor().equals("Amarillo")) {
                    posiciones.get("Azul").add(c);
                }
                if(rojo.get(c).getElementos().size() > 0 && rojo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)rojo.get(c).getElementos().get(0)).getColor().equals("Amarillo")){
                    posiciones.get("Rojo").add(c);
                }else if (rojo.get(c).getElementos().size() > 1 && rojo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)rojo.get(c).getElementos().get(1)).getColor().equals("Amarillo")) {
                    posiciones.get("Rojo").add(c);
                }
                if(verde.get(c).getElementos().size() > 0 && verde.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)verde.get(c).getElementos().get(0)).getColor().equals("Amarillo")){
                    posiciones.get("Verde").add(c);
                }else if (verde.get(c).getElementos().size() > 1 && verde.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)verde.get(c).getElementos().get(1)).getColor().equals("Amarillo")) {
                    posiciones.get("Amarillo").add(c);
                }
            } else if (color.equals("Rojo")) {
                if(amarillo.get(c).getElementos().size() > 0 && amarillo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)amarillo.get(c).getElementos().get(0)).getColor().equals("Rojo")){
                    posiciones.get("Amarillo").add(c);
                } else if (amarillo.get(c).getElementos().size() > 1 && amarillo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)amarillo.get(c).getElementos().get(1)).getColor().equals("Rojov")) {
                    posiciones.get("Amarillo").add(c);
                }
                if(azul.get(c).getElementos().size() > 0 && azul.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)azul.get(c).getElementos().get(0)).getColor().equals("Rojo")){
                    posiciones.get("Azul").add(c);
                }else if (azul.get(c).getElementos().size() > 1 && azul.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)azul.get(c).getElementos().get(1)).getColor().equals("Rojo")) {
                    posiciones.get("Azul").add(c);
                }
                if(rojo.get(c).getElementos().size() > 0 && rojo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)rojo.get(c).getElementos().get(0)).getColor().equals("Rojo")){
                    posiciones.get("Rojo").add(c);
                }else if (rojo.get(c).getElementos().size() > 1 && rojo.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)rojo.get(c).getElementos().get(1)).getColor().equals("Rojo")) {
                    posiciones.get("Rojo").add(c);
                }
                if(verde.get(c).getElementos().size() > 0 && verde.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)verde.get(c).getElementos().get(0)).getColor().equals("Rojo")){
                    posiciones.get("Verde").add(c);
                }else if (verde.get(c).getElementos().size() > 1 && verde.get(c).getElementos().get(0) instanceof Ficha
                        && ((Ficha)verde.get(c).getElementos().get(1)).getColor().equals("Rojo")) {
                    posiciones.get("Amarillo").add(c);
                }
            }
        }
        return posiciones;
    }

    /**
     * Método que retorna la cantidad de elementos que tiene la salida de cada casa, dependiendo del color
     * @param color color de la casa a la que se le desea conocer la cantidad de elementos que hay en la salida
     * @return entero de la cantidad de los elementos de la salida
     */
    public int cantElementosSalida(String color){
        return switch (color){
            case "Amarillo" -> amarillo.get(4).getElementos().size();
            case "Rojo" -> rojo.get(4).getElementos().size();
            case "Azul" -> azul.get(4).getElementos().size();
            default -> verde.get(4).getElementos().size();
        };
    }

    /**
     * Método que retorna la cantidad de fichas que hay coronadas de un color específico
     * @param color color que se desea conocer
     * @return cantidad de fichas que hay coronadas de un color específico
     */
    public int getGanadores(String color){
        return ganadores.getColor(color);
    }

}

