package domain;

import java.util.ArrayList;

import java.io.*;

public class Parchis {
    private Tablero tablero;
    private Dado dado1, dado2;
    private int valor1, valor2, valor3;
    public int AMARILLO = 1;
    public int AZUL = 2;
    public int ROJO = 3;
    public int VERDE = 4;
    private int turno, cantJugadores = 4, sacoFicha, pares;
    private boolean mov1, mov2;
    private int todasAtrapadas;

    private boolean primeraTirada = false;
    private boolean turnoPropio;
    private ArrayList<String> tipoAmarillo;
    private ArrayList<String> tipoAzul;
    private ArrayList<String> tipoVerde;
    private ArrayList<String> tipoRojo;

    public Parchis(ArrayList<String> tipoAmarillo, ArrayList<String> tipoAzul, ArrayList<String> tipoVerde, ArrayList<String> tipoRojo){
        this.tipoAmarillo = tipoAmarillo;
        this.tipoAzul = tipoAzul;
        this.tipoRojo = tipoRojo;
        this.tipoVerde = tipoVerde;
        tablero = new Tablero(tipoAmarillo, tipoAzul, tipoVerde, tipoRojo);
        dado1 = new Dado();
        dado2 = new Dado();
        turno = ROJO;
    }
    public int getCarcel(String color){
        return tablero.getValorCarcel(color);
    }

    public boolean getPrimeraTirada(){
        return primeraTirada;
    }
    public void moverFicha(String color, int posFicha){
        //System.out.println("mov1: " + mov1 + "   mov2: " + mov2+ "   mata: " + isMataFicha() + "   saca: " + isSacaFicha());
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

    public ArrayList<String> getTipoAmarillo() {
        return tipoAmarillo;
    }

    public ArrayList<String> getTipoAzul() {
        return tipoAzul;
    }

    public ArrayList<String> getTipoRojo() {
        return tipoRojo;
    }

    public ArrayList<String> getTipoVerde() {
        return tipoVerde;
    }

    public void moverGanancia(String color, int posFicha, int moverGanado){
        tablero.setMataFicha(false);
        tablero.setSacaFicha(false);
        tablero.verificacion(color, posFicha, moverGanado, turnoString());
        if(!isMataFicha() && !isSacaFicha() && valor2 != valor1 && mov1 && mov2){cambiarTurno();}
    }
    private String turnoString(){
        return switch (turno){
            case 1 -> "Amarillo";
            case 2 -> "Azul";
            case 3 -> "Rojo";
            default -> "Verde";
        };
    }

    public void quitarBloqueoPares(){
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
        }

    }

    public boolean isTurnoPropio(){return turnoPropio;}
    public void setTurnoPropio(boolean nuevo){turnoPropio = nuevo;}
    public boolean isMataFicha(){return tablero.isMataFicha();}

    public boolean isSacaFicha() {return tablero.isSacaFicha();}


    public boolean verificarTresPares(String color, int posFicha){
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
            tablero.getElementosCasilla(color, posFicha).remove(tablero.getElementosCasilla(color,posFicha).size()-1);
            tablero.setMataFicha(false);
            cambiarTurno();
            pares = 0;
            //pares = 0;
            //mov1 = false;
            //mov2 = false;
            //primeraTirada = false;
            return true;
        }
        return false;
    }
    public boolean getTurno(int turnoP){
        return turnoP == turno;
    }

    public void tirarDado() {
        valor1 = dado1.tirarDado();
        valor2 = dado2.tirarDado();
        //valor1 = 3;
        //valor2 = 3;
        turnoPropio = true;

        switch (turno){
            case 1:
                if (tablero.getValorCarcel("Amarillo") == 4){todasAtrapadas += 1;
                //valor1 = 5;
                //valor2 = 5;
                }
                else{primeraTirada = true;}
                break;
            case 2:
                if (tablero.getValorCarcel("Azul") == 4){todasAtrapadas += 1;}
                else{primeraTirada = true;}
                break;
            case 3:
                if (tablero.getValorCarcel("Rojo") == 4){todasAtrapadas += 1;
                    //valor1 = 5;
                    //valor2 = 3;
                }
                else{primeraTirada = true;}
                break;
            case 4:
                if (tablero.getValorCarcel("Verde") == 4){todasAtrapadas += 1;}
                else{primeraTirada = true;}
                break;
        }

        //System.out.println("todasAtrapadas:" + todasAtrapadas +
        //        "   valor1 :" + valor1 + "   valor2 :" + valor2 +
        //        "   m :" + !isMataFicha() + "   s :" + !isSacaFicha());

        //System.out.println("Rojo "+tablero.contarBloqueos("Rojo"));
        //System.out.println("Verde "+tablero.contarBloqueos("Verde"));
        //System.out.println("Amarillo "+tablero.contarBloqueos("Amarillo"));
        //System.out.println("Azul "+tablero.contarBloqueos("Azul")+"\n");
        quitarBloqueoPares();
        if (todasAtrapadas == 3 && valor1 != 5 && valor2 != 5 && !isMataFicha() && !isSacaFicha()){
            reglaSalirCarcel();
            cambiarTurno();
        }else{
            reglaSalirCarcel();
        }

    }
    public int getValor1(){
        return valor1;
    }
    public int getValor2(){
        return valor2;
    }

    public void setValor3(int valor3) {
        this.valor3 = valor3;
    }

    public int getValor3() {
        return valor3;
    }
    public boolean isMov1() {
        return mov1;
    }
    public boolean isMov2() {
        return mov2;
    }

    public void setMov1(boolean mov1) {
        this.mov1 = mov1;
    }

    public void setMov2(boolean mov2) {
        this.mov2 = mov2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void reglaSalirCarcel(){

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

            } else if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 1 && tablero.getValorCarcel(colorCasa) > 1) {
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(0);
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 2;
                setMov1(true);
                setMov2(true);

            }else if (valor1 == 5 && valor2 == 5 && !mov1 && !mov2 && tablero.cantElementosSalida(colorCasa) == 2 && tablero.getValorCarcel(colorCasa) > 1) {
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(0);
                tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(0));
                tablero.getElementosCasilla(colorCasa, 4).remove(0);
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                sacoFicha = 2;
                setMov1(true);
                setMov2(true);

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
                    tablero.salirCarcel(colorCasa);
                    tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    sacoFicha = 1;
                    cambiarTurno();
                }
            } else if (tablero.isBloqueado(colorCasa, 4) && tablero.getValorCarcel(colorCasa) > 0){

                if (!mov1 && valor1 == 5 && (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                        || !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa))){
                    if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa)){
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0));
                        tablero.getElementosCasilla(colorCasa, 4).remove(0);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));

                    }else if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)) {
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1));
                        tablero.getElementosCasilla(colorCasa, 4).remove(1);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    }

                    setMov1(true);
                }else if (!mov2 && valor2 == 5 && (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                        || !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa))) {

                    if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa)){
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0));
                        tablero.getElementosCasilla(colorCasa, 4).remove(0);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));

                    }else if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)) {
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor(), (Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1));
                        tablero.getElementosCasilla(colorCasa, 4).remove(1);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));
                    }
                    setMov2(true);
                }else if (!mov1 && !mov2 && valor1 + valor2 == 5 && (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)
                        || !((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa))) {

                    if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa)){
                        tablero.eliminarBloqueada(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(),colorCasa,4);
                        tablero.volverCarcel(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor(), (Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0));
                        tablero.getElementosCasilla(colorCasa, 4).remove(0);
                        tablero.nuevaFicha(colorCasa, 4, tablero.salirCarcel(colorCasa));

                    }else if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)) {
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


    public int getGanadores(String color){
        return tablero.getGanadores(color);
    }
    public boolean isBloqueado(String color, int pos){
        return  tablero.isBloqueado(color, pos);
    }
    public boolean isSeguro(String color, int pos){
        return  tablero.isSeguro(color, pos);
    }
    public int getCantidadCasilla(String color, int pos){
        return  tablero.getElementosCasilla(color,pos).size();
    }
    public String getColorFicha(String color, int pos, int i){
        return  ((Ficha) tablero.getElementosCasilla(color,pos).get(i)).getColor();
    }

    /* Persistencia
     */
    public void guardar(String archivo) throws ParchisException, IOException {
        if (archivo.equals("")) throw new ParchisException(ParchisException.GENERAL_EXCEPTION);
        FileOutputStream outFile = new FileOutputStream(archivo);
        ObjectOutputStream outObject = new ObjectOutputStream(outFile);
        outObject.writeObject(this);
        outObject.flush();
        outObject.close();
    }

    public Parchis abrir(String archivo) throws ParchisException, IOException, ClassNotFoundException {
        if (archivo.equals("")) throw new ParchisException(ParchisException.GENERAL_EXCEPTION);
        FileInputStream inFile = new FileInputStream(archivo);
        ObjectInputStream inObject = new ObjectInputStream(inFile);
        Parchis nuevo = (Parchis)inObject.readObject();
        //System.out.println(nuevo);
        inObject.close();
        return nuevo;
    }
}
