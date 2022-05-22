package domain;

public class IrseCarcel extends Comodin{
    private Parchis parchis;
    private  String color;
    private int pos;
    public IrseCarcel(Parchis parchis, String color, int pos){
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
        Ficha f = ((Ficha) parchis.getTablero().getElementosCasilla(color,pos).get(0));
        parchis.getTablero().volverCarcel(color,f);
        parchis.getTablero().getCasilla(color, pos).getElementos().remove(0);
    }
}
