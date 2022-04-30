package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GanadoresGUI extends JPanel {
    private FichasGUI fichas;
    private String color;
    private int cant;
    private int alto;
    private int ancho;
    public GanadoresGUI(String color, int cant){
        this.color = color;
        this.cant = cant;
        setBorder(BorderFactory.createEtchedBorder());
        setVisible(true);
        fichas = new FichasGUI("Rojo" ,4);
        fichas.setTipo(fichas.FINAL);
    }
    public void paint(Graphics g){
        super.paint(g);
        alto = getSize().height;
        ancho = getSize().width;

        int[] puntosX={0, ancho/2, ancho};
        int[] puntosy={0, alto/2, 0};
        g.setColor(new Color(31, 143, 254));
        g.fillPolygon(puntosX,puntosy,3);

        int[] puntosX2={ancho, ancho/2, ancho};
        int[] puntosy2={0, alto/2, alto};
        g.setColor(new Color(248, 197, 27));
        g.fillPolygon(puntosX2,puntosy2,3);

        int[] puntosX3={0, ancho/2, ancho};
        int[] puntosy3={alto, alto/2, alto};
        g.setColor(new Color(33, 202, 88));
        g.fillPolygon(puntosX3,puntosy3,3);

        int[] puntosX4={0, ancho/2, 0};
        int[] puntosy4={0, alto/2, alto};
        g.setColor(new Color(232, 73, 55));
        g.fillPolygon(puntosX4,puntosy4,3);

        fichas.setXY(ancho,alto);
        fichas.paint(g);
    }
}
