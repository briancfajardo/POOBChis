package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GanadoresGUI extends JPanel {
    private FichasGUI fichasRojo;
    private FichasGUI fichasAzul;
    private FichasGUI fichasAmarillo;
    private FichasGUI fichasVerde;
    private int alto;
    private int ancho;
    private Parchis parchis;
    public GanadoresGUI(Parchis parchis){
        setBorder(BorderFactory.createEtchedBorder());
        setVisible(true);
        fichasRojo = new FichasGUI("Rojo" ,0);
        fichasRojo.setTipo(fichasRojo.FINAL);

        fichasVerde = new FichasGUI("Verde" ,0);
        fichasVerde.setTipo(fichasVerde.FINAL);

        fichasAzul = new FichasGUI("Azul" ,0);
        fichasAzul.setTipo(fichasAzul.FINAL);

        fichasAmarillo = new FichasGUI("Amarillo" ,0);
        fichasAmarillo.setTipo(fichasAmarillo.FINAL);

        this.parchis = parchis;
    }
    public void actualizar(){

        fichasRojo.setCant(parchis.getGanadores("Rojo"));
        fichasVerde.setCant(parchis.getGanadores("Verde"));
        fichasAmarillo.setCant(parchis.getGanadores("Amarillo"));
        fichasAzul.setCant(parchis.getGanadores("Azul"));
        repaint();
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

        fichasRojo.setXY(ancho,alto);
        fichasVerde.setXY(ancho,alto);
        fichasAzul.setXY(ancho,alto);
        fichasAmarillo.setXY(ancho,alto);

        fichasRojo.paint(g);
        fichasAmarillo.paint(g);
        fichasAzul.paint(g);
        fichasVerde.paint(g);
    }
}
