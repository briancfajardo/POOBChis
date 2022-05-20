package presentation;

import domain.Parchis;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OpcionFichaGUI extends JFrame implements ActionListener {
    private Parchis parchis;
    private JButton boton1;
    private JButton boton2;
    private String color;
    private int num;

    private int x, y;
    private TableroGUI tablero;

    public OpcionFichaGUI(TableroGUI tablero, int x, int y) {
        this.tablero = tablero;
        parchis = tablero.getParchis();
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
    private void ReproducirSonido(String nombreSonido){
        try {
            //"src/audios/dados.wav";

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido. " + ex);
        }
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
        if (parchis.getValor3() > 0 && !parchis.isMataFicha() && !parchis.isSacaFicha()) {
            parchis.moverFicha(color, num);
            ReproducirSonido("src/audios/fichas1.wav");
        }

        tablero.juego();
        this.dispose();
    }
}
