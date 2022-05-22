package domain;

import java.util.ArrayList;

import java.io.*;

/**
 * Clase controladora Parchis
 */
public class Parchis implements Serializable{
    private Tablero tablero;
    private Dado dado1, dado2;
    private int valor1, valor2, valor3;
    public int AMARILLO = 1;
    public int AZUL = 2;
    public int ROJO = 3;
    public int VERDE = 4;
    private int turno, cantJugadores, sacoFicha, pares;
    private boolean mov1, mov2;
    private int todasAtrapadas;

    private boolean primeraTirada = false;
    private boolean turnoPropio;
    private ArrayList<String> tipoAmarillo;
    private ArrayList<String> tipoAzul;
    private ArrayList<String> tipoVerde;
    private ArrayList<String> tipoRojo;

    /**
     * Constructor de la clase Parchis que inicializa los tipos de fichas con los arreglos que le llegan por parametro
     * @param tipoAmarillo Tipo de fichas de color amarillo
     * @param tipoAzul Tipo de fichas de color azul
     * @param tipoVerde Tipo de fichas de color Verde
     * @param tipoRojo Tipo de fichas de color Rojo
     * @param cantJugadores Cantidad de jugadores que jugarán
     */
    public Parchis(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul, ArrayList<String> tipoVerde, ArrayList<String> tipoRojo, int cantJugadores){
        this.cantJugadores = cantJugadores;
        this.tipoAmarillo = tipoAmarillo;
        this.tipoAzul = tipoAzul;
        this.tipoRojo = tipoRojo;
        this.tipoVerde = tipoVerde;
        tablero = new Tablero(tipoAmarillo, tipoAzul, tipoVerde, tipoRojo);
        dado1 = new Dado();
        dado2 = new Dado();
        turno = ROJO;
    }

    /**
     * Método que retorna cantidad de elementos que contiene la cárcel de un color dado
     * @param color color de la cárcel que se desea conocer
     * @return entero que representa cuantas fichas tiene la cárcel de un color dado
     */
    public int getCarcel(String color){
        return tablero.getValorCarcel(color);
    }

    /**
     * Método que retorna el número de jugadores actuales
     * @return números que están jugando el POOBchis
     */
    public int getCantJugadores(){
        return cantJugadores;
    }

    /**
     * Método que retorna un booleano que representa su un jugador ya tiró los dados en su turno
     * @return int primeraTirada
     */
    public boolean getPrimeraTirada(){
        return primeraTirada;
    }

    /**
     * Método que ejecuta el poder de un elemento
     * @param color color de la casa donde se encuentra el elemento que usará su poder
     * @param posFicha posición dentro de la casa donde se encuentra el elemento que usará su poder
     */
    public void usarPoder(String color, int posFicha){
        int tam = getTablero().getElementosCasilla(color, posFicha).size();
        if (tam == 1 && getTablero().getElementosCasilla(color, posFicha).get(0) instanceof Ficha){
            ((Ficha) getTablero().getElementosCasilla(color, posFicha).get(0)).usarPoder(getTablero(), color, posFicha, this);
        }else if (tam == 2){
            if (getTablero().getElementosCasilla(color, posFicha).get(0) instanceof Ficha){
                ((Ficha) getTablero().getElementosCasilla(color, posFicha).get(0)).usarPoder(getTablero(), color, posFicha, this);
            }else if (getTablero().getElementosCasilla(color, posFicha).get(1) instanceof Ficha){
                ((Ficha) getTablero().getElementosCasilla(color, posFicha).get(1)).usarPoder(getTablero(), color, posFicha, this);
            }

        }
    }

    /**
     * Método que se usa para mover una ficha entre casillas
     * @param color Color de su posición actual
     * @param posFicha entero que dice su posición actual dentro de la casa correspondiente
     */
    public void moverFicha(String color, int posFicha){
        //System.out.println("mov1: " + mov1 + "   mov2: " + mov2+ "   mata: " + isMataFicha() + "   saca: " + isSacaFicha()+ "  No ver par: "
        //        + !verificarTresPares(color, posFicha));

        if (!verificarTresPares(color, posFicha)){

            tablero.verificacion(color, posFicha, valor3, turnoString());
            reglaSalirCarcel();

            if (valor1 != valor2){
                pares = 0;
                if (!isMataFicha() && !isSacaFicha() && mov1 && mov2){cambiarTurno();}
            } else{
                pares +=1;
            }
        }
        //System.out.println(tablero.isMataFicha());
        //System.out.println(tablero.isSacaFicha());
    }

    //public ArrayList<String> getTipoAmarillo() {
    //    return tipoAmarillo;
    //}
//
    //public ArrayList<String> getTipoAzul() {
    //    return tipoAzul;
    //}
//
    //public ArrayList<String> getTipoRojo() {
    //    return tipoRojo;
    //}

    //public ArrayList<String> getTipoVerde() {
    //    return tipoVerde;
    //}

    /**
     * Método que retorna el tipo de fichas de un color dado
     * @param color color de las fichas de las que se quiere conocer su tipo
     * @return Arreglo de String's que componen todos los tipos de fichas que posee un jugador
     */
    public ArrayList<String> getTipo(String color){
        ArrayList<Ficha> aux;
        switch (color){
            case "Amarillo" -> aux = tablero.getCarcel("Amarillo");
            case "Azul" -> aux = tablero.getCarcel("Azul");
            case "Rojo" -> aux = tablero.getCarcel("Rojo");
            default -> aux = tablero.getCarcel("Verde");
        }

        ArrayList<String> aux2 = new ArrayList<>();
        for (Ficha f : aux){
            if (f instanceof Ingeniera){
                aux2.add("Ingeniera");
            } else if (f instanceof Cohete) {
                aux2.add("Cohete");
            } else if (f instanceof Aspiradora) {
                aux2.add("Aspiradora");
            } else if (f instanceof Saltarina) {
                aux2.add("Saltarina");
            }else if (f instanceof  Ventajosa){
                aux2.add("Ventajosa");
            }else {
                aux2.add("Borde");
            }
        }
        return aux2;
    }

    /**
     * Método que retorna los tipos de fichas iniciales de color amarillo
     * @return arreglo de String's que contiene todos los tipos de las fichas del color amarillo
     */
    public ArrayList<String> getTipoAmarillo() {
        return tipoAmarillo;
    }
    /**
     * Método que retorna los tipos de fichas iniciales de color Verde
     * @return arreglo de String's que contiene todos los tipos de las fichas del color Verde
     */
    public ArrayList<String> getTipoVerde() {
        return tipoVerde;
    }
    /**
     * Método que retorna los tipos de fichas iniciales de color Azul
     * @return arreglo de String's que contiene todos los tipos de las fichas del color Azul
     */
    public ArrayList<String> getTipoAzul() {
        return tipoAzul;
    }
    /**
     * Método que retorna los tipos de fichas iniciales de color Rojo
     * @return arreglo de String's que contiene todos los tipos de las fichas del color Rojo
     */
    public ArrayList<String> getTipoRojo() {
        return tipoRojo;
    }

    /**
     * Método usado en los casos especiales cómo cuando una ficha se come a otra o cuando una ficha termina el recorrido y sale
     * del tablero
     * @param color color de la ficha en cuestión
     * @param posFicha posición en la que se encuentra
     * @param moverGanado cantidad a mover
     */
    public void moverGanancia(String color, int posFicha, int moverGanado){
        tablero.setMataFicha(false);
        tablero.setSacaFicha(false);
        tablero.verificacion(color, posFicha, moverGanado, turnoString());
        if(!isMataFicha() && !isSacaFicha() && valor2 != valor1 && mov1 && mov2){cambiarTurno();}
    }

    /**
     * Método que convierte el turno de entero a String
     * @return representación del turno en String
     */
    private String turnoString(){
        return switch (turno){
            case 1 -> "Amarillo";
            case 2 -> "Azul";
            case 3 -> "Rojo";
            default -> "Verde";
        };
    }

    /**
     * Método usado para quitar un bloqueo cuando un jugador al tirar los dados saca 2 valores iguales
     */
    private void quitarBloqueoPares(){
        String colorTurno;
        if (valor1 == valor2){
            colorTurno = turnoString();
            if (tablero.contarBloqueos(colorTurno) > 0 && tablero.contarBloqueos(colorTurno) <= 2){
                int colorCasa = tablero.posBloqueos(colorTurno).get(0).get(0);
                int posFicha = tablero.posBloqueos(colorTurno).get(0).get(1);

                switch (colorCasa){
                    case 1 -> {
                        tablero.verificacion("Amarillo",posFicha,valor1, colorTurno);
                        mov1 = true;
                        pares += 1;
                    }case 2 -> {
                        tablero.verificacion("Azul",posFicha,valor1, colorTurno);
                        mov1 = true;
                        pares += 1;
                    }case 3 -> {
                        tablero.verificacion("Rojo",posFicha,valor1, colorTurno);
                        mov1 = true;
                        pares += 1;
                    }default -> {
                        tablero.verificacion("Verde",posFicha,valor1, colorTurno);
                        mov1 = true;
                        pares += 1;
                    }
                }
            }
        }

    }

    /**
     * Método usado para cambiar los turnos de los jugadores dependiendo de la cantidad de integrantes
     */
    public void cambiarTurno(){
        if(cantJugadores == 4){
            if(turno == ROJO){
                this.turno = VERDE;
            } else if (turno == VERDE) {
                this.turno = AMARILLO;
            } else if (turno == AMARILLO) {
                this.turno = AZUL;
            }else {
                this.turno = ROJO;
            }
            todasAtrapadas = 0;
            mov1 = false;
            mov2 = false;
            primeraTirada = false;
            turnoPropio = false;
        }else if(cantJugadores == 2){
            if(turno == ROJO){
                this.turno = AMARILLO;
            } else {
                this.turno = ROJO;
            }
            todasAtrapadas = 0;
            mov1 = false;
            mov2 = false;
            primeraTirada = false;
            turnoPropio = false;
        }

    }

    /**
     * Método que retorna el atributo de "isTurnoPropio"
     * @return el booleano de isTurnoPropio
     */
    public boolean isTurnoPropio(){return turnoPropio;}

    /**
     * Método que modifica el atributo "isTurnoPropio"
     * @param nuevo Nuevo valor de "isTurnoPropio"
     */
    public void setTurnoPropio(boolean nuevo){turnoPropio = nuevo;}

    /**
     * Método que retorna si un jugador acaba de matar una ficha, es usado para saber si tiene que mover 20 movimientos
     * @return booleano que dice si un jugador acaba de matar una ficha
     */
    public boolean isMataFicha(){return tablero.isMataFicha();}
    /**
     * Método que retorna si un jugador sacó una ficha, es usado para saber si tiene que mover 10 movimientos
     * @return booleano que dice si un jugador acaba de sacar una ficha
     */
    public boolean isSacaFicha() {return tablero.isSacaFicha();}

    /**
     * Método usado pra saber si un jugador ya tiró 3 pares en su turno
     * @param color color de la casa donde se encuentra la ficha que movió en su último par
     * @param posFicha posición de la ficha dentro de la casa donde se encuentra la ficha que acaba de mover
     * @return booleano que confirma si se ejecutó alguna acción
     */
    private boolean verificarTresPares(String color, int posFicha){
        if (pares >= 4){
            if(turno == AMARILLO){
                tablero.volverCarcel("Amarillo", (Ficha) tablero.getElementosCasilla(color,posFicha).get(tablero.getElementosCasilla(color,posFicha).size()-1));
            } else if (turno == AZUL) {
                tablero.volverCarcel("Azul", (Ficha) tablero.getElementosCasilla(color,posFicha).get(tablero.getElementosCasilla(color,posFicha).size()-1));
            } else if (turno == ROJO) {
                tablero.volverCarcel("Rojo", (Ficha) tablero.getElementosCasilla(color,posFicha).get(tablero.getElementosCasilla(color,posFicha).size()-1));
            }else if (turno == VERDE) {
                tablero.volverCarcel("Verde", (Ficha) tablero.getElementosCasilla(color,posFicha).get(tablero.getElementosCasilla(color,posFicha).size()-1));
            }
            if(!((Ficha)tablero.getElementosCasilla(color, posFicha).get(tablero.getElementosCasilla(color,posFicha).size()-1)).isInmortal()){
                tablero.getElementosCasilla(color, posFicha).remove(tablero.getElementosCasilla(color,posFicha).size()-1);
                if(tablero.getCasilla(color,posFicha).isBloqueado())tablero.getCasilla(color,posFicha).quitarBloqueo();
                tablero.setMataFicha(false);
                cambiarTurno();
                pares = 0;
                return true;
            }
            //pares = 0;
            //mov1 = false;
            //mov2 = false;
            //primeraTirada = false;
        }
        return false;
    }

    /**
     * Método que compara si un turno es el mismo que el actual
     * @param turnoP turno a comparar
     * @return resultado de la comparación
     */
    public boolean getTurno(int turnoP){
        return turnoP == turno;
    }

    /**
     * Método que retorna el cambio del atributo de entero al correspondiente String
     * @return String de representación del turno
     */
    public String obtenerTurno(){
        return switch (turno){
            case 1 -> "Amarillo";
            case 2 ->"Azul";
            case 3 ->"Rojo";
            default -> "Verde";
        };
    }

    /**
     * Método que retorna en un String la concatenación del color y la posición de la ficha más lejana que tiene un jugador
     * @param color color del jugador del cual se quiere saber la ficha más lejana
     * @return String con la concatenación del color y la posición de la ficha más lejana que tiene un jugador
     */
    public String getMasLejos(String color){
        return tablero.getMaslejos(color);
    }

    /**
     * Método usado para tirar el dado y verificar si necesita ejecutar alguna acción
     */
    public void tirarDado() {
        valor1 = dado1.tirarDado();
        valor2 = dado2.tirarDado();
        //valor1 = 3;
        //valor2 = 3;
        turnoPropio = true;

        switch (turno){
            case 1:
                if (tablero.getValorCarcel("Amarillo") == 4){todasAtrapadas += 1;
                valor1 = 5;
                valor2 = 5;
                }
                else{primeraTirada = true;}
                break;
            case 2:
                if (tablero.getValorCarcel("Azul") == 4){todasAtrapadas += 1;}
                else{primeraTirada = true;}
                break;
            case 3:
                if (tablero.getValorCarcel("Rojo") == 4){todasAtrapadas += 1;
                    valor1 = 5;
                    valor2 = 3;
                }
                else{primeraTirada = true;}
                break;
            case 4:
                if (tablero.getValorCarcel("Verde") == 4){todasAtrapadas += 1;}
                else{primeraTirada = true;}
                break;
        }
        quitarBloqueoPares();

        if (todasAtrapadas == 3 && valor1 != 5 && valor2 != 5 && !isMataFicha() && !isSacaFicha()){
            reglaSalirCarcel();
            cambiarTurno();
        }else{
            reglaSalirCarcel();
        }

    }

    /**
     *Método que retorna el atributo valor1;
     * @return valor1
     */
    public int getValor1(){
        return valor1;
    }
    /**
     *Método que retorna el atributo valor2;
     * @return valor2
     */
    public int getValor2(){
        return valor2;
    }
    /**
     *Método que modifica el atributo valor3;
     */
    public void setValor3(int valor3) {
        this.valor3 = valor3;
    }
    /**
     *Método que retorna el atributo valor3;
     * @return valor3
     */
    public int getValor3() {
        return valor3;
    }

    /**
     * Método que retorna el atributo isMov1 que válida si ya ejecutó el movimiento del primer dado
     * @return boolean mov1
     */
    public boolean isMov1() {
        return mov1;
    }
    /**
     * Método que retorna el atributo isMov1 que válida si ya ejecutó el movimiento del segundo dado
     * @return boolean mov2
     */
    public boolean isMov2() {
        return mov2;
    }

    /**
     * Método que cambia el tributo mov1
     * @param mov1 boolean
     */
    public void setMov1(boolean mov1) {
        this.mov1 = mov1;
    }
    /**
     * Método que cambia el tributo mov2
     * @param mov2 boolean
     */
    public void setMov2(boolean mov2) {
        this.mov2 = mov2;
    }

    /**
     * Método que retorna el atributo tablero
     * @return Objeto tipo Tablero
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Método que verifica si un jugador puede salir de la cárcel y ejecuta las acciones correspondientes
     */
    private void reglaSalirCarcel(){

        String colorCasa = null;
        switch (turno){
            case 1 -> colorCasa = "Amarillo";
            case 2 -> colorCasa = "Azul";
            case 3 -> colorCasa = "Rojo";
            case 4 -> colorCasa = "Verde";
        }
        if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
            if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 0 && tablero.getValorCarcel(colorCasa) > 1) {
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 2;
                setMov1(true);
                setMov2(true);

            } else if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 1 && tablero.getValorCarcel(colorCasa) > 1
                    && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()) {
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(0);
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 2;
                setMov1(true);
                setMov2(true);

            }else if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 1 && tablero.getValorCarcel(colorCasa) > 1
                    && ((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()) {
                //tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                //tablero.getElementosCasilla(colorCasa, 4).remove(0);
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                //tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 1;
                //setMov1(true);
                setMov2(true);

            }else if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 2 && tablero.getValorCarcel(colorCasa) > 1
            && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()
            && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).isInmortal()) {
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(0);
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(0);
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 2;
                setMov1(true);
                setMov2(true);

            }else if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 2 && tablero.getValorCarcel(colorCasa) > 1
                    && ((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()
                    && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).isInmortal()) {
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(1);
                //tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 1;
                setMov1(true);
                //setMov2(true);

            }else if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 2 && tablero.getValorCarcel(colorCasa) > 1
                    && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()
                    && ((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).isInmortal()) {
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(0);
                //tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 1;
                setMov1(true);
                //setMov2(true);

            }else if(tablero.cantElementosSalida(colorCasa) < 2 && tablero.getValorCarcel(colorCasa) > 0){
                if (!mov1 && valor1 == 5){
                    tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    sacoFicha = 1;
                    setMov1(true);
                }else if (!mov2 && valor2 == 5) {
                    tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    sacoFicha = 1;
                    setMov2(true);
                } else if (!mov1 && !mov2 && valor1 + valor2 == 5) {
                    tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    sacoFicha = 1;
                    cambiarTurno();
                }
            } else if (tablero.isBloqueado(colorCasa, 4) && tablero.getValorCarcel(colorCasa) > 0){

                if (!mov1 && valor1 == 5 && (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                        || !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa))){
                    if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa)
                    && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()){
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0));
                        tablero.getElementosCasilla(colorCasa, 4).remove(0);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));

                    }else if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                            && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).isInmortal()) {
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1));
                        tablero.getElementosCasilla(colorCasa, 4).remove(1);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    }

                    setMov1(true);
                }else if (!mov2 && valor2 == 5 && (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                        || !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa))) {

                    if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa)
                    && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()){
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0));
                        tablero.getElementosCasilla(colorCasa, 4).remove(0);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));

                    }else if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                            && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).isInmortal()) {
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1));
                        tablero.getElementosCasilla(colorCasa, 4).remove(1);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    }
                    setMov2(true);
                }else if (!mov1 && !mov2 && valor1 + valor2 == 5 && (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                        || !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa))) {

                    if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa)
                    && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).isInmortal()){
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0));
                        tablero.getElementosCasilla(colorCasa, 4).remove(0);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));

                    }else if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                            && !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).isInmortal()) {
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1));
                        tablero.getElementosCasilla(colorCasa, 4).remove(1);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    }

                    setMov1(true);
                    setMov2(true);
                }
            }
        }
    }

    /**
     * Método que retorna la cantidad de fichas coronadas dependiendo de un color
     * @param color color de las fichas que se quiere validar la cantidad de fichas coronadas
     * @return
     */
    public int getGanadores(String color){
        return tablero.getGanadores(color);
    }

    /**
     * Método que retorna el atributo isBloqueado de una casilla
     * @param color color de la casa a la que pertenece la casilla a buscar
     * @param pos posición de la casilla a buscar
     * @return booleano que representa si la casilla está bloqueada
     */
    public boolean isBloqueado(String color, int pos){
        return  tablero.isBloqueado(color, pos);
    }

    /**
     * Método que retorna el atributo isSeguro de una casilla
     * @param color color de la casa a la que pertenece la casilla a buscar
     * @param pos posición de la casilla a buscar
     * @return booleano que representa si la casilla es segura
     */
    public boolean isSeguro(String color, int pos){
        return  tablero.isSeguro(color, pos);
    }

    /**
     * Método que retorna la cantidad de elementos en una casilla a partir de su color y si posición
     * @param color color de la casa a la que pertenece la casilla
     * @param pos posición de la casilla dentro del arreglo de casillas correspondiente
     * @return cantidad de elementos en una casilla a partir de su color y si posición
     */
    public int getCantidadCasilla(String color, int pos){
        return  tablero.getElementosCasilla(color,pos).size();
    }

    /**
     * Método que retorna el color de una ficha a partir del color de la casa donde se encuentra, suposición dentro de la casa
     * y su posición dentro de la casilla
     * @param color color de la casa a la que pertenece la ficha
     * @param pos posición de la ficha dentro del arreglo de casillas
     * @param i indice que indica su posición dentro de la casilla
     * @return String que representa el color de la ficha encontrada
     */
    public String getColorFicha(String color, int pos, int i){
        return  ((Ficha) tablero.getElementosCasilla(color,pos).get(i)).getColor();
    }

    /* Persistencia
     */

    /**
     * Método que guarda el objeto con el formato .dat
     * @param archivo Nombre del archivo resultante
     * @throws ParchisException GENERAL_EXCEPTION
     * @throws IOException Excepción de entrada salida
     */
    public void guardar(String archivo) throws ParchisException, IOException {
        if (archivo.equals("")) throw new ParchisException(ParchisException.GENERAL_EXCEPTION);
        if(!archivo.contains(".dat")) throw new ParchisException(ParchisException.ERR_EXTENSION_GUARDAR);
        if (archivo.contains("#") || archivo.contains("*") || archivo.contains("%") || archivo.contains("$")
                || archivo.contains("&")) throw new ParchisException(ParchisException.CARACTERES_EXCEPTION);

        FileOutputStream outFile = new FileOutputStream(archivo);
        ObjectOutputStream outObject = new ObjectOutputStream(outFile);
        outObject.writeObject(this);
        outObject.flush();
        outObject.close();
    }

    /**
     * Método que abre archivos con la extensión .dat
     * @param archivo Nombre del archivo
     * @return Nuevo objeto Parchis leido desde el archivo
     * @throws ParchisException GENERAL_EXCEPTION, ERR_EXTENSION_ABRIR
     * @throws IOException Error de entrada salida
     * @throws ClassNotFoundException Clase no encontrada
     */
    public Parchis abrir(String archivo) throws ParchisException, IOException, ClassNotFoundException {
        if (archivo.equals("")) throw new ParchisException(ParchisException.GENERAL_EXCEPTION);
        if(!archivo.contains(".dat")) throw new ParchisException(ParchisException.ERR_EXTENSION_ABRIR);
        FileInputStream inFile = new FileInputStream(archivo);
        ObjectInputStream inObject = new ObjectInputStream(inFile);
        Parchis nuevo = (Parchis)inObject.readObject();
        //System.out.println(nuevo);
        inObject.close();
        return nuevo;
    }
}
