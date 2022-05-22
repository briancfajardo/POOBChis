package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class CarcelGUI extends JPanel implements Serializable {
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
        actualizarTipos();
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(color2);
        setVisible(true);
        fichas = new FichasGUI(col ,cant, tipo1, tipo2, tipo3, tipo4);
        //actualizar();
        fichas.setRolFicha(fichas.CARCEL);
    }

    public void actualizarTipos(){
        if(parchis.getTipo(col).size() == 4){
            tipo1 = parchis.getTipo(col).get(0);
            tipo2 = parchis.getTipo(col).get(1);
            tipo3 = parchis.getTipo(col).get(2);
            tipo4 = parchis.getTipo(col).get(3);
        } else if (parchis.getTipo(col).size() == 3){
            tipo1 = parchis.getTipo(col).get(0);
            tipo2 = parchis.getTipo(col).get(1);
            tipo3 = parchis.getTipo(col).get(2);
        }else if (parchis.getTipo(col).size() == 2){
            tipo1 = parchis.getTipo(col).get(0);
            tipo2 = parchis.getTipo(col).get(1);
        }else if (parchis.getTipo(col).size() == 1){
            tipo1 = parchis.getTipo(col).get(0);
        }

    }
    public void actualizarFichas(){
        fichas.setClase1(tipo1);
        fichas.setClase2(tipo2);
        fichas.setClase3(tipo3);
        fichas.setClase4(tipo4);
    }
    public void actualizar(){
        cant = parchis.getCarcel(col);
        actualizarTipos();
        actualizarFichas();
        fichas.setCant(cant);
        repaint();
    }

    public void actualizarParchis(Parchis parchis){
        this.parchis = parchis;
        //repaint();
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
