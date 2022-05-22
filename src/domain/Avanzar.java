package domain;

public class Avanzar extends Comodin{
    private Parchis parchis;
    private  String color;
    private int pos;
    public Avanzar(Parchis parchis, String color, int pos){
        super();
        this.parchis = parchis;
        this.color = color;
        this.pos = pos;
    }

    @Override
    public void mostrarPoder() {

    }

    @Override
    public void usarPoder() {
        parchis.setValor3(5);
        parchis.moverFicha(color, pos);
    }
}
