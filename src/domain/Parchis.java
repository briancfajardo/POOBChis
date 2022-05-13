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
    private int todasAtrapadas;

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
            if (!mov1 || !mov2){
                reglaSalirCarcel();
            }
            if (valor1 != valor2){
                pares = 0;
                if (mov1 && mov2){cambiarTurno();}
            } else{
                pares +=1;
            }
        }

        //System.out.println(pares);
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
        }
    }

    public boolean verificarTresPares(String color, int posFicha){
        if (pares == 5){
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
        switch (turno){
            case 1:
                if (tablero.getValorCarcel("Amarillo") == 4){todasAtrapadas += 1;
                valor1 = 5;
                valor2 = 5;}
                break;
            case 2:
                if (tablero.getValorCarcel("Azul") == 4){todasAtrapadas += 1;}
                break;
            case 3:
                if (tablero.getValorCarcel("Rojo") == 4){todasAtrapadas += 1;}
                break;
            case 4:
                if (tablero.getValorCarcel("Verde") == 4){todasAtrapadas += 1;}
                break;
        }

        if (todasAtrapadas == 3 && valor1 != 5 && valor2 != 5){
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

    private void reglaSalirCarcel(){

        String colorCasa = null;
        switch (turno){
            case 1 -> colorCasa = "Amarillo";
            case 2 -> colorCasa = "Azul";
            case 3 -> colorCasa = "Rojo";
            case 4 -> colorCasa = "Verde";
        }
        if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
            if (valor1 == 5 && valor2 == 5 && tablero.cantElementosSalida(colorCasa) == 0 && tablero.getValorCarcel("Rojo") > 1) {
                tablero.salirCarcel(colorCasa);
                tablero.salirCarcel(colorCasa);
                tablero.nuevaFicha(colorCasa, 4, colorCasa);
                tablero.nuevaFicha(colorCasa, 4, colorCasa);
                sacoFicha = 2;
                setMov1(true);
                setMov2(true);

            } else if(tablero.cantElementosSalida(colorCasa) < 2 && tablero.getValorCarcel(colorCasa) > 0){
                if (!mov1 && valor1 == 5){
                    tablero.salirCarcel(colorCasa);
                    tablero.nuevaFicha(colorCasa, 4, colorCasa);sacoFicha = 1;
                    setMov1(true);
                }else if (!mov2 && valor2 == 5) {
                    tablero.salirCarcel(colorCasa);
                    tablero.nuevaFicha(colorCasa, 4, colorCasa);
                    sacoFicha = 1;
                    setMov2(true);
                } else if (!mov1 && !mov2 && valor1 + valor2 == 5) {
                    tablero.salirCarcel(colorCasa);tablero.nuevaFicha(colorCasa, 4, colorCasa);
                    sacoFicha = 1;
                    cambiarTurno();
                }
            } else if (tablero.isBloqueado(colorCasa, 4) && tablero.getValorCarcel(colorCasa) > 0){

                if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor().equals(colorCasa)){
                    tablero.volverCarcel(((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(0)).getColor());
                    tablero.getElementosCasilla(colorCasa, 4).remove(0);
                    tablero.salirCarcel(colorCasa);
                    tablero.nuevaFicha(colorCasa, 4, colorCasa);

                }else if (!((Ficha)tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor().equals(colorCasa)) {
                    tablero.volverCarcel(((Ficha) tablero.getElementosCasilla(colorCasa, 4).get(1)).getColor());
                    tablero.getElementosCasilla(colorCasa, 4).remove(1);
                    tablero.salirCarcel(colorCasa);
                    tablero.nuevaFicha(colorCasa, 4, colorCasa);
                }

                if (!mov1 && valor1 == 5){
                    setMov1(true);
                }else if (!mov2 && valor2 == 5) {
                    setMov2(true);
                }else if (!mov1 && !mov2 && valor1 + valor2 == 5) {
                    cambiarTurno();
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
