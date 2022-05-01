package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CarcelGUI extends JPanel {
    private int x = 100;
    private int y = 100;
    private final int ancho = 40;
    private final int alto = 40;
    private Color color;
    private String col;
    private int cant;
    private FichasGUI fichas;
    private Parchis parchis;
    public CarcelGUI(Color color, Color color2, String col, Parchis parchis){
        this.col = col;
        this.parchis = parchis;
        this.color = color;
        this.cant = parchis.getCarcel(col);
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(color2);
        setVisible(true);
        fichas = new FichasGUI("Azul" ,cant);
        fichas.setTipo(fichas.CARCEL);
    }
    public void actualizar(){
        cant = parchis.getCarcel(col);
        fichas.setCant(cant);
        repaint();
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(color);
        g.fillOval(30,70,ancho,alto);
        g.fillOval(90,70,ancho,alto);
        g.fillOval(30,130,ancho,alto);
        g.fillOval(90,130,ancho,alto);
        fichas.paint(g);
    }
}
