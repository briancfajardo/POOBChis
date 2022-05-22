package domain;

public class Inmortal extends Comodin{
    private Parchis parchis;
    private  String color;
    private int pos;
    public Inmortal (Parchis parchis, String color, int pos){
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
        ((Ficha)parchis.getTablero().getElementosCasilla(color,pos).get(parchis.getTablero().getElementosCasilla(color,pos).size()-1)).setInmortal(true);

    }
}
