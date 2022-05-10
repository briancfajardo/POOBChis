package domain;

public class Parchis {
    private Tablero tablero;
    private Carcel carceles;
    private Dado dado1;
    private Dado dado2;
    private int valor1;
    private int valor2;
    public int AMARILLO = 1;
    public int AZUL = 2;
    public int ROJO = 3;
    public int VERDE = 4;
    private int turno;

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
        switch (color){
            case "Rojo" -> {
                tablero.verificacion(color, posFicha, valor1);
                turno = VERDE;
            }
            case "Azul" -> {
                tablero.verificacion(color, posFicha, valor1);
                turno = ROJO;
            }
            case "Amarillo" -> {
                tablero.verificacion(color, posFicha, valor1);
                turno = AZUL;
            }
            case "Verde" -> {
                tablero.verificacion(color, posFicha, valor1);
                turno = AMARILLO;
            }
        }
    }
    public int getTurno(){return turno;}

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
    private void reglaSalirCarcel(){
        if (turno == ROJO) {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5) {
                    tablero.salirCarcel("Rojo");
                    tablero.salirCarcel("Rojo");
                    tablero.nuevaFicha("Rojo", 4, "Rojo");
                    tablero.nuevaFicha("Rojo", 4, "Rojo");
                } else {
                    tablero.salirCarcel("Rojo");
                    tablero.nuevaFicha("Rojo", 4, "Rojo");
                }
            }
        } else if (turno == AZUL) {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5) {
                    tablero.salirCarcel("Azul");
                    tablero.salirCarcel("Azul");
                    tablero.nuevaFicha("Azul", 4, "Azul");
                    tablero.nuevaFicha("Azul", 4, "Azul");
                } else {
                    tablero.salirCarcel("Azul");
                    tablero.nuevaFicha("Azul", 4, "Azul");
                }
            }
        }else if (turno == AMARILLO) {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5) {
                    tablero.salirCarcel("Amarillo");
                    tablero.salirCarcel("Amarillo");
                    tablero.nuevaFicha("Amarillo", 4, "Amarillo");
                    tablero.nuevaFicha("Amarillo", 4, "Amarillo");
                } else {
                    tablero.salirCarcel("Amarillo");
                    tablero.nuevaFicha("Amarillo", 4, "Amarillo");
                }
            }
        }else {
            if (valor1 == 5 || valor2 == 5 || valor2 + valor1 == 5) {
                if (valor1 == 5 && valor2 == 5) {
                    tablero.salirCarcel("Verde");
                    tablero.salirCarcel("Verde");
                    tablero.nuevaFicha("Verde", 4, "Verde");
                    tablero.nuevaFicha("Verde", 4, "Verde");
                } else {
                    tablero.salirCarcel("Verde");
                    tablero.nuevaFicha("Verde", 4, "Verde");
                }
            }
        }

    }
    public int getCantidadCasilla(String color, int pos){
        return  tablero.getCasilla(color,pos).size();
    }
    public String getColorFicha(String color, int pos, int i){
        return  ((Ficha) tablero.getCasilla(color,pos).get(i)).getColor();
    }
}
