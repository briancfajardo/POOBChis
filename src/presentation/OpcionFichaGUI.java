package presentation;

import domain.Parchis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OpcionFichaGUI extends JFrame implements ActionListener {
    private Parchis parchis;
    private JButton boton1;
    private JButton boton2;
    private String color;
    private int num, val1, val2;

    private int x, y;

    public OpcionFichaGUI(Parchis parchis, int x, int y) {
        this.parchis = parchis;
        this.x = x;
        this.y = y;
        setTitle("Escoge la cantidad que quieres mover");
        prepareElements();
        prepareActions();

    }

    private void prepareElements() {
        setSize(150, 80);
        setLocation(x, y-80);
        setLayout(new GridLayout(1, 2));
        boton1 = new JButton(parchis.getValor1() + "");
        boton2 = new JButton(parchis.getValor2() + "");

        boton1.addActionListener(this);
        boton2.addActionListener(this);

        add(boton1);
        add(boton2);
        //System.out.println(parchis.isMov1());
        //System.out.println(parchis.isMov2());

        if (parchis.isMov1() && !parchis.isMov2()){
            boton1.setEnabled(false);
        }else if (!parchis.isMov1() && parchis.isMov2()) {
            boton2.setEnabled(false);
        }else if (parchis.isMov1() && parchis.isMov2()) {
            boton2.setEnabled(false);
            boton1.setEnabled(false);
        }
    }

    private void prepareActions() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void moverFicha(String color, int num) {
        setVisible(true);
        this.color = color;
        this.num = num;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            parchis.setValor3(parchis.getValor1());
            parchis.setMov1(true);
        }
        if (e.getSource() == boton2) {
            parchis.setValor3(parchis.getValor2());
            parchis.setMov2(true);
        }

        if (parchis.getValor3() > 0) {
            parchis.moverFicha(color, num);
        }

        this.dispose();
    }
}
