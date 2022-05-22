package domain;

public class SacarCarcel extends Comodin{

    private Parchis parchis;
    private  String color;
    private int pos;
    public SacarCarcel(Parchis parchis, String color, int pos){
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
        if(parchis.getTablero().cantElementosSalida(turno) < 2){
            Ficha f = parchis.getTablero().salirCarcel(turno);
            parchis.getTablero().nuevaFicha(turno,4,f);
        }
    }
}
