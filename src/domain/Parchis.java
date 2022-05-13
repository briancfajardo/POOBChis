package domain;

public class Parchis {
    private Tablero tablero;
    private Carcel carceles;
    private Dado dado1;
    private Dado dado2;
    private int valor1;
    private int valor2;
    private int valor3;
    public int AMARILLO = 1;
    public int AZUL = 2;
    public int ROJO = 3;
    public int VERDE = 4;
    private int turno, cantJugadores = 4, sacoFicha, pares;
    private boolean mov1, mov2;

    public Parchis(){
        tablero = new Tablero();
        carceles = new Carcel();
        dado1 = new Dado();
        dado2 = new Dado();
        turno = ROJO;
    }
    public int getCarcel(String color){
        return tablero.getValorCarcel(color);
    }
    public void moverFicha(String color, int posFicha){
        if (!verificarTresPares(color, posFicha)){
            tablero.verificacion(color, posFicha, valor3);
            if (mov1 && mov2){
                cambiarTurno(color, posFicha);
            }
        }

        //System.out.println(pares);
    }


    public void cambiarTurno(String color, int posFicha){
        if(cantJugadores == 4){
            if(valor1 != valor2){
                if(turno == ROJO){
                    this.turno = VERDE;
                } else if (turno == VERDE) {
                    this.turno = AMARILLO;
                } else if (turno == AMARILLO) {
                    this.turno = AZUL;
                }else {
                    this.turno = ROJO;
                }
                pares = 0;

            }else {
                pares += 1;

            }
            mov1 = false;
            mov2 = false;
        }
    }

    public boolean verificarTresPares(String color, int posFicha){
        if (pares == 2){
            tablero.getElementosCasilla(color, posFicha).remove(tablero.getElementosCasilla(color,posFicha).size()-1);
            if(turno == AMARILLO){
                tablero.volverCarcel("Amarillo");
                this.turno = AZUL;
            } else if (turno == AZUL) {
                tablero.volverCarcel("Azul");
                this.turno = ROJO;
            } else if (turno == ROJO) {
                tablero.volverCarcel("Rojo");
                this.turno = VERDE;
            }else if (turno == VERDE) {
                tablero.volverCarcel("Verde");
                this.turno = AMARILLO;
            }
            pares = 0;
            mov1 = false;
            mov2 = false;
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
        reglaSalirCarcel();
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

    private void reglaSalirCarcel(){
        if (turno == ROJO) {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5 && tablero.cantElementosSalida("Rojo") == 0 && tablero.getValorCarcel("Rojo") > 1) {
                    tablero.salirCarcel("Rojo");
                    tablero.salirCarcel("Rojo");
                    tablero.nuevaFicha("Rojo", 4, "Rojo");
                    tablero.nuevaFicha("Rojo", 4, "Rojo");
                    sacoFicha = 2;
                } else if(tablero.cantElementosSalida("Rojo") < 2 && tablero.getValorCarcel("Rojo") > 0){
                    tablero.salirCarcel("Rojo");
                    tablero.nuevaFicha("Rojo", 4, "Rojo");
                    sacoFicha = 1;
                }
            }
        } else if (turno == AZUL) {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5 && tablero.cantElementosSalida("Azul") == 0 && tablero.getValorCarcel("Azul") > 1) {
                    tablero.salirCarcel("Azul");
                    tablero.salirCarcel("Azul");
                    tablero.nuevaFicha("Azul", 4, "Azul");
                    tablero.nuevaFicha("Azul", 4, "Azul");
                    sacoFicha = 2;
                } else if(tablero.cantElementosSalida("Azul") < 2 && tablero.getValorCarcel("Azul") > 0){
                    tablero.salirCarcel("Azul");
                    tablero.nuevaFicha("Azul", 4, "Azul");
                    sacoFicha = 1;
                }
            }
        }else if (turno == AMARILLO) {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5 && tablero.cantElementosSalida("Amarillo") == 0 && tablero.getValorCarcel("Amarillo") > 1) {
                    tablero.salirCarcel("Amarillo");
                    tablero.salirCarcel("Amarillo");
                    tablero.nuevaFicha("Amarillo", 4, "Amarillo");
                    tablero.nuevaFicha("Amarillo", 4, "Amarillo");
                    sacoFicha = 2;
                } else if(tablero.cantElementosSalida("Amarillo") < 2 && tablero.getValorCarcel("Amarillo") > 0){
                    tablero.salirCarcel("Amarillo");
                    tablero.nuevaFicha("Amarillo", 4, "Amarillo");
                    sacoFicha = 1;
                }
            }
        }else {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5 && tablero.cantElementosSalida("Verde") == 0 && tablero.getValorCarcel("Verde") > 1) {
                    tablero.salirCarcel("Verde");
                    tablero.salirCarcel("Verde");
                    tablero.nuevaFicha("Verde", 4, "Verde");
                    tablero.nuevaFicha("Verde", 4, "Verde");
                    sacoFicha = 2;
                } else if(tablero.cantElementosSalida("Verde") < 2 && tablero.getValorCarcel("Verde") > 0){
                    tablero.salirCarcel("Verde");
                    tablero.nuevaFicha("Verde", 4, "Verde");
                    sacoFicha = 1;
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
    public int getCantidadCasilla(String color, int pos){
        return  tablero.getElementosCasilla(color,pos).size();
    }
    public String getColorFicha(String color, int pos, int i){
        return  ((Ficha) tablero.getElementosCasilla(color,pos).get(i)).getColor();
    }
}
