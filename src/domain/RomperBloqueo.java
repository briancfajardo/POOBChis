package domain;

public class RomperBloqueo extends Comodin{

    private Parchis parchis;
    private  String color;
    private int pos;
    public RomperBloqueo (Parchis parchis, String color, int pos){
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
        String masCerca;
        if(parchis.getTablero().verificarBloqueoComodin(color, pos, parchis.obtenerTurno()) != null){
            masCerca = parchis.getTablero().verificarBloqueoComodin(color, pos, parchis.obtenerTurno());
            String [] colorPos = masCerca.split(" ");
            String colorC = colorPos[0];
            int pos = Integer.parseInt(colorPos[1]);
            parchis.setValor3(1);
            parchis.moverFicha(colorC,pos);
        }
    }
}
