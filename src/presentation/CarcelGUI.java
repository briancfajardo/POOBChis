package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

    private String tipo1;
    private String tipo2;
    private String tipo3;
    private String tipo4;

    public CarcelGUI(Color color, Color color2, String col, Parchis parchis){
        this.col = col;
        this.parchis = parchis;
        this.color = color;
        this.cant = parchis.getCarcel(col);
        inicializarTipos();
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(color2);
        setVisible(true);
        fichas = new FichasGUI(col ,cant, tipo1, tipo2, tipo3, tipo4);
        fichas.setTipo(fichas.CARCEL);
    }

    public void inicializarTipos(){
        switch (col){
            case "Amarillo" -> {
                tipo1 = parchis.getTipoAmarillo().get(0);
                tipo2 = parchis.getTipoAmarillo().get(1);
                tipo3 = parchis.getTipoAmarillo().get(2);
                tipo4 = parchis.getTipoAmarillo().get(3);
            }
            case "Azul" -> {
                tipo1 = parchis.getTipoAzul().get(0);
                tipo2 = parchis.getTipoAzul().get(1);
                tipo3 = parchis.getTipoAzul().get(2);
                tipo4 = parchis.getTipoAzul().get(3);

            }
            case "Verde" -> {
                tipo1 = parchis.getTipoVerde().get(0);
                tipo2 = parchis.getTipoVerde().get(1);
                tipo3 = parchis.getTipoVerde().get(2);
                tipo4 = parchis.getTipoVerde().get(3);

            }
            default -> {
                tipo1 = parchis.getTipoRojo().get(0);
                tipo2 = parchis.getTipoRojo().get(1);
                tipo3 = parchis.getTipoRojo().get(2);
                tipo4 = parchis.getTipoRojo().get(3);
            }
        }
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
