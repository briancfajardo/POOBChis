package presentation;

import domain.Parchis;
import domain.ParchisException;
import domain.Tablero;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


public class eleccionJugadorConfig extends JFrame {
    private int ancho = 900;
    private int alto = 500;

    private eleccionJugadorConfig.Fondo fondo = new eleccionJugadorConfig.Fondo();
    private int cantJugadores;
    private GridBagLayout grid = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();
    private JLabel titulo;

    private ArrayList<String> tiposRojo = new ArrayList<>();
    private ArrayList<String> tiposAmarillo = new ArrayList<>();
    private ArrayList<String> tiposVerde = new ArrayList<>();
    private ArrayList<String> tiposAzul = new ArrayList<>();

    private String usuarioRojo, usuarioAmarillo, usuarioVerde, usuarioAzul;

    /**
     * Constructor de la clase KalahGUI
     */
    public eleccionJugadorConfig(int cantJugadores){
        this.cantJugadores = cantJugadores;
        this.setContentPane(fondo);
        setTitle("Escoger el jugador que se configurará");
        prepareElements();
        prepareActions();
        setVisible(true);

    }

    /**
     * Prepara los elementos de la ventana inicial
     * Modifica el tamaño y añade el menú y los botones iniciales
     */
    private void prepareElements(){
        setLayout(grid);
        constraints.fill = GridBagConstraints.BOTH;
        setSize(ancho,alto);
        tituloConfig();
        prepareElementsBeginning();
        botonAceptar();
    }

    public void setTipo(String color, ArrayList<String> tipos){
        switch (color){
            case "Amarillo" -> setTiposAmarillo(tipos);
            case "Azul" -> setTiposAzul(tipos);
            case "Verde" -> setTiposVerde(tipos);
            case "Rojo" -> setTiposRojo(tipos);
        }
    }

    private void setTiposRojo(ArrayList<String> tiposRojo){
        this.tiposRojo = tiposRojo;
    }
    private void setTiposAmarillo(ArrayList<String> tiposAmarillo){
        this.tiposAmarillo = tiposAmarillo;
    }

    private void setTiposVerde(ArrayList<String> tiposVerde){
        this.tiposVerde = tiposVerde;
    }

    private void setTiposAzul(ArrayList<String> tiposAzul){
        this.tiposAzul = tiposAzul;
    }

    public void setNombre(String color, String nombre){
        switch (color){
            case "Amarillo" -> usuarioAmarillo = nombre;
            case "Azul" -> usuarioAzul = nombre;
            case "Verde" -> usuarioVerde = nombre;
            case "Rojo" -> usuarioRojo = nombre;
        }
    }


    /**
     * Prepara los elementos necesarios para los botones principales
     * dentro de la pantalla de inicio, incluyendo el título y dos botones
     *
     * Le agrega a cada botón su propio oyente para que realiza el evento
     * correspondiente
     */

    private void tituloConfig(){
        constraints.gridx = 0;
        constraints.gridwidth = 8;
        constraints.gridheight = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        titulo = new JLabel();
        Font letra = new Font("Sans Serif", Font.CENTER_BASELINE, 30);
        titulo.setFont(letra);
        titulo.setText("Escoger el jugador que se configurará");
        titulo.setForeground(new Color(0, 248, 103));
        add(titulo, constraints);
    }

    private void prepareElementsBeginning(){
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.BOTH;
        FormatoJugador formato1 = new FormatoJugador(this);

        if(cantJugadores == 4){
            JPanel panelBotones = new JPanel();
            Button jugador1 = new Button("Jugador Rojo");
            Button jugador2 = new Button("Jugador Amarillo");
            Button jugador3 = new Button("Jugador Azul");
            Button jugador4 = new Button("Jugador Verde");

            jugador1.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
            jugador1.setBackground(new Color(120, 222, 167));
            jugador1.setSize(30,30);
            jugador1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jugador1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formato1.setColor("Rojo");
                    formato1.setVisible(true);
                    formato1.setResizable(false);
                    formato1.setLocationRelativeTo(null);
                    dispose();
                }
            });

            jugador2.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
            jugador2.setBackground(new Color(120, 222, 167));
            jugador2.setSize(30,30);
            jugador2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jugador2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formato1.setColor("Amarillo");
                    formato1.setVisible(true);
                    formato1.setResizable(false);
                    formato1.setLocationRelativeTo(null);
                    dispose();
                }
            });

            jugador3.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
            jugador3.setBackground(new Color(120, 222, 167));
            jugador3.setSize(30,30);
            jugador3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jugador3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formato1.setColor("Azul");
                    formato1.setVisible(true);
                    formato1.setResizable(false);
                    formato1.setLocationRelativeTo(null);
                    dispose();
                }
            });

            jugador4.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
            jugador4.setBackground(new Color(120, 222, 167));
            jugador4.setSize(30,30);
            jugador4.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jugador4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formato1.setColor("Verde");
                    formato1.setVisible(true);
                    formato1.setResizable(false);
                    formato1.setLocationRelativeTo(null);
                    dispose();
                }
            });


            panelBotones.setBorder(new CompoundBorder(new EmptyBorder(100,1000,30,1000),
                    new TitledBorder("")));
            panelBotones.setLayout(new GridLayout(1,2));
            panelBotones.add(jugador1);
            panelBotones.add(jugador2);
            panelBotones.add(jugador3);
            panelBotones.add(jugador4);
            panelBotones.setOpaque(false);

            setLayout(new FlowLayout());

            add(panelBotones);
        }else {
            JPanel panelBotones = new JPanel();
            Button jugador1 = new Button("Jugador Rojo");
            Button jugador2 = new Button("Jugador Amarillo");

            jugador1.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
            jugador1.setBackground(new Color(120, 222, 167));
            jugador1.setSize(30,30);
            jugador1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jugador1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formato1.setColor("Rojo");
                    formato1.setVisible(true);
                    formato1.setResizable(false);
                    formato1.setLocationRelativeTo(null);
                    dispose();
                }
            });

            jugador2.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
            jugador2.setBackground(new Color(120, 222, 167));
            jugador2.setSize(30,30);
            jugador2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jugador2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    formato1.setColor("Amarillo");
                    formato1.setVisible(true);
                    formato1.setResizable(false);
                    formato1.setLocationRelativeTo(null);
                    dispose();
                }
            });

            tiposAzul.add("Borde");
            tiposAzul.add("Borde");
            tiposAzul.add("Borde");
            tiposAzul.add("Borde");

            tiposVerde.add("Borde");
            tiposVerde.add("Borde");
            tiposVerde.add("Borde");
            tiposVerde.add("Borde");

            panelBotones.setBorder(new CompoundBorder(new EmptyBorder(100,1000,30,1000),
                    new TitledBorder("")));
            panelBotones.setLayout(new GridLayout(1,2));
            panelBotones.add(jugador1);
            panelBotones.add(jugador2);
            panelBotones.setOpaque(false);

            setLayout(new FlowLayout());

            add(panelBotones);
        }


    }

    private void verificarTam() throws ParchisException {
        if (cantJugadores == 4 && tiposRojo.size() != 4 && tiposAmarillo.size() != 4 && tiposVerde.size() != 4 && tiposAzul.size() != 4){
            throw new ParchisException(ParchisException.FALTA_CONFIGURACION);
        }
        if (cantJugadores == 2 && tiposRojo.size() != 4 && tiposAmarillo.size() != 4){
            System.out.println(tiposRojo);
            System.out.println(tiposAmarillo);
            throw new ParchisException(ParchisException.FALTA_CONFIGURACION);
        }
    }

    private void botonAceptar(){
        constraints.gridx = 0;
        constraints.gridwidth = 8;
        constraints.gridheight = 2;
        constraints.gridy = 700;

        JButton aceptar = new JButton("Aceptar configuraciones");
        aceptar.setFont(new Font("Sans Serif", Font.CENTER_BASELINE, 20));
        aceptar.setBackground(new Color(72, 159, 113));
        aceptar.setSize(30,30);
        aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(aceptar, constraints);
        aceptar.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {try {
                verificarTam();
                TableroGUI nuevaPartida = new TableroGUI(tiposAmarillo, tiposAzul, tiposVerde, tiposRojo, cantJugadores,
                        usuarioAmarillo, usuarioAzul, usuarioVerde, usuarioRojo);
                nuevaPartida.setResizable(false);
                nuevaPartida.setLocationRelativeTo(null);
                dispose();
            }catch (ParchisException p){
                System.out.println(p.getMessage());
            }}
        });
        add(aceptar);

    }


    /**
     * Modifica la acción de cerrar
     */
    private void prepareActions() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    class Fondo extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagenes/Fondo2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

            setOpaque(false);

            super.paint(g);
        }
    }

}
