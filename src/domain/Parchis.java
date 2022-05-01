package domain;

public class Parchis {
    private Tablero tablero;
    private Carcel carceles;
    private Dado dado1;
    private Dado dado2;
    private int valor1;
    private int valor2;


    public Parchis(){
        tablero = new Tablero();
        carceles = new Carcel();
        dado1 = new Dado();
        dado2 = new Dado();
    }
    public int getCarcel(String color){
        return carceles.getColor(color);
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
    private void reglaSalirCarcel(){
        if(valor1 == 5 || valor2 == 5 || valor2+valor1 == 5){
            if(valor1 == 5 && valor2 == 5){
                carceles.setColor("Rojo");
                carceles.setColor("Rojo");
                tablero.cambiarCasilla("Rojo",4, "Rojo");
                tablero.cambiarCasilla("Rojo",4, "Rojo");
            }else {
                carceles.setColor("Rojo");
                tablero.cambiarCasilla("Rojo",4, "Rojo");
            }
        }
    }
    public int getCantidadCasilla(String color, int pos){
        return  tablero.getCasilla(color,pos).size();
    }
}
