package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GanadoresGUI extends JPanel {
    private FichasGUI fichasRojo;
    private FichasGUI fichasAzul;
    private FichasGUI fichasAmarillo;
    private FichasGUI fichasVerde;
    private int alto;
    private int ancho;
    private Parchis parchis;

    private ArrayList<String> tipoAmarillo = new ArrayList<>();
    private ArrayList<String> tipoAzul = new ArrayList<>();
    private ArrayList<String> tipoVerde = new ArrayList<>();
    private ArrayList<String> tipoRojo = new ArrayList<>();

    public GanadoresGUI(Parchis parchis){
        setBorder(BorderFactory.createEtchedBorder());
        setVisible(true);
        this.parchis = parchis;

        inicializarTipos();

        fichasRojo = new FichasGUI("Rojo" ,0, tipoRojo.get(0), tipoRojo.get(1), tipoRojo.get(2), tipoRojo.get(3));
        fichasRojo.setTipo(fichasRojo.FINAL);

        fichasVerde = new FichasGUI("Verde" ,0, tipoVerde.get(0), tipoVerde.get(1), tipoVerde.get(2), tipoVerde.get(3));
        fichasVerde.setTipo(fichasVerde.FINAL);

        fichasAzul = new FichasGUI("Azul" ,0,tipoAzul.get(0), tipoAzul.get(1), tipoAzul.get(2), tipoAzul.get(3));
        fichasAzul.setTipo(fichasAzul.FINAL);

        fichasAmarillo = new FichasGUI("Amarillo" ,0,tipoAmarillo.get(0), tipoAmarillo.get(1), tipoAmarillo.get(2), tipoAmarillo.get(3));
        fichasAmarillo.setTipo(fichasAmarillo.FINAL);
    }

    public void inicializarTipos(){
        tipoAmarillo = parchis.getTipoAmarillo();
        tipoAzul = parchis.getTipoAzul();
        tipoRojo = parchis.getTipoRojo();
        tipoVerde = parchis.getTipoVerde();

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
