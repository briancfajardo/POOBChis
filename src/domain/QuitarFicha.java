package domain;

public class QuitarFicha extends Comodin{

    private Parchis parchis;
    private  String color;
    private int pos;
    public QuitarFicha (Parchis parchis, String color, int pos){
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
        String turno = parchis.obtenerTurno();
        if(turno.equals("Rojo")){

        }else {

        }
        Ficha f = ((Ficha) parchis.getTablero().getElementosCasilla(color,pos).get(0));
        parchis.getTablero().volverCarcel(color,f);
        parchis.getTablero().getCasilla(color, pos).getElementos().remove(0);
    }
}
