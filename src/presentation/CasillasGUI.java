package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CasillasGUI extends JPanel {
    private OpcionFichaGUI opcionFichaGUI;
    private boolean habilitado = true;
    private Point punto;
    private MouseListener clic = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (habilitado && parchis.isTurnoPropio()){
                if(!parchis.isMov1() || !parchis.isMov2()){
                    punto=MouseInfo.getPointerInfo().getLocation();
                    int x=punto.x;
                    int y=punto.y;
                    opcionFichaGUI = new OpcionFichaGUI(parchis, x, y);
                    if(parchis.getCantidadCasilla(color, num) != 0){opcionFichaGUI.moverFicha(color, num);}
                }
            }

            //contieneFichaColor(turno);
            //System.out.println(turno);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
    int alto;
    int ancho;
    public int ANCHA = 1;
    public int ALTA = 0;
    private int tipo;
    private FichasGUI ficha;
    private int num;
    private Parchis parchis;
    private String color;
    private boolean bloqueado;
    private boolean seguro;
    //private String turno;

    public CasillasGUI(int num, String msg, Parchis parchis, String color){
        this.parchis = parchis;
        this.color = color;
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(clic);
        setVisible(true);
        add(new JLabel(msg));
        alto = getSize().height;
        ancho = getSize().width;
        ficha = new FichasGUI(color,0);
        this.num = num;
        this.bloqueado = parchis.isBloqueado(color,num);
        this.seguro = parchis.isSeguro(color,num);
        //turno = convertirStringTurno();
    }

    //public String convertirStringTurno(){
//
    //    if (parchis.getTurno(parchis.ROJO)) {
    //        return "Rojo";
    //    }else if (parchis.getTurno(parchis.VERDE)) {
    //        return "Verde";
    //    }else if (parchis.getTurno(parchis.AZUL)) {
    //        return "Azul";
    //    }else if (parchis.getTurno(parchis.AMARILLO)) {
    //        return "Amarillo";
    //    }
    //    return null;
    //}

    public void actualizar(String turno){
        int aux = parchis.getCantidadCasilla(color, num);
        ficha.setCant(aux);

        habilitado = contieneFichaColor(turno);
        if(parchis.isSeguro(color,num) && num != 4){
            setBackground(new Color(192, 180, 179));
        } else if (parchis.isBloqueado(color,num) && num != 4) {
            setBackground(new Color(216, 144, 225));
        }else if(num != 4 && num >= 0 && num <16){
            setBackground(new Color(237, 237, 237));
        }
        try{
            if (aux == 1){
                //System.out.println(aux);
                ficha.setColor(parchis.getColorFicha(color,num,0));
            }else if(aux == 2){
                ficha.setColor(parchis.getColorFicha(color,num,0));
                ficha.setColor2(parchis.getColorFicha(color,num,1));
            }
        }catch (Exception e){
            System.out.println(num + " " + parchis.getCantidadCasilla(color, num));
        }

        //if(parchis.isBloqueado(color,num)){
        //    setBackground(new Color (192, 180, 179));
        //}
        repaint();
    }
    public void setTipo(int tipo){
        this.tipo = tipo;
        if(tipo == ANCHA){
            ficha.setTipo(ficha.ANCHA);
        }else {
            ficha.setTipo(ficha.ALTA);
        }

    }

    public boolean contieneFichaColor (String colorTurno){
        if (ficha.getCant() == 1){
            return ficha.getColor().equals(colorTurno);
        }else if (ficha.getCant() == 2){
            return ficha.getColor().equals(colorTurno) || ficha.getColor2().equals(colorTurno);
        }

        return false;
    }

    public void paint(Graphics g){
        super.paint(g);
        alto = getSize().height;
        ancho = getSize().width;
        ficha.setXY(ancho,alto);
        ficha.paint(g);
    }
}
