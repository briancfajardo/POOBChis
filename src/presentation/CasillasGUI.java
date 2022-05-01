package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CasillasGUI extends JPanel {
    MouseListener clic = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Lumpias u");
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
    public CasillasGUI(int num, String msg, Parchis parchis, String color){
        this.parchis = parchis;
        this.color = color;
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(clic);
        setVisible(true);
        add(new JLabel(msg));
        alto = getSize().height;
        ancho = getSize().width;
        ficha = new FichasGUI("Azul",0);
        this.num = num;
    }
    public void actualizar(){
        ficha.setCant(parchis.getCantidadCasilla(color, num));
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
    public void paint(Graphics g){
        super.paint(g);
        alto = getSize().height;
        ancho = getSize().width;
        ficha.setXY(ancho,alto);
        ficha.paint(g);
    }
}
