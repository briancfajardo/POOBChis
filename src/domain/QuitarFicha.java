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
        String masLejos;
        String colorOpuesto;
        Ficha f;
        if(turno.equals("Rojo")){
            colorOpuesto = "Amarillo";
            masLejos = parchis.getMasLejos(colorOpuesto);
        }else {
            colorOpuesto = "Rojo";
            masLejos = parchis.getMasLejos(colorOpuesto);
        }
        String [] colorPos = masLejos.split(" ");
        String colorC = colorPos[0];
        int pos = Integer.parseInt(colorPos[1]);
        if(colorOpuesto.equals(((Ficha) parchis.getTablero().getElementosCasilla(colorC,pos).get(0)).getColor())){
            f = ((Ficha) parchis.getTablero().getElementosCasilla(colorC,pos).get(0));
        } else {
            f = ((Ficha) parchis.getTablero().getElementosCasilla(colorC,pos).get(1));
        }
        parchis.getTablero().volverCarcel(f.getColor(),f);
        parchis.getTablero().getCasilla(colorC, pos).getElementos().remove(f);
    }
}
